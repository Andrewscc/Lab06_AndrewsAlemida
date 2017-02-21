package Central_de_Games;

import java.util.HashSet;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class Jogo {
	/**
	 * Classe que representa um jogo na loja
	 * 
	 * @author Andrews
	 */

	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogadas;
	private int qtdZermentos;
	private HashSet<Jogabilidade> jogabilidade;
	private Tipo tipo;
	public static final String NL = System.lineSeparator();

	/**
	 * Construtor de classe instancia jogo lançando exceções para parametros
	 * nulos, vazios ou valores menores que zero
	 * 
	 * @param nome
	 * @param preco
	 * @param tipo
	 * @throws ParametroNumeroNegativo
	 * @throws ParametroNuloOuVazio
	 */

	public Jogo(String nome, double preco, Tipo tipo) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		if (nome == null || nome.trim().equals(""))
			throw new ParametroNuloOuVazio("Nome não pode ser nulo ou vazio");
		this.nome = nome;
		if (preco < 0)
			throw new ParametroNumeroNegativo("Valor não pode ser negativo");
		this.preco = preco;
		this.maiorScore = 0;
		this.tipo = tipo;
		this.qtdJogadas = 0;
		this.qtdZermentos = 0;
		this.jogabilidade = new HashSet<>();
	}

	/**
	 * Retorna a String nome atribuiada a instancia jogo
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui um nome a uma instancia da classe lançando exceção para
	 * parametros nulos ou vazios
	 * 
	 * @param nome
	 * @throws ParametroNuloOuVazio
	 */
	public void setNome(String nome) throws ParametroNuloOuVazio {
		if (nome == null || nome.trim().equals(""))
			throw new ParametroNuloOuVazio("Nome não pode ser nulo ou vazio");
		this.nome = nome;
	}

	/**
	 * Retorna o valor do preço atribuido a instancia da classe que o chamou
	 * 
	 * @return
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Atribui um valor valido, maior que zero a uma instancia da classe,
	 * lançando exceção caso o valor seja negativo
	 * 
	 * @param preco
	 * @throws ParametroNumeroNegativo
	 */
	public void setPreco(double preco) throws ParametroNumeroNegativo {
		if (preco < 0)
			throw new ParametroNumeroNegativo("Valor não pode ser negativo");
		this.preco = preco;
	}

	/**
	 * Retorna o maior Score atingido pela instancia da classe que o chamou
	 * 
	 * @return
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * Atribui novo valor de Score máximo, lançando exceção em caso de valor
	 * invalido
	 * 
	 * @param maiorScore
	 * @throws ParametroNumeroNegativo
	 */
	public void setMaiorScore(int maiorScore) throws ParametroNumeroNegativo {
		if (maiorScore < 0)
			throw new ParametroNumeroNegativo("Valor não pode ser negativo");
		this.maiorScore = maiorScore;
	}

	/**
	 * Retorma quantas vezes o jogo foi jogado
	 * 
	 * @return
	 */
	public int getQtdJogadas() {
		return qtdJogadas;
	}

	/**
	 * Retorna numero de zeramentos do jogo
	 * 
	 * @return
	 */
	public int getQtdZermentos() {
		return qtdZermentos;
	}

	/**
	 * Atribui uma nova quantidade de zeramento, lançando exerção caso o
	 * paramento seja inválido
	 * 
	 * @param qtdZermentos
	 * @throws ParametroNumeroNegativo
	 */
	public void setQtdZermentos(int qtdZermentos) throws ParametroNumeroNegativo {
		if (qtdZermentos < 0)
			throw new ParametroNumeroNegativo("Valor não pode ser negativo");
		this.qtdZermentos = qtdZermentos;
	}

	/**
	 * Retorna o Tipo do jogo(RPG, Plataforma e luta)
	 * 
	 * @return
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Recebe o score da partida do jogo e a informação de zerou ou não,
	 * retornando o valor do x2p conquistado. Lança exceção nos casos de valores
	 * inválidos
	 * 
	 * @param score
	 * @param zerou
	 * @return
	 * @throws ParametroNumeroNegativo
	 */
	public int registraJogada(int score, boolean zerou) throws ParametroNumeroNegativo {
		boolean novoScore;
		this.qtdJogadas++;
		if (zerou)
			this.setQtdZermentos(1);
		if (this.getMaiorScore() < score) {
			this.setMaiorScore(score);
			novoScore = true;
		} else {
			novoScore = false;
		}
		if (this.getTipo().equals(Tipo.Rpg))
			return 10;
		else if (this.getTipo().equals(Tipo.Luta) && novoScore)
			return score / 1000;
		else if (this.getTipo().equals(Tipo.Plataforma) && zerou)
			return 20;
		else
			return 0;

	}

	public void addJogabilidade(Jogabilidade jogabilidade) {
		this.jogabilidade.add(jogabilidade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "+ " + this.nome + " - " + this.tipo + NL + "==> Jogou " + this.getQtdJogadas() + " vez(es)" + NL
				+ " ==> Zerou " + this.getQtdZermentos() + " vez(es)" + NL + " ==> Maior score: "
				+ this.getMaiorScore();
	}

}

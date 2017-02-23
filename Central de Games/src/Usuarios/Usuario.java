package Usuarios;

import java.util.ArrayList;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;
import Jogo.Jogo;

public abstract class Usuario {

	/***
	 * Super classe de Usuario
	 * 
	 * @author Andrews
	 */

	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogosComprados;
	protected double dinheiro;
	protected int x2p;
	public static final String NL = System.lineSeparator();

	/**
	 * Construtor da classe instancia um usuario por default com x2p,dinheiro
	 * iguais a zero. Lan�a exce��o para strings nulas ou vazias
	 * 
	 * @param nome
	 * @param login
	 * @throws Exception
	 */
	public Usuario(String nome, String login) throws ParametroNuloOuVazio {
		if (nome == null || nome.trim().equals("")) {
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		}
		this.nome = nome;
		if (login == null || login.trim().equals("")) {
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		}
		this.login = login;
		this.dinheiro = 0;
		this.jogosComprados = new ArrayList<>();

	}

	/**
	 * Retorna nome do usuario
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui um novo nome ao usuario, se nulo ou invalido lan�a exce��o
	 * 
	 * @param nome
	 * @throws Exception
	 */
	public void setNome(String nome) throws ParametroNuloOuVazio {
		if (nome == null || nome.trim().equals("")) {
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		}
		this.nome = nome;
	}

	/**
	 * Retorna um ArrayList dos jogos j� comprados pelo usu�rio
	 * 
	 * @return
	 */
	public ArrayList<Jogo> getJogos() {
		return jogosComprados;
	}

	public void setJogosComprados(ArrayList<Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
	}

	/**
	 * Adiciona um jogo a cole��o de jogos do usu�rio
	 * 
	 * @param novoJogo
	 * @return
	 */
	public boolean AdicionaJogo(Jogo novoJogo) {
		if (!this.getJogos().contains(novoJogo)) {
			this.getJogos().add(novoJogo);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna o valor de dinheiro do usu�rio
	 * 
	 * @return
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * Atribui uma quantidade de dinheiro ao usu�rio, lan�ando exce��o se
	 * parametro passado for inv�lido
	 * 
	 * @param dinheiro
	 * @throws Exception
	 */
	public void setDinheiro(double dinheiro) throws ParametroNumeroNegativo {
		if (dinheiro < 0)
			throw new ParametroNumeroNegativo("Valor n�o pode ser negativo");
		this.dinheiro = dinheiro;
	}

	/**
	 * Retorna o valor de experi�ncia x2p do usu�ro
	 * 
	 * @return
	 */
	public int getX2p() {
		return x2p;
	}

	/**
	 * Adiciona experi�ncia x2p ao usuario, lan�ando exce��o caso parametro seja
	 * inv�lido
	 * 
	 * @param x2p
	 * @throws Exception
	 */
	public void setX2p(int x2p) throws ParametroNumeroNegativo {
		if (x2p < 0)
			throw new ParametroNumeroNegativo("Valor n�o pode ser negativo");
		this.x2p = this.getX2p() + x2p;
	}

	/**
	 * retorna login do usu�rio
	 * 
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Atribui um novo login ao usu�rio, lan�ando exce��o no caso de parametro
	 * nulo ou vazio
	 * 
	 * @param login
	 * @throws Exception
	 */
	public void setLogin(String login) throws ParametroNuloOuVazio {
		if ( login == null || login.trim().equals("")) {
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		}
		this.login = login;
	}

	/**
	 * Adiciona x2p ao usuario, dependendo do desempenho do mesmo no jogo, chama
	 * metodo definido na classe Jogo, lan�ando exce��es para parametros nulos,
	 * vazio ou inv�lidos
	 * 
	 * @param nomeJogo
	 * @param score
	 * @param zerou
	 * @throws ParametroNumeroNegativo
	 * @throws ParametroNuloOuVazio
	 */
	public void registraJogada(String nomeJogo, int score, boolean zerou)
			throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		if ( nomeJogo == null || nomeJogo.trim().equals(""))
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		Jogo novoJogo = this.getJogo(nomeJogo);
		if (score < 0)
			throw new ParametroNumeroNegativo("Valor n�o pode ser negativo");
		this.setX2p(novoJogo.registraJogada(score, zerou));
	}

	/**
	 * Assinatura de metodo abstrato, definido na classe que a herda,
	 * respons�vel por adicionar um jogo na cola��o de jogos do usu�rio, caso
	 * ele j� n�o o tenha, e lan�ando exce��es para parametros nulos, vazio e
	 * invalidos
	 * 
	 * @param novoJogo
	 * @throws ParametroNumeroNegativo
	 * @throws ParametroNuloOuVazio
	 */
	public abstract void Comprar(Jogo novoJogo) throws ParametroNumeroNegativo, ParametroNuloOuVazio;

	/**
	 * Assinatura de m�todo abstrato, definido na classe que a herda,
	 * responsavel por calcular a experi�ncia x2p por compra de jogo efetuada
	 * pelo usu�rio
	 * 
	 * @param novoJogo
	 * @throws ParametroNumeroNegativo
	 */
	public abstract void x2pPorCompra(Jogo novoJogo) throws ParametroNumeroNegativo;

	/**
	 * Retorna uma instancia da classe Jogo, caso exista na cole��o do usu�rio,
	 * recebendo a String do nome e lan�ando exce��o caso a mesma seja nula ou
	 * vazia
	 * 
	 * @param nomeJogo
	 * @return
	 * @throws ParametroNuloOuVazio
	 */
	private Jogo getJogo(String nomeJogo) throws ParametroNuloOuVazio {
		if (nomeJogo == null || nomeJogo.trim().equals(""))
			throw new ParametroNuloOuVazio("Nome n�o pode ser nulo ou vazio");
		for (Jogo novoJogo : jogosComprados) {
			if (novoJogo.getNome().equalsIgnoreCase(nomeJogo))
				return novoJogo;
		}
		return null;
	}

	/**
	 * Retorna o valor gasto pelo usuario na compra de jogos
	 * 
	 * @return
	 */
	public double getTotalPreco() {
		double total = 0;
		for (Jogo jogo : jogosComprados) {
			total += jogo.getPreco();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public abstract String toString();
}

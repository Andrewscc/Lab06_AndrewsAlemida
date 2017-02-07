import java.util.HashSet;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogadas;
	private int qtdZermentos;
	private HashSet jogabilidade;

	public Jogo(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdJogadas = 0;
		this.qtdZermentos = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQtdJogadas() {
		return qtdJogadas;
	}

	public void setQtdJogadas(int qtdJogadas) {
		this.qtdJogadas = qtdJogadas;
	}

	public int getQtdZermentos() {
		return qtdZermentos;
	}

	public void setQtdZermentos(int qtdZermentos) {
		this.qtdZermentos = qtdZermentos;
	}

	public int registraJogada(int score, boolean zerou) {
		if (this.getMaiorScore() < score) {
			this.setMaiorScore(score);
		}
		return score;
	}
}

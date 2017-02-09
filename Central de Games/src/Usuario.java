import java.util.ArrayList;

public class Usuario {

	protected String nome;
	protected ArrayList jogosComprados;
	protected double dinheiro;
	protected int x2p;

	public Usuario(String nome) {
		this.nome = nome;
		this.x2p = 0;
		this.jogosComprados = new ArrayList<Jogo>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList getJogos() {
		return jogosComprados;
	}

	public boolean AdicionaJogo(Jogo novoJogo) {
		if (!this.getJogos().contains(novoJogo)) {
			this.getJogos().add(novoJogo);
			return true;
		} else {
			return false;
		}
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public void registraJogada(String nomeJogo, int score, int zerou) {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}

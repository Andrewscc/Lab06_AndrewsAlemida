
public class Noob extends Usuario {

	private static final String TIPO = "Noob";

	public Noob(String nome) {
		super(nome);

	}

	public boolean Comprar(Jogo jogo) {
		if (this.getDinheiro() >= jogo.getPreco() * 0.9 || !this.getJogos().contains(jogo)) {
			this.setDinheiro(this.getDinheiro() - jogo.getPreco() * 0.9);
			this.x2pPorCompra(jogo);
			return this.AdicionaJogo(jogo);
		} else {
			return false;
		}

	}

	public String getTipo() {
		return this.TIPO;
	}

	public void x2pPorCompra(Jogo novoJogo) {
		this.setX2p((int) (novoJogo.getPreco() * 10));
	}

}

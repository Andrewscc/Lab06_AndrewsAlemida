
public class Veterano extends Usuario {

	private static final String TIPO = "Veterano";

	public Veterano(String nome) {
		super(nome);
		this.x2p = 1000;
	}

	public boolean Comprar(Jogo jogo) {
		if (this.getDinheiro() >= jogo.getPreco() * 0.8 || !this.getJogos().contains(jogo)) {
			this.setDinheiro(this.getDinheiro() - jogo.getPreco() * 0.8);
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
		this.setX2p((int) (novoJogo.getPreco() * 15));
	}
}

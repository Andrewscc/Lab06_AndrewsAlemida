package Central_de_Games;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class Noob extends Usuario {
	public static final String NL = System.lineSeparator();

	public Noob(String nome, String login) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		super(nome, login);
		this.x2p = 0;

	}

	@Override
	public void Comprar(Jogo novoJogo) throws ParametroNumeroNegativo, ParametroNuloOuVazio {
		if (this.getDinheiro() >= novoJogo.getPreco() * 0.9 || !this.getJogos().contains(novoJogo)) {
			this.setDinheiro(this.getDinheiro() - novoJogo.getPreco() * 0.9);
			this.x2pPorCompra(novoJogo);
			this.AdicionaJogo(novoJogo);
		}

	}

	@Override
	public void x2pPorCompra(Jogo novoJogo) throws ParametroNumeroNegativo {
		this.setX2p((int) (novoJogo.getPreco() * 10));
	}

	@Override
	public String toString() {
		String msg = this.login + NL + this.nome + " - " + "Jogador " + "Noob" + NL + "Lista de Jogos: " + NL;
		for (Jogo jogo : jogosComprados) {
			msg += jogo.toString() + NL;
		}
		msg += NL + "Total de preço dos jogos: R$" + this.getTotalPreco();

		return msg;
	}

}

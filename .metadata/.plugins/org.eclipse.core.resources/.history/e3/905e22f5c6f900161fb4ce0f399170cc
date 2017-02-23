package Central_de_Games;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class Veterano extends Usuario {
	public static final String NL = System.lineSeparator();

	public Veterano(String nome, String login) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		super(nome, login);
		this.x2p = 1000;

	}

	@Override
	public void Comprar(Jogo jogo) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		if (this.getDinheiro() >= jogo.getPreco() * 0.8 || !this.getJogos().contains(jogo)) {
			this.setDinheiro(this.getDinheiro() - jogo.getPreco() * 0.8);
			this.x2pPorCompra(jogo);
			this.AdicionaJogo(jogo);
		}

	}

	@Override
	public void x2pPorCompra(Jogo novoJogo) throws ParametroNumeroNegativo {
		this.setX2p((int) (novoJogo.getPreco() * 15));
	}

	@Override
	public String toString() {
		String msg = this.login + NL + this.nome + " - " + "Jogador " + "Veterano" + NL + "Lista de Jogos: " + NL;
		for (Jogo jogo : jogosComprados) {
			msg += jogo.toString() + NL;
		}
		msg += NL + "Total de preço dos jogos: R$" + this.getTotalPreco();

		return msg;
	}
}

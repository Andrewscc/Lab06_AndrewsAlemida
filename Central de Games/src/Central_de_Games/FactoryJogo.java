package Central_de_Games;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class FactoryJogo {

	public Jogo criaJogo(String nome, double preco, Tipo tipo) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		return new Jogo(nome, preco, tipo);
	}

}

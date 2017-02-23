package Factorys;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;
import Jogo.Jogo;
import Jogo.Tipo;

public class FactoryJogo {

	public Jogo criaJogo(String nome, double preco, Tipo tipo) throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		return new Jogo(nome, preco, tipo);
	}

}

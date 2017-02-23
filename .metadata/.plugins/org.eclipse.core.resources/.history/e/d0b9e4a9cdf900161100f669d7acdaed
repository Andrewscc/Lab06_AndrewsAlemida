package testesCentralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Central_de_Games.Jogo;
import Central_de_Games.Tipo;
import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class TestaJogo {

	Jogo j1;

	@Before
	public void setUp() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Jogo j1 = new Jogo("Devil may cry", 150, Tipo.Plataforma);
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaNomeNulo() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Jogo j2 = new Jogo(null, 100, Tipo.Luta);
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaNomeVazio() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Jogo j2 = new Jogo("", 100, Tipo.Plataforma);
	}

	@Test(expected = ParametroNumeroNegativo.class)
	public void testaPrecoNegativo() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Jogo j2 = new Jogo("God of War", -1, Tipo.Plataforma);
	}

	@Test
	public void testaRegistraJogada() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Jogo j2 = new Jogo("Super Mario World", 30, Tipo.Plataforma);
		assertEquals(20, j2.registraJogada(2000, true));
		assertEquals(0, j2.registraJogada(2000, false));
		Jogo j3 = new Jogo("Guilty Gears", 50, Tipo.Luta);
		assertEquals(2, j3.registraJogada(2000, false));
		assertEquals(0, j3.registraJogada(999, false));
		assertEquals(0, j3.registraJogada(0, false));
		Jogo j4 = new Jogo("Final Fantasy", 80, Tipo.Rpg);
		assertEquals(10, j4.registraJogada(0, true));
		assertEquals(10, j4.registraJogada(99999999, false));

	}
}

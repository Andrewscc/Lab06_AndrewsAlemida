package testesCentralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Central_de_Games.Noob;
import Central_de_Games.Usuario;
import Central_de_Games.Veterano;
import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;

public class TestaUsuario {

	Usuario n1;

	@Before
	public void setUp() throws Exception {
		Noob n1 = new Noob("carlos", "carlinhos_cachoeira");
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaNomeNulo() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Veterano v1 = new Veterano(null, "loginValido");

	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaLoginNulo() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Noob n2 = new Noob("NomeValido", null);
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaNomeVazio() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Noob n2 = new Noob("", "loginValido");
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaLoginVazio() throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		Veterano v1 = new Veterano("NomeValido", "");
	}

	@Test(expected = ParametroNumeroNegativo.class)
	public void testaSetDinheiroNegativo() throws ParametroNumeroNegativo {
		n1.setDinheiro(-1);
	}

	@Test(expected = ParametroNumeroNegativo.class)
	public void testaSetX2pNegativo() throws ParametroNumeroNegativo {
		n1.setX2p(-1);
	}

	@Test(expected = ParametroNuloOuVazio.class)
	public void testaSetLoginNulo() throws ParametroNuloOuVazio {
		n1.setLogin(null);
	}

}

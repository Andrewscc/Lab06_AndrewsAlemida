package testesCentralDeGames;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Central_de_Games.LojaController;
import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;
import Jogo.Tipo;
import Usuarios.Noob;
import Usuarios.Veterano;
import junit.framework.Assert;

public class TestaLoja {

	private LojaController loja;
	private Noob n1;

	@Before
	public void setUP() throws Exception {
		loja = new LojaController();
		n1 = new Noob("Matheus", "matheus.Gaudencio");

	}

	@Test
	public void testaAdicionaUsuario() {
		assertEquals(0, loja.getListaUsuarios().size());
		loja.adicionaUsuario(n1);
		assertTrue(loja.getListaUsuarios().contains(loja.usuarioPorLogin("matheus.Gaudencio")));
	}

	@Test
	public void testaAdicionaUsuarioComException() {
		assertEquals(0, loja.getListaUsuarios().size());
		Noob n2 = null;
		loja.adicionaUsuario(n2);
		loja.adicionaUsuario(n1);
		assertTrue(loja.getListaUsuarios().contains(n1));
		loja.adicionaUsuario(n1);
		assertEquals(1, loja.getListaUsuarios().size());

	}

	@Test
	public void testaAdicionarDinheiro() {
		loja.adicionaUsuario(n1);
		assertEquals(0.0, n1.getDinheiro(), 0.0001);
		loja.adicionaDinheiro(n1.getLogin(), 500);
		assertEquals(500.00, n1.getDinheiro(), 0.0001);
	}

	@Test
	public void testaAdicionarDinheiroComException() {
		loja.adicionaUsuario(n1);
		assertEquals(0.0, n1.getDinheiro(), 0.0001);
		loja.adicionaDinheiro(n1.getLogin(), 0);
		assertEquals(0.0, n1.getDinheiro(), 0.0001);
		loja.adicionaDinheiro(n1.getLogin(), -1);
		assertEquals(0.0, n1.getDinheiro(), 0.0001);

	}

	@Test
	public void testaVenderJogo(){
		loja.adicionaUsuario(n1);
		loja.adicionaDinheiro("matheus.Gaudencio", 1000);
		loja.venderJogo("matheus.Gaudencio", "Final Fnatasy", 200, Tipo.Rpg );
		assertEquals(1,n1.getJogos().size());
	}
	@Test
	public void testaUpgrade() throws Exception {
		loja.adicionaUsuario(n1);
		Assert.assertTrue(Noob.class.isInstance(n1));
		loja.adicionaDinheiro("matheus.Gaudencio", 200);
		assertEquals(200, n1.getDinheiro(), 0.0001);
		loja.usuarioPorLogin("matheus.Gaudencio").setX2p(1000);
		loja.upgrade("matheus.Gaudencio");
		assertTrue(Veterano.class.isInstance(loja.usuarioPorLogin("matheus.Gaudencio")));

	}

}

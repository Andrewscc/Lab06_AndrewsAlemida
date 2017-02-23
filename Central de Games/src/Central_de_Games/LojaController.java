package Central_de_Games;

import java.util.ArrayList;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;
import Exceptions.UsuarioJaCadastrado;
import Factorys.FactoryDeUsuario;
import Factorys.FactoryJogo;
import Jogo.Jogo;
import Jogo.Tipo;
import Jogo.Jogabilidade;
import Usuarios.Usuario;
import Usuarios.Veterano;
import Usuarios.Noob;

public class LojaController {

	private ArrayList<Usuario> listaUsuarios;
	public final String NL = System.lineSeparator();
	private FactoryJogo constroiJogo;
	private FactoryDeUsuario criadorUsuario;

	public LojaController() {

		/**
		 * Classe que representa a loja
		 * 
		 * @author Andrews
		 */
		this.listaUsuarios = new ArrayList<>();
		this.constroiJogo = new FactoryJogo();
		this.criadorUsuario = new FactoryDeUsuario();
	}
	/**
	 * Adiciona um usu�rio a loja caso ele ainda n�o esteja, lan�ando exce��o se
	 * j� for cadastrado na loja ou seo m�todo receber parametros inv�lidos
	 * 
	 * @param novoUsuario
	 * @throws ParametroNumeroNegativo
	 * @throws ParametroNuloOuVazio
	 * @throws UsuarioJaCadastrado
	 */
	public void adicionaUsuario(String nome, String login, String tipoDeUsuario)
			throws ParametroNuloOuVazio, ParametroNumeroNegativo, UsuarioJaCadastrado {
		Usuario novoUsuario = criadorUsuario.criaUsuario(nome, login, tipoDeUsuario);
		if (novoUsuario == null) {
			throw new ParametroNuloOuVazio("Usuario não pode ser nulo");
		} else if (listaUsuarios.contains(novoUsuario)) {
			throw new UsuarioJaCadastrado("Usuario já cadastrado");
		} else {
			listaUsuarios.add(novoUsuario);
		}
	}

	/**
	 * Efetua busca de usu�rio por login,retornando uma instancia da classe
	 * usuario e lan�ando exce��o caso a string passada seja vazia ou nula
	 * 
	 * @param login
	 * @return
	 */
	public Usuario usuarioPorLogin(String login) {
		try {
			if (!login.trim().equals(""))
				for (Usuario novoUsuario : listaUsuarios)
					if (novoUsuario.getLogin().equals(login))
						return novoUsuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Adiciona dinheiro na conta de um usuario da loja, depende da
	 * implementa��o das classes herdeiras de Usuario, lan�a exce��o para
	 * parametro vazio ou nulo
	 * 
	 * @param login
	 * @param dinheiro
	 */
	public void adicionaDinheiro(String login, double dinheiro) {
		Usuario novoUsuario = usuarioPorLogin(login);
		try {
			novoUsuario.setDinheiro(dinheiro);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Vende uma copia do jogo para o usu�rio caso ele possua dinheiro na conta
	 * para compra-lo e adiciona a cole��o do usuario, lan�a exce��es para
	 * parametros inv�lidos
	 * 
	 * @param login
	 * @param nome
	 * @param preco
	 * @param tipo
	 * @throws ParametroNumeroNegativo
	 * @throws ParametroNuloOuVazio
	 */
	public void venderJogo(String login, String nome, double preco, Tipo tipo)
			throws ParametroNuloOuVazio, ParametroNumeroNegativo, Exception {

		Jogo novoJogo = constroiJogo.criaJogo(login, preco, tipo);
		Usuario novoUsuario = usuarioPorLogin(login);
		if (!novoUsuario.getJogos().contains(novoJogo) && novoUsuario.getDinheiro() >= novoJogo.getPreco()) {
			novoUsuario.Comprar(novoJogo);
		} else {
			throw new Exception("Usuario já possui jogo");
		}
	}

	/**
	 * Efetua migra��o de classe do usuario nos caso de ele j� haver atinjido a
	 * pontua��o de 1000 x2p, lan�ando exce��o caso o mesmo j� seja veterano ou
	 * os parametros passados sejam invalidos ou o mesmo n�o disponha de x2p
	 * suficiente
	 * 
	 * @param login
	 */
	public void upgrade(String login) {
		Usuario novoUsuario = usuarioPorLogin(login);
		try {
			if (novoUsuario.getX2p() >= 1000) {
				try {
					if (!Veterano.class.isInstance(novoUsuario)) {
						Veterano novoVeterano = new Veterano(novoUsuario.getNome(), novoUsuario.getLogin());
						novoVeterano.setDinheiro(novoUsuario.getDinheiro());
						novoVeterano.setX2p(novoUsuario.getX2p());
						novoVeterano.setJogosComprados(novoUsuario.getJogos());
						listaUsuarios.remove(novoUsuario);
						listaUsuarios.add(novoVeterano);
					} else {
						throw new Exception("Usuario j� � veterano");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new Exception("Usuario n�o possui pontos suficientes para upgrade");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public String toString() {
		String msg = "== Central P2-CG === " + NL + NL;
		for (Usuario novoUsuario : listaUsuarios) {
			msg += novoUsuario.toString() + NL;

		}
		msg += "--------------------------------------------" + NL;
		return msg;
	}
}

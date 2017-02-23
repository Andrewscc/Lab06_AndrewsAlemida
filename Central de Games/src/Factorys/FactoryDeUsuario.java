package Factorys;

import Exceptions.ParametroNuloOuVazio;
import Exceptions.ParametroNumeroNegativo;
import Usuarios.Noob;
import Usuarios.Usuario;
import Usuarios.Veterano;

public class FactoryDeUsuario {

	public Usuario criaUsuario(String nome, String login, String tipoDeUsuario)
			throws ParametroNuloOuVazio, ParametroNumeroNegativo {
		if (tipoDeUsuario.equals("Noob"))
			return new Noob(nome, login);
		else
			return new Veterano(nome, login);

	}

}

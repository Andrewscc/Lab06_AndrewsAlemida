package Central_de_Games;

import easyaccept.*;

public class LojaFacade {
	
	LojaController loja = new LojaController();

	public static void main(String[] args) {

		args = new String[] { "Central_de_Games.LojaFacade", "acceptance_teste/us1.txt" };
		EasyAccept.main(args);

	}

	public void criaUsuario(String nome, String login, String tipoDeUsuario) {
		
	}

}

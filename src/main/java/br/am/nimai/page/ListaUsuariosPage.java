package br.am.nimai.page;

import br.am.nimai.core.BasePage;

public class ListaUsuariosPage extends BasePage {
	
	public void clicarBotaoNovoUsuario() {
		clicarPorId("new-user");
		esperarElementoPorXpath("//form[@class='sc-eCImPb clIIUP']");
	}
	
	public void clicarBotaoApagarUsuario() {
		
	}
	
	public void clicarBotaoEditarUsuario() {
		
	}
	
}

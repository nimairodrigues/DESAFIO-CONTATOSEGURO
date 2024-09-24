package br.am.nimai.test;

import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.ListaUsuariosPage;

public class ListaUsuariosTest extends BaseTest{
	
	ListaUsuariosPage listaUsuariosPage = new ListaUsuariosPage();
	
	@Test
	public void test() throws InterruptedException {
		listaUsuariosPage.clicarBotaoNovoUsuario();
		Thread.sleep(3000);
	}
}

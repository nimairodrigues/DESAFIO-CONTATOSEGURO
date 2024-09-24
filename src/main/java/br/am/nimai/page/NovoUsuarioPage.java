package br.am.nimai.page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class NovoUsuarioPage extends BasePage {
	
	
	public void clicarBotaoSalvar() {
		clicarPorXpath("//button[@type='submit']");
	}
	
	public void escreverCampoNome(String nome) {
		escreverPorXpath("//input[@placeholder='Nome']", nome);
	}
	
	public void escreverCampoEmail(String email) {
		escreverPorXpath("//input[@placeholder='Email']", email);
	}
	
	public void escreverCampoTelefone(String telefone) {
		escreverPorXpath("//input[@placeholder='Telefone']", telefone);
	}
	
	public void escreverCampoCidade(String cidade) {
		escreverPorXpath("//input[@placeholder='Cidade de nascimento']", cidade);
	}
	
	public void criarUsuario(String nome, String email, String telefone, String cidade, int dia, int mes, int ano, String empresa) {
		escreverCampoNome("Nimai");
		escreverCampoEmail("nimaipandita@outlook.com");
		escreverCampoTelefone("83123456789");
		escreverCampoCidade("Manaus");
		escreverCampoData(0, 15, 1997);
		selecionarEmpresa("Empresa 1");
		
		clicarBotaoSalvar();
	}
	
	public void escreverCampoData(int dia, int mes, int ano) {
		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.set(1997, 0, 15);
		Date dataDate = dataCalendar.getTime();
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
		DriverFactory.getDriver().findElement(By.xpath("//input[@placeholder='Data de nascimento']")).sendKeys(formatoData.format(dataDate));
	}
	
	public void escreverStringCampoData(String dia, String mes, String ano) {
		escreverPorXpath("//input[@placeholder='Data de nascimento']", dia + mes + ano);
	}
	
	public void selecionarEmpresa(String empresa) {
		clicarPorId("multiselectContainerReact");
		clicarPorXpath("//*[@id='multiselectContainerReact']//li[text()='" + empresa + "']");
		clicarPorXpath("//input[@placeholder='Nome']");
	}
	
	public void clicarOKModal() {
		
	}
}

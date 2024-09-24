package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Método para clicar utilizando o ID através do xpath, porém, utilizando o método do XPATH para facilitar a manutenção
	public void clicarPorId(String id) {
		clicarPorXpath("//*[@id='"+ id + "']");
	}
	
	//Método para clicar utilizando o xpath
	public void clicarPorXpath(String xpath) {
		DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void escreverPorXpath(String xpath, String texto) {
		DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
	}
	
	public void esperarElementoPorXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	
}

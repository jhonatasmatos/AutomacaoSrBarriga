package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver navegador) {
		super(navegador);
	}
	
	public void acessarSistema() {
		navegador.get("https://srbarriga.herokuapp.com");		
	} 
	

	
	public void preencherEmaileSenha(String email, String senha) {
		navegador.findElement(By.id("email")).sendKeys(email);
	    navegador.findElement(By.id("senha")).sendKeys(senha);
	}
	
	public HomePage clicarEntrar() {
		navegador.findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
		
		return new HomePage(navegador);
	}

}

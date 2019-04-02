package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver navegador) {
		super(navegador);
	}
	
	public String mensagemHome() {
		String mensagemHome = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
		
		return mensagemHome;
	}
	
	public AdicionarContasPage acessarTelaAdicionarContas() {
		navegador.findElement(By.linkText("Contas")).click();
		navegador.findElement(By.linkText("Adicionar")).click();
		
		return new AdicionarContasPage(navegador);
	}

}

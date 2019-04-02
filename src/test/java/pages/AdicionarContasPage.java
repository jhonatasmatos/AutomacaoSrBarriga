package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarContasPage extends BasePage {

	public AdicionarContasPage(WebDriver navegador) {
		super(navegador);
	}
		
	public AdicionarContasPage incluirConta(String conta) {
		navegador.findElement(By.id("nome")).sendKeys(conta);
		navegador.findElement(By.xpath("//button[contains(text(), 'Salvar')]")).click();
		
		return this;
	}
	
	public String validarMensagem() {
		String mensagem = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
		
		return mensagem;
	}
}

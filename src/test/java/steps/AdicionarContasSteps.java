package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AdicionarContasSteps {
	
	private WebDriver navegador;
	
	@Dado("^que estou logado no sistema$")
	public void queEstouLogadoNoSistema() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhow\\drivers\\chromedriver.exe");
	    navegador = new ChromeDriver();
	    navegador.get("https://srbarriga.herokuapp.com");
	    
	    navegador.findElement(By.id("email")).sendKeys("jhonatas-teste@teste.com");
	    navegador.findElement(By.id("senha")).sendKeys("teste123");
	    
	    navegador.findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
	}

	@Quando("^incluo minha conta de \"([^\"]*)\"$")
	public void incluoMinhaContaDe(String conta) throws Throwable {
		navegador.findElement(By.linkText("Contas")).click();
		navegador.findElement(By.linkText("Adicionar")).click();
		navegador.findElement(By.id("nome")).sendKeys(conta);
		navegador.findElement(By.xpath("//button[contains(text(), 'Salvar')]")).click();
	}

	@Então("^devo ver a seguinte mensagem \"([^\"]*)\"$")
	public void devoVerASeguinteMensagem(String mensagem) throws Throwable {
	    String mensagemEsperada = "Conta adicionada com sucesso!";
		assertEquals(mensagemEsperada, mensagem);
	}
	
}

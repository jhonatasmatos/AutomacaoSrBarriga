package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {
	
	private WebDriver navegador;
	
	@Quando("^faço login com \"([^\"]*)\" e \"([^\"]*)\"$")
	public void façoLoginComE(String email, String senha) throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhow\\drivers\\chromedriver.exe");
	    navegador = new ChromeDriver();
	    navegador.get("https://srbarriga.herokuapp.com");
	    
	    navegador.findElement(By.id("email")).sendKeys(email);
	    navegador.findElement(By.id("senha")).sendKeys(senha);
	    
	    navegador.findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
	    
	}

	@Então("^sou autenticado com sucesso$")
	public void souAutenticadoComSucesso() throws Throwable {
	    navegador.findElement(By.linkText("Sair"));
	}

	@Então("^sou redirecionado para a home de contas com a mensagem \"([^\"]*)\"$")
	public void souRedirecionadoParaAHomeDeContasComAMensagem(String mensagemEsperada) throws Throwable {
	    String mensagemHome = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
	    assertEquals(mensagemEsperada, mensagemHome);
	}
}

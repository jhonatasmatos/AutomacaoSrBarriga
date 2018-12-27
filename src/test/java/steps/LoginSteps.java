package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.	selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {
	
	private WebDriver navegador;
	
	@Dado("^que acesso o sistema$")
	public void que_acesso_o_sistema() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\drivers\\chromedriver.exe");
	    navegador = new ChromeDriver();
	    navegador.get("https://srbarriga.herokuapp.com");
	}

	@Quando("^preencho \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preencho_e(String email, String senha) throws Throwable {
		navegador.findElement(By.id("email")).sendKeys(email);
	    navegador.findElement(By.id("senha")).sendKeys(senha);
	}

	@Quando("^clico em Entrar$")
	public void clico_em_Entrar() throws Throwable {
		navegador.findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
	}

	@Então("^devo ver a seguinte \"([^\"]*)\"$")
	public void devo_ver_a_seguinte(String mensagemEsperada) throws Throwable {
		String mensagemHome = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
		assertEquals(mensagemEsperada, mensagemHome);		
	}
	
	@After
	public void tearDown() {
		navegador.close();
	}
}

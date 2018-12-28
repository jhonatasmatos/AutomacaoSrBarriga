package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AdicionarContasSteps {
	
	private WebDriver navegador;
	
	
	@Before("@setupContas")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\drivers\\chromedriver.exe");
	    navegador = new ChromeDriver();
	    navegador.manage().window().maximize();
	}
	
	@Dado("^que estou logado no sistema$")
	public void queEstouLogadoNoSistema() throws Throwable {
	    navegador.get("https://srbarriga.herokuapp.com");
	    
	    navegador.findElement(By.id("email")).sendKeys("jhonatas-teste@teste.com");
	    navegador.findElement(By.id("senha")).sendKeys("teste123");
	    
	    navegador.findElement(By.xpath("//button[contains(text(), 'Entrar')]")).click();
	}
	
	@Dado("^acesso a tela para adicionar contas$")
	public void acessoATelaParaAdicionarContas() throws Throwable {
		navegador.findElement(By.linkText("Contas")).click();
		navegador.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^incluo uma conta \"([^\"]*)\"$")
	public void incluoUmaConta(String conta) throws Throwable {
		navegador.findElement(By.id("nome")).sendKeys(conta);
		navegador.findElement(By.xpath("//button[contains(text(), 'Salvar')]")).click();
	}
	
	@Então("^devo ver a \"([^\"]*)\"$")
	public void devoVerA(String mensagemEsperada) throws Throwable {
		String mensagem = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
		assertEquals(mensagemEsperada, mensagem);
	}
	
	@After("@tearDownContas")
	public void tearDown() {
		navegador.close();
	} 
	
}

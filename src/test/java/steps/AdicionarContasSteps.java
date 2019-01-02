package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helpers.Helpers;
import pages.AdicionarContasPage;
import pages.HomePage;
import pages.LoginPage;

public class AdicionarContasSteps {
	
	private WebDriver navegador;	
	AdicionarContasPage adicionarContasPage;
	HomePage homePage;
	LoginPage loginPage;
	
	
	@Before("@adicionarContas")
	public void setUp() {
		navegador = Helpers.abrirNavegador();
		loginPage = new LoginPage(navegador);
		homePage = new HomePage(navegador);
		adicionarContasPage = new AdicionarContasPage(navegador);
	}
	
	@After("@adicionarContas")
	public void tearDown() {
		navegador.quit();
	}
	
	@Dado("^que estou logado no sistema$")
	public void queEstouLogadoNoSistema() throws Throwable {	    
		loginPage.acessarSistema();
		loginPage.preencherEmaileSenha("jhonatas-teste@teste.com", "teste123");
		loginPage.clicarEntrar();
	}
	
	@Dado("^acesso a tela para adicionar contas$")
	public void acessoATelaParaAdicionarContas() throws Throwable {
		homePage.acessarTelaAdicionarContas();
	}

	@Quando("^incluo uma conta \"([^\"]*)\"$")
	public void incluoUmaConta(String conta) throws Throwable {
		adicionarContasPage.incluirConta(conta);
	}
	
	@Então("^devo ver a \"([^\"]*)\"$")
	public void devoVerA(String mensagemEsperada) throws Throwable {		
		assertEquals(mensagemEsperada, adicionarContasPage.validarMensagem());
		
		navegador.quit();
	}
	
}

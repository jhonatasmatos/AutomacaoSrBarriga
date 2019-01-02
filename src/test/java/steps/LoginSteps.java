package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helpers.Helpers;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
	
	private WebDriver navegador;
	LoginPage loginPage;
	HomePage homePage;
	
	@Before("@login")
	public void setUp() {
		navegador = Helpers.abrirNavegador();
		loginPage = new LoginPage(navegador);
		homePage = new HomePage(navegador);
	}
	
	@After("@login")
	public void tearDown() {
		navegador.quit();
	}
	
	@Dado("^que acesso o sistema$")
	public void que_acesso_o_sistema() throws Throwable {
	    loginPage.acessarSistema();		
	}

	@Quando("^preencho \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preencho_e(String email, String senha) throws Throwable {
		loginPage.preencherEmaileSenha(email, senha);
	}

	@Quando("^clico em Entrar$")
	public void clico_em_Entrar() throws Throwable {
		loginPage.clicarEntrar();
	}

	@Então("^devo ver a seguinte \"([^\"]*)\"$")
	public void devo_ver_a_seguinte(String mensagemEsperada) throws Throwable {	
		assertEquals(mensagemEsperada, homePage.mensagemHome());
	}
	
}

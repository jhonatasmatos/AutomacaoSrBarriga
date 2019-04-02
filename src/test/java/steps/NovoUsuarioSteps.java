package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helpers.Helpers;
import pages.NovoUsuarioPage;

public class NovoUsuarioSteps{
	private WebDriver navegador;
	NovoUsuarioPage novoUsuarioPage;
	
	@Before("@novoUsuario")
	public void setUp() {
		navegador = Helpers.abrirNavegador();
		novoUsuarioPage = new NovoUsuarioPage(navegador);
		novoUsuarioPage.acessarSistema();
	}
	
	@After("@novoUsuario")
	public void tearDown() {
		navegador.quit();
	}

	@Dado("^que acesso a tela para incluir um novo usuário$")
	public void queAcessoATelaParaIncluirUmNovoUsuário() throws Throwable {
		novoUsuarioPage.acessarNovoUsuario();
	}

	@Quando("^preencho as informações$")
	public void preenchoAsInformaçõesEFinalizoOCadastro(DataTable tabelaInformacoes) throws Throwable {
	    novoUsuarioPage.realizarCadastro(tabelaInformacoes);	    
	}

	@Então("^sou redirecionado para a tela de login e vejo a mensagem$")
	public void souRedirecionadoParaATelaDeLoginEVejoAMensagem(String mensagemEsperada) throws Throwable {
	    novoUsuarioPage.verificarMensagem(mensagemEsperada);
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@Quando("^preencho as informações \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preenchoAsInformaçõesEE(String nome, String email, String senha) throws Throwable {
	    novoUsuarioPage.preencherNome(nome);
	    novoUsuarioPage.preencherEmail(email);
	    novoUsuarioPage.preencherSenha(senha);
	}

	@Quando("^finalizo o cadastro$")
	public void finalizoOCadastro() throws Throwable {
	    novoUsuarioPage.clicarCadastrar();
	}
	
	@Então("^devo ver a mensagem \"([^\"]*)\"$")
	public void devoVerAMensagem(String mensagemEsperada) throws Throwable {
	    novoUsuarioPage.verificarMensagem(mensagemEsperada);
	}

}

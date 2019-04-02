package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;

public class NovoUsuarioPage extends BasePage{
	private String URL = "https://srbarriga.herokuapp.com";
	List<List<String>> informacoesUsuario;
	
	public NovoUsuarioPage(WebDriver navegador) {
		super(navegador);
	}
	
	public void acessarSistema() {
		navegador.get(URL);
	}
	
	public NovoUsuarioPage acessarNovoUsuario() {
		navegador.findElement(By.linkText("Novo usuário?")).click();
		
		return this;
	}
	
	public NovoUsuarioPage preencherNome(String nome) {
		navegador.findElement(By.id("nome")).sendKeys(nome);
		
		return this;
	}
	
	public NovoUsuarioPage preencherEmail(String email) {
		navegador.findElement(By.id("email")).sendKeys(email);
		
		return this;
	}
	
	public NovoUsuarioPage preencherSenha(String senha) {
		navegador.findElement(By.id("senha")).sendKeys(senha);
		
		return this;
	}
	
	public NovoUsuarioPage clicarCadastrar() {
		navegador.findElement(By.xpath("//input[@value='Cadastrar']")).click();
		
		return this;
	}
	
	public LoginPage realizarCadastro(DataTable tabelaInformacoes) {
		informacoesUsuario = tabelaInformacoes.raw();
		preencherNome(informacoesUsuario.get(0).get(0));
		preencherEmail(informacoesUsuario.get(0).get(1));
		preencherSenha(informacoesUsuario.get(0).get(2));
		clicarCadastrar();
		
		return new LoginPage(navegador);
	}
	
	public void verificarMensagem(String mensagemEsperada) {
		String mensagem = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
		assertEquals(mensagemEsperada, mensagem);
	}
}

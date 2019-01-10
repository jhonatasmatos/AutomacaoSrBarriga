package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
		plugin = "pretty",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"steps"},
		features = "src/test/resources/features/novo_usuario.feature",
		dryRun = false,
		strict = true
		)
@RunWith(Cucumber.class)
public class Runner {
	
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("jhonatas-teste@teste.com");
		driver.findElement(By.id("senha")).sendKeys("teste123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
		
	}
}

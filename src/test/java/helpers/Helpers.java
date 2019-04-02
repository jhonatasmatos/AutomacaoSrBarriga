package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helpers {
	public static WebDriver abrirNavegador(){
		// Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		
        return navegador;
	}
}

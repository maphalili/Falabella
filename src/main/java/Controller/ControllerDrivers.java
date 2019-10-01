package Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ControllerDrivers {
	private String navegador;
	private String rutaDriverGoogle;
	private String rutaDriverIexplorer; 
	private WebDriver webDriver;

	public ControllerDrivers(String navegador) {
		if (navegador.contains("goog")) {
			this.navegador = "google";
		}
		if (navegador.contains("explo")) {
			this.navegador = "iexplorer";
		}
		rutaDriverGoogle = pathDriver(this.navegador);
		rutaDriverIexplorer = pathDriver(this.navegador);
		webDriver = abrirNavegador();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	private WebDriver abrirNavegador() {
		WebDriver webDriveNavegador = null;
		if (navegador.equals("google")) {
			System.setProperty("webdriver.chrome.driver", rutaDriverGoogle);
			webDriveNavegador = new ChromeDriver();
		}
		if (navegador.equals("iexplorer")) {
			System.setProperty("webdriver.ie.driver", rutaDriverIexplorer);
//			System.setProperty("webdriver.edge.driver", rutaDriverIexplorer);
			webDriveNavegador = new InternetExplorerDriver();
		//	webDriveNavegador = new EdgeDriver();
		}
		return webDriveNavegador;
	}

	private String pathDriver(String Opcion) {
		String ruta = System.getProperty("user.dir") + "\\drivers\\";
		Opcion = Opcion.toLowerCase();

		switch (Opcion) {
		case "google":
			ruta = ruta + "chromedriver.exe";
			break;
		case "iexplorer":
//			ruta = ruta + "MicrosoftWebDriver.exe";
			ruta = ruta + "IEDriverServer.exe";
			break;

		default:
			break;
		}
		return ruta;
	}

}

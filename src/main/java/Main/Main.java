package Main;

import org.openqa.selenium.WebDriver;

import Modulos.Launch;
import cucumber.api.java.en.Given;
import Modulos.AccionesEnFallabella;

public class Main {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Launch launch = new Launch();
		WebDriver webDriver = launch.lanzador("https://www.google.com");
		Thread.sleep(2000);
		AccionesEnFallabella navegarFallabella = new AccionesEnFallabella(webDriver);
		Thread.sleep(3000);
		webDriver = navegarFallabella.buscarFalabella();
		Thread.sleep(2000);
		boolean encontroProduc = navegarFallabella.buscarProducto("computador");
		if (encontroProduc == true) {
			navegarFallabella.seleccionarPrimerProductoAgregar();
		} else {
			System.out.println("No encontro producto");
		}
		int acu = 9;
		while (acu > 0) {
			Thread.sleep(1000);
			System.out.println("La página se cerrara en "+acu+" segundos ...");
			acu--;
		}

		webDriver.close();
	}
}

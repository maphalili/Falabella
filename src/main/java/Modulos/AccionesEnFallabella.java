package Modulos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Controller.FuncionesElementSelenium;

public class AccionesEnFallabella {
	WebDriver webDriver;

	public AccionesEnFallabella(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	@Given("^Abre falabella$")
	public WebDriver buscarFalabella() throws InterruptedException {
		WebElement cajaBuscador = webDriver.findElement(By.name("q"));
		cajaBuscador.sendKeys("falabella");
		cajaBuscador.submit();
		Thread.sleep(1000);
		WebElement linkFalabella = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a"));
		linkFalabella.click();
		return webDriver;
	}
	@When("^Abre falabella$")
	public boolean buscarProducto(String nombreProducto) throws InterruptedException {
		boolean retorno = false;
		WebElement noGracias = FuncionesElementSelenium.existElementById(webDriver, "acc-alert-deny");
		if (noGracias != null) {
			noGracias.click();
		}
		WebElement cajaBuscarFallabe = webDriver.findElement(By.name("Ntt"));
		cajaBuscarFallabe.sendKeys(nombreProducto);
		Thread.sleep(2000);
		cajaBuscarFallabe.submit();
		Thread.sleep(2000);
		WebElement noEncontroResultad = FuncionesElementSelenium.existElementXpath(webDriver,
				"//*[@id=\"main\"]/div/div/div[1]/div/h2");
		if (noEncontroResultad == null) {
			retorno = true;
		}
		return retorno;
	}

	@Then ("^agrego el producto al carrito de compras$")
	public boolean seleccionarPrimerProductoAgregar() {
		boolean retorno = false;
		try {
			List<WebElement> listOfElements = webDriver.findElements(By.className("pod-item"));
			if (listOfElements.size() > 0) {
				WebElement primerElemento = listOfElements.get(0);
				primerElemento.click();
				Thread.sleep(3500);
				List<WebElement> listaBotones = webDriver.findElements(By.tagName("button"));
				for (int i = 0; i < listaBotones.size(); i++) {
					String mensaje = "";
					try {
						mensaje = listaBotones.get(i).getText().trim();
					} catch (Exception e) {
						
					}
					
					mensaje = mensaje.toLowerCase();
					if(mensaje.contains("agregar a la bolsa")) {
						listaBotones.get(i).click();
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

}

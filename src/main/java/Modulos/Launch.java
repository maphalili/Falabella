package Modulos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Controller.ControllerDrivers;

public class Launch {
	
	
	
	public WebDriver lanzador(String urlPagina) {
		WebDriver webDriver = null;
//		ControllerDrivers controllerDrivers = new ControllerDrivers("explorer");
		ControllerDrivers controllerDrivers = new ControllerDrivers("google");
		webDriver = controllerDrivers.getWebDriver();
		webDriver.get(urlPagina);		
		return webDriver;
	}
	
	
	
}

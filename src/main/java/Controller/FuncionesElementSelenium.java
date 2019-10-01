package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FuncionesElementSelenium {
	
	
	public static WebElement existElementById(WebDriver webDriver,String Id) {
		WebElement webElement= null;
		try {
			Thread.sleep(2000);
			webElement = webDriver.findElement(By.id(Id));
		} catch (Exception e) {
			System.out.println("No existe el elemento con Id: "+ Id);
		}
		return webElement;
	}
	
	public static WebElement existElementXpath(WebDriver webDriver,String Xpath) {
		WebElement webElement= null;
		try {
			Thread.sleep(2000);
			webElement = webDriver.findElement(By.xpath(Xpath));
		} catch (Exception e) {
			System.out.println("No existe el elemento con Xpath: "+ Xpath);
		}
		return webElement;
	}

}

package webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;

public class RegCheckerWebPage {
	final static Logger LOGGER = Logger.getLogger(RegCheckerWebPage.class);
	
	public static WebDriver myDriver;
	private WebElement element;
	
	public void startBrowser() {
		LOGGER.info("In RegCheckerWebPage startBrowser");
		System.setProperty(Constants.DRIVER_PROPERTY, Constants.DRIVER_PATH);
		myDriver = new ChromeDriver(); 
	}
	
	public void goToRegChecker() {
		LOGGER.info("In RegCheckerWebPage goToRegChecker");
		myDriver.get(Constants.URL);
	}
	
	public void pressStartAndEnterRegNumber(String regNumber) {
		LOGGER.info("In RegCheckerWebPage pressStartAndEnterRegNumber: " + regNumber);
		WebDriverWait wait = new WebDriverWait(myDriver, 10);
		
		element = myDriver.findElement(By.xpath(Constants.START_BUTTON_XPATH));
		element.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.ID_1)));
		element = myDriver.findElement(By.id(Constants.ID_1));
		element.sendKeys(regNumber);
		
		element = myDriver.findElement(By.className(Constants.CLASS_NAME));
		element.click();
	}
	
	public String getCarMake() {
		LOGGER.info("In RegCheckerWebPage getCarMake");
		return myDriver.findElement(By.xpath(Constants.CAR_MAKE_XPATH)).getText();
	}
	
	public String getCarColour() {
		LOGGER.info("In RegCheckerWebPage getCarColour");
		return myDriver.findElement(By.xpath(Constants.CAR_COLOUR_XPATH)).getText();
	}
	
	public void shutDown() {
		LOGGER.info("In RegCheckerWebPage shutDown");
		myDriver.close();
	}
}

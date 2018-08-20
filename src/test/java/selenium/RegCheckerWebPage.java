package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegCheckerWebPage {
	public static WebDriver myDriver;
	private WebElement element;
	
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\samue\\chromedriver.exe");
		myDriver = new ChromeDriver(); 
	}
	
	public void goToRegChecker() {
		myDriver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
	}
	
	public void pressStartAndEnterRegNumber(String regNumber) {
		WebDriverWait wait = new WebDriverWait(myDriver, 10);
		
		element = myDriver.findElement(By.xpath("//*[@id=\"get-started\"]/a"));
		element.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Vrm")));
		element = myDriver.findElement(By.id("Vrm"));
		element.sendKeys(regNumber);
		
		element = myDriver.findElement(By.className("button"));
		element.click();
	}
	
	public String getCarMake() {
		return myDriver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[2]/span[2]/strong")).getText();
	}
	
	public String getCarColour() {
		return myDriver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
	}
	
	public void shutDown() {
		myDriver.close();
	}
}

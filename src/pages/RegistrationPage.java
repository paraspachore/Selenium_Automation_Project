package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	private By nameIn = By.id("name"); // By id
	private By emailIn = By.name("email"); // By name
	private By passwordIn = By.cssSelector("input[type=password]"); // By TagAttribute
	private By mobileIn = By.cssSelector("input#mobile"); // By TagId
	private By workStatIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[4]/div[2]/div[2]");// By xpath
	private By cityIn = By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[2]/div[5]/div/div[2]/div/div[1]/div/div/input");// By full xpath
	private By cityPuneIn = By.xpath("//*[contains(text(),'Pune')]"); // By textVisible/custom xpath
	private By cityPuneClose = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[5]/div/div/div/div/div/span/span/button/i");// By textVisible/custom xpath
	private By wpCheckBoxIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[7]/a/i");
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}
	
	public void fillDetails() throws InterruptedException {
		driver.findElement(nameIn).sendKeys("Paras Pachore");
		driver.findElement(emailIn).sendKeys("paraspachore@gmail.com");
		driver.findElement(passwordIn).sendKeys("m98465dm9fjy5h7");
		driver.findElement(mobileIn).sendKeys("9162843755");
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(workStatIn).click();
		Thread.sleep(3000);
		driver.findElement(cityPuneIn).click();
		Thread.sleep(3000);
		driver.findElement(cityPuneClose).click();
		Thread.sleep(3000);
		driver.findElement(cityIn).sendKeys("Sang"); //Keys combination
		Thread.sleep(3000);
		driver.findElement(cityIn).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(wpCheckBoxIn).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
	}
	
	private By switchLogin = By.xpath("//*[@id=\"root\"]/div/header/div/span/a");
	public void clickOnLogin() {
		driver.findElement(switchLogin).click();
	}
}

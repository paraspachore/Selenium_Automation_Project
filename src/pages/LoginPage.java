package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	
	private By unameIn = By.xpath("//*[@id=\"usernameField\"]");
	private By passIn = By.xpath("//*[@id=\"passwordField\"]");
	private By loginBtn = By.xpath("//*[@id=\"loginForm\"]/div[2]/div[3]/div/button[1]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void LoginActions() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(unameIn).sendKeys("paraspachore@gmail.com");
		driver.findElement(passIn).sendKeys("ParaS@FirstNaukri");
		Thread.sleep(2000);
		driver.findElement(loginBtn).click();
	}
}

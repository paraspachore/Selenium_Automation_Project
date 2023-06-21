package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	String username;
	String password;
	
	private By unameIn = By.xpath("//*[@id=\"usernameField\"]");
	private By passIn = By.xpath("//*[@id=\"passwordField\"]");
	private By loginBtn = By.xpath("//*[@id=\"loginForm\"]/div[2]/div[3]/div/button[1]");
	
	
	public LoginPage(WebDriver driver, String username, String password) {
		this.driver = driver;
		this.username = username;
		this.password = password;
	}
	
	public void LoginActions() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(unameIn).sendKeys(username);
		driver.findElement(passIn).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(loginBtn).click();
	}
}

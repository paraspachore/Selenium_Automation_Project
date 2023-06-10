package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	private WebDriver driver;
	private By loginButton = By.xpath("//*[@id=\"login_Layer\"]");
	private By registerButton = By.xpath("//*[@id=\"register_Layer\"]");
	
	public LandingPage(WebDriver driver){
		this.driver =  driver;
	}
	
	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}

	public void clickOnRegister() {
		driver.findElement(registerButton).click();
	}

}

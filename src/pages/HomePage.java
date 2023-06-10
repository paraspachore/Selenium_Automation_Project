package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	
	private WebElement profileDrawer = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div"));
																	
	private WebElement viewProfileBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a"));
	private WebElement SearchBar = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/span"));
	
	public void gotoProfilePage() {
		profileDrawer.click();
		viewProfileBtn.click();
	}
}

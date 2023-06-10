package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	private WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement chatBot = driver.findElement(By.xpath("//*[@id=\"_15sb4wxs0Drawer\"]/div[1]"));
	private WebElement EmpSection = driver.findElement(By.xpath("//*[@id=\"lazyEmployment\"]/div"));
	
	private JavascriptExecutor js = (JavascriptExecutor) driver;
	public void updateEmployment() {
		js.executeScript("arguments[0].scrollIntoView();", EmpSection);
	}
	
}

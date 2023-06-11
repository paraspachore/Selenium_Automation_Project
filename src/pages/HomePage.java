package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
																	
	By profileDrawer = By.xpath("/html/body/div[3]/div[2]/div[3]/div");
	By viewProfileBtn = By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a");
	By searchBoxBy = By.xpath("/html/body/div[3]/div[2]/div[1]/div");
	By searchInBy = By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/div[1]/div/div/div/input");
//	WebElement profileDrawer = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div"));
//	WebElement viewProfileBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a"));
	
	public void gotoProfilePage() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(profileDrawer).click();
		Thread.sleep(2000);
		driver.findElement(viewProfileBtn).click();
//		profileDrawer.click();
//		viewProfileBtn.click();
	}
	public void search(String searchTitle) throws InterruptedException {
		Thread.sleep(5000);
		WebElement searchBox = driver.findElement(searchBoxBy);
		searchBox.click();
		Thread.sleep(4000);
		WebElement searchIn = driver.findElement(searchInBy);
		searchIn.sendKeys(searchTitle+Keys.ENTER);
//		searchIn.submit();
	}
}

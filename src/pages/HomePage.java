package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
																	
	By profileDrawer = By.xpath("/html/body/div[3]/div[2]/div[3]/div");
	By viewProfileBtn = By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a");
//	WebElement profileDrawer = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div"));
//	WebElement viewProfileBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a"));
//	private WebElement SearchBar = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/span"));
	
	public void gotoProfilePage() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(profileDrawer).click();
		Thread.sleep(2000);
		driver.findElement(viewProfileBtn).click();
//		profileDrawer.click();
//		viewProfileBtn.click();
	}
}

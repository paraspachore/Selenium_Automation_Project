package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobDescPage {
	WebDriver driver;
	
	public JobDescPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	By saveJob = By.cssSelector("button.save-job-button");
	By saveJob = By.xpath("//*[@id=\"root\"]/main/div[2]/div[1]/section[1]/div[2]/div[2]/button[1]");
	
	public void saveJob() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(saveJob).click();
		Thread.sleep(3000);
		driver.close();
	}
}

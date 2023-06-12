package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobDescPage {
	WebDriver driver;
	
	public JobDescPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By saveJob = By.cssSelector("button.save-job-button");
//	By saveJob = By.xpath("//*[@id=\"root\"]/main/div[2]/div[1]/section[1]/div[2]/div[2]/button[1]");
	
	public void saveJob(String mainWindowHandle) throws InterruptedException {
		Thread.sleep(2000);
//		String mainWindowHandle  = driver.getWindowHandle();
		for(String windowHandle: driver.getWindowHandles()) {
			if(!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
		try {
		    WebElement element = driver.findElement(saveJob);
		    element.click();
		} catch (NoSuchElementException e) {
		    System.out.println("Job Already Saved");
		}
//		driver.findElement(saveJob).click();
		Thread.sleep(3000);
		driver.close();
	}
}

package pages;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By JobTitleBy = By.cssSelector("a.title");
	
	JobDescPage JobDescPg;
	
	public void apply(String desiredJob) throws InterruptedException {
		for(int i=1; i<=20; i++) {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/section[2]/div[2]/article["+i+"]/div[1]/div[1]/a")).click();
			Thread.sleep(4000);
			JobDescPg = new JobDescPage(driver);
			JobDescPg.saveJob();
			Thread.sleep(5000);
		}
	}
	
	
//	public void apply(String desiredJob) throws InterruptedException {
//		Thread.sleep(4000);
//		List<WebElement> jobTitles = driver.findElements(JobTitleBy);
//		
//		for (WebElement jobTitle : jobTitles) {
//			String jobTitleName = jobTitle.getText();
//		    if (jobTitleName.equals(desiredJob)) {
////				applyForIt(jobTitle);
//		    	Thread.sleep(4000);
//		    	jobTitle.click();
//		    	Thread.sleep(5000);
//				driver.findElement(saveJob).click();
//				Thread.sleep(3000);
//				driver.navigate().back();
//				Thread.sleep(5000);
//			}
//		}
//	}
	
//	void applyForIt(WebElement jobTitle) throws InterruptedException {
//		Thread.sleep(3000);
//		jobTitle.click();
//		Thread.sleep(5000);
//		driver.findElement(saveJob).click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//	}
}

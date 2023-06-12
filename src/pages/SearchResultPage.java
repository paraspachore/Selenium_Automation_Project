package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By JobTitleBy = By.cssSelector("a.title");
	By expSlider = By.cssSelector(".rc-slider");
	
	
	JobDescPage JobDescPg;
	

	
	public void filterResults() throws InterruptedException {
		Thread.sleep(3000);
		setSlider();
		Thread.sleep(3000);
		setLocation();
	}
	
	void setSlider() {
		WebElement slider = driver.findElement(expSlider);
		int sliderWidth = slider.getSize().getWidth();
		WebElement sliderHandle = driver.findElement(By.cssSelector(".handle"));
//		int handleWidth = sliderHandle.getSize().getWidth();
		
		int xOffset = -sliderWidth;
		Actions mouse = new Actions(driver);
		mouse.dragAndDropBy(sliderHandle, xOffset, 0).build().perform();
	}
	
	void setLocation() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cityTypeGid\"]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tooltip\"]/div[2]/div[1]/div/div[1]/div[6]/label/i"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tooltip\"]/div[2]/div[2]/div[2]")).click();
	}
	
	public void apply(String desiredJob) throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> jobTitles = driver.findElements(JobTitleBy);
		
		for(int i=0; i<3; i++) {
			if ((jobTitles.get(i).getText()).contains(desiredJob)) {
				applyForIt(jobTitles.get(i));
		    	Thread.sleep(4000);
			}
		}
		
//		for (WebElement jobTitle : jobTitles) {
//			String jobTitleName = jobTitle.getText();
//		    if (jobTitleName.contains(desiredJob)) {
//				applyForIt(jobTitle);
//		    	Thread.sleep(4000);
//			}
//		}
	}
	
	void applyForIt(WebElement jobTitle) throws InterruptedException {
		Thread.sleep(3000);
		String mainWindowHandle = driver.getWindowHandle();
		jobTitle.click();
		Thread.sleep(5000);
		JobDescPg = new JobDescPage(driver);
		JobDescPg.saveJob(mainWindowHandle);
		Thread.sleep(3000);
		driver.switchTo().window(mainWindowHandle);
		Thread.sleep(5000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void apply(String desiredJob) throws InterruptedException {
//	for(int i=1; i<=20; i++) {
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/section[2]/div[2]/article["+i+"]/div[1]/div[1]/a")).click();
//		Thread.sleep(4000);
//		JobDescPg = new JobDescPage(driver);
//		JobDescPg.saveJob();
//		Thread.sleep(5000);
//	}
//}
	
//	public void apply(String desiredJob) throws InterruptedException {
//		Thread.sleep(4000);
//		List<WebElement> jobTitles = driver.findElements(JobTitleBy);
//		
//		for (WebElement jobTitle : jobTitles) {
//			String jobTitleName = jobTitle.getText();
//		    if (jobTitleName.contains(desiredJob)) {
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
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	By freshnessBy = By.xpath("//*[@id=\"filter-freshnessFor\"]");	
	By freshness1Day = By.xpath("//*[@id=\"ul_filter-freshness\"]/ul/li[5]/a");	
	By sortBy = By.cssSelector("p.sort-droop-label");
	By sortByOpt = By.xpath("//*[@id=\"root\"]/div[4]/div/div/section[2]/div[1]/div[2]/span/span[2]/ul/li[2]");
	
	
	JobDescPage JobDescPg;
	

	
	public void filterResults() throws InterruptedException {
		Thread.sleep(3000);
		setSlider();
		Thread.sleep(3000);
		setLocation();
		Thread.sleep(3000);
		setFreshness();
		Thread.sleep(3000);
		setSortBy();
	}
	
	private void setFreshness() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800);");
		Thread.sleep(2000);
		driver.findElement(freshnessBy).click();
		Thread.sleep(2000);
		WebElement Opt = driver.findElement(freshness1Day);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Opt);
	}

	void setSlider() {
		WebElement slider = driver.findElement(expSlider);
		int sliderWidth = slider.getSize().getWidth();;
		WebElement sliderHandle = driver.findElement(By.cssSelector(".handle"));
		int xOffset = -sliderWidth;
		Actions mouse = new Actions(driver);
		mouse.dragAndDropBy(sliderHandle, xOffset, 0).build().perform();
	}
	
	void setLocation() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cityTypeGid\"]/span")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100);");
		Thread.sleep(2500);
		WebElement element = driver.findElement(By.xpath("//*[@class='chkLbl'and@for='chk-Pune-cityTypeGid-expanded']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		element.click();
//		driver.findElement(By.xpath("//*[@id=\"chk-Pune-cityTypeGid-expanded\"]")).click();////*[@class='chkLbl'and@for='chk-Pune-cityTypeGid-expanded']//		WebElement loc = 	driver.findElement(By.xpath("//*[@id=\"tooltip\"]/div[2]/div[1]/div/div[1]/div[5]/label/p/span[1]"));//"//*[@class='chkLbl'and@for='chk-Pune-cityTypeGid-expanded']"));
//		Actions mouse = new Actions(driver);
//		mouse.moveToElement(loc).click().perform();
		Thread.sleep(2500);
//		driver.findElement(By.xpath("//*[@id=\"tooltip\"]/div[2]/div[2]/div[2]")).click();
		driver.findElement(By.cssSelector("div.filter-apply-btn")).click();
		
	}
	void setSortBy() throws InterruptedException {
		driver.findElement(sortBy).click();
		Thread.sleep(2000);
		driver.findElement(sortByOpt).click();
		Thread.sleep(2000);
	}
	
	public void apply() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> jobTitles = driver.findElements(JobTitleBy);
		for(int i=0; i<3; i++) {
				applyForIt(jobTitles.get(i));
		}
		
		
//		for(int i=0; i<3; i++) {
//			WebElement jobTitle = jobTitles.get(i);
//			String titleString = jobTitle.getText();
//			if (titleString.contains(desiredJob)) {
//				applyForIt(jobTitles.get(i));
//		    	Thread.sleep(4000);
//			} else {
//				i--;
//			}
//		}
		
//		for (WebElement jobTitle : jobTitles) {
//			String jobTitleName = jobTitle.getText();
//		    if (jobTitleName.contains(desiredJob)) {
//				applyForIt(jobTitle);
//		    	Thread.sleep(4000);
//			}
//		}
	}
	
	void applyForIt(WebElement jobTitle) throws InterruptedException {
		Thread.sleep(2500);
		String mainWindowHandle = driver.getWindowHandle();
		jobTitle.click();
		Thread.sleep(3000);
		JobDescPg = new JobDescPage(driver);
		JobDescPg.saveJob(mainWindowHandle);
		Thread.sleep(3000);
		driver.switchTo().window(mainWindowHandle);
		Thread.sleep(2500);
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

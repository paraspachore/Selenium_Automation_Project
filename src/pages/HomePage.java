package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	WebDriver driver;
	Actions mouse;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		mouse = new Actions(driver);
	}
	
																	
	By profileDrawer = By.xpath("/html/body/div[3]/div[2]/div[3]/div");
	By viewProfileBtn = By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[1]/div[2]/a");
	By searchBoxBy = By.xpath("/html/body/div[3]/div[2]/div[1]/div");
	By searchInBy = By.xpath("/html/body/div[3]/div[2]/div[1]/div/div/div[1]/div/div/div/input");
	By JobsTabBy = By.xpath("//a[@class='nI-gNb-menuItems__anchorDropdown'and@title='Recommended Jobs']");
	By savedJobsBy = By.xpath("//a[@href='/mnjuser/savedjobs']");///html/body/div[3]/div[2]/nav/ul/li[1]/div/ul/li[5]/a
	By CompaniesTabBy = By.xpath("//a[@class='nI-gNb-menuItems__anchorDropdown'and@title='Explore top companies hiring on Naukri']");
	By logoutBy = By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[3]/div/div[1]/div[4]/a");
	
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
	public void goToSavedJobs() throws InterruptedException {
		Thread.sleep(2000);
		WebElement jobsTab = driver.findElement(JobsTabBy);
		WebElement savedJobs = driver.findElement(savedJobsBy);
		mouse.moveToElement(jobsTab).build().perform();
		Thread.sleep(3000);
		mouse.click(savedJobs).build().perform();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	
	public void goToCompanies() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(CompaniesTabBy).click();
	}
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(profileDrawer).click();
		Thread.sleep(2000);
		driver.findElement(logoutBy).click();
		Thread.sleep(2000);
	}
}

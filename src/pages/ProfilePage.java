package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
//	By chatBotBy = By.xpath("//*[@id=\"_15sb4wxs0Drawer\"]/div[1]");
	By EmpSection = By.xpath("//*[@id=\"lazyEmployment\"]/div");
	By editEmp = By.xpath("//*[@id=\"lazyEmployment\"]/div/div[1]/div/div[2]/div/div[1]/span[2]");
	By currEmpRadio = By.xpath("//*[@id=\"employmentForm\"]/div[2]/div[3]/label");
	By workedTillYear = By.id("workedTillYearFor");
	By workedTillYearIn = By.id("//*[@id=\"ul_workedTillYear\"]/ul/li[1]/a");
	By workedTillMonth = By.id("workedTillMonthFor");
	By workedTillMonthIn = By.xpath("//*[@id=\"ul_workedTillMonth\"]/ul/li[1]/a");
	By saveBtn = By.xpath("//*[@id=\"submitEmployment\"]");
	
	public void updateEmployment() throws InterruptedException {
		Thread.sleep(5000);
		try {
		    WebElement element = driver.findElement(By.xpath("//*[@id='_15sb4wxs0Navbar']/div"));
		    element.click();
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found or not visible");
		}
		
//		WebElement chatBot = driver.findElement(chatBotBy);
//		if(chatBot.isDisplayed()) {
//			driver.findElement(By.xpath("//*[@id=\"_15sb4wxs0Navbar\"]/div")).click();
//		} else {
//			System.out.println("ChatBot not displayed");
//		}
		Thread.sleep(1500);
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(EmpSection));
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		driver.findElement(editEmp).click();
		Thread.sleep(2000);
		driver.findElement(currEmpRadio).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		driver.findElement(workedTillYear).click();
		Thread.sleep(500);
		driver.findElement(workedTillYear).sendKeys("2023"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(workedTillMonth).click();
		Thread.sleep(500);
		driver.findElement(workedTillMonth).sendKeys("Jan"+Keys.ENTER);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(4000);
		driver.navigate().back();
	}
	
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompaniesPage {
	WebDriver driver;
	
	public CompaniesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By companiesTileBy = By.xpath("//*[@id=\"company-listing-cluster-wdgt\"]/section/div/div[1]/div[1]");
	By mainLogoBy = By.xpath("//*[@id=\"root\"]/div[4]/div[2]/a/img");
	
	public void findMNCs() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(companiesTileBy).click();
		Thread.sleep(4000);
		driver.findElement(mainLogoBy).click();
	}
}

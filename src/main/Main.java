package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;

public class Main {
	WebDriver driver;
	Actions mouse;
	String baseUrl = "https://www.naukri.com";

	private LandingPage landingPg = new LandingPage(driver);
	private RegistrationPage regPg = new RegistrationPage(driver);
	private LoginPage loginPg = new LoginPage(driver);
	private HomePage homePg = new HomePage(driver);
	private ProfilePage profilePg = new ProfilePage(driver);
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		mouse = new Actions(driver);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
//		driver.close();
//		driver.quit();
	}
	
	@Test(priority = 0, groups = "registration")
	public void registrationRun() throws InterruptedException{
		landingPg.clickOnRegister();
		regPg.fillDetails();
	}
	
	@Test(priority=1, groups="login")
	public void loginRun() throws InterruptedException {
		regPg.clickOnLogin();
		loginPg.LoginActions();
	}
	
	@Test(priority=2, groups="profile")
	public void profileRun() {
		
		homePg.gotoProfilePage();
		if(profilePg.chatBot.isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"_15sb4wxs0Navbar\"]/div")).click();
		}
		
		profilePg.updateEmployment();
		
	}
	
	
	
}

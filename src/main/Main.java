package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;

public class Main {
	WebDriver driver;
	String baseUrl = "https://www.naukri.com";

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	@Test(priority = 0, groups = "registration")
	public void registrationRun() throws InterruptedException{
		LandingPage landingPg = new LandingPage(driver);
		landingPg.clickOnRegister();
		RegistrationPage regPg = new RegistrationPage(driver);
		regPg.fillDetails();
	}
	
	@Test(priority=1, groups="login")
	public void loginRun() throws InterruptedException {
		RegistrationPage regPg = new RegistrationPage(driver);
		regPg.clickOnLogin();
		LoginPage loginPg = new LoginPage(driver);
		loginPg.LoginActions();
	}
	
	@Test(priority=2, groups="profile")
	public void profileRun() throws InterruptedException {
		HomePage homePg = new HomePage(driver);
		homePg.gotoProfilePage();
		ProfilePage profilePg = new ProfilePage(driver);
		profilePg.updateEmployment();
		Thread.sleep(4000);
	}
	
	
	
}

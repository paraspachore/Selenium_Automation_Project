package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;
import pages.SearchResultPage;

public class Main {
	WebDriver driver;
//	String baseUrl = "https://www.naukri.com/nlogin/login";//"https://www.naukri.com";
	String baseUrl = "https://www.naukri.com";
	
	
	LandingPage landingPg;
	RegistrationPage regPg;
	LoginPage loginPg;
	HomePage homePg;
	ProfilePage profilePg;
	SearchResultPage srchRsltPg;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
//		driver.close();
//		driver.quit();
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		Thread.sleep(4000);
	}
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(4000);
	}
	
//	@Test(priority = 0, groups = "registration")
//	public void registrationRun() throws InterruptedException{
//		landingPg = new LandingPage(driver);
//		landingPg.clickOnRegister();
//		regPg = new RegistrationPage(driver);
//		regPg.fillDetails();
//	}
//	
//	@Test(priority=1, groups="login")
//	public void loginRun() throws InterruptedException {
//		regPg = new RegistrationPage(driver);
//		regPg.clickOnLogin();
//		loginPg = new LoginPage(driver);
//		loginPg.LoginActions();
//	}
//	
//	@Test(priority=2, groups="profile")
//	public void profileRun() throws InterruptedException {
//		homePg = new HomePage(driver);
//		homePg.gotoProfilePage();
//		profilePg = new ProfilePage(driver);
//		profilePg.updateEmployment();
//	}
	
	@Test(priority=3, groups="searching")
	public void searchRun() throws InterruptedException {
		String applyForRole = "Automation Test";
		homePg = new HomePage(driver);
		homePg.search(applyForRole);
		Thread.sleep(4000);
		srchRsltPg = new SearchResultPage(driver);
		srchRsltPg.filterResults();
		srchRsltPg.apply("Tester");
	}
	
	@Test(priority = 0)
	public void temp() throws InterruptedException {
		driver.navigate().to("https://www.naukri.com/nlogin/login");
		loginPg = new LoginPage(driver);
		loginPg.LoginActions();
	}
	
	
}

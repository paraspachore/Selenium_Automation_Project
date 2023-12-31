package main;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.CompaniesPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;
import pages.SearchResultPage;

public class Main {
	WebDriver driver;
	String baseUrl = "https://www.naukri.com";
	String username = "";
	String password = "";
	
	Scanner sc = new Scanner(System.in);
	
	
	LandingPage landingPg;
	RegistrationPage regPg;
	LoginPage loginPg;
	HomePage homePg;
	ProfilePage profilePg;
	SearchResultPage srchRsltPg;
	CompaniesPage companiesPg;

	@BeforeClass
	public void setUp() {
		boolean loop = true;
		if(username==""||password=="") {
			while(loop) {
				System.out.print("\nEnter Username/email for naukri profile: ");
				username = sc.nextLine();
				System.out.print("\nEnter password: ");
				password = sc.nextLine();
				System.out.print("\nProceed Y/N?: ");
				char c = sc.next().charAt(0);
				sc.nextLine();
				if(c=='Y'||c=='y') {
					loop=false;
				}
			}
		}
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
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	@Test(priority = 0, groups = "registration")
	public void registrationRun() throws InterruptedException{
		landingPg = new LandingPage(driver);
		landingPg.clickOnRegister();
		regPg = new RegistrationPage(driver);
		regPg.fillDetails();
	}
	
	@Test(priority=1, groups="login")
	public void loginRun() throws InterruptedException {
		regPg = new RegistrationPage(driver);
		regPg.clickOnLogin();
		loginPg = new LoginPage(driver, username, password);
		loginPg.LoginActions();
	}
	
	@Test(priority=2, groups="profile")
	public void profileRun() throws InterruptedException {
		homePg = new HomePage(driver);
		homePg.gotoProfilePage();
		profilePg = new ProfilePage(driver);
		profilePg.updateEmployment();
	}

	@Test(priority=3, groups="searching")
	public void searchRun() throws InterruptedException {
		String applyForRole = "Automation Testing, QA, Tester";
		homePg = new HomePage(driver);
		homePg.search(applyForRole);
		Thread.sleep(4000);
		srchRsltPg = new SearchResultPage(driver);
		srchRsltPg.filterResults();
		srchRsltPg.apply();
	}
	
	@Test(priority=4, groups="savedjobs")
	public void savedJobs() throws InterruptedException {
		homePg = new HomePage(driver);
		homePg.goToSavedJobs();
	}
	
	@Test(priority=5, groups="Companies")
	public void companies() throws InterruptedException {
		homePg = new HomePage(driver);
		homePg.goToCompanies();
		companiesPg = new CompaniesPage(driver);
		companiesPg.findMNCs();
	}
	@Test(priority=6, groups="Logout")
	public void logout() throws InterruptedException {
		homePg = new HomePage(driver);
		homePg.logout();
	}
	
	
	
//	@Test(priority = 0)
//	public void temp() throws InterruptedException {
//		driver.navigate().to("https://www.naukri.com/nlogin/login");
//		loginPg = new LoginPage(driver);
//		loginPg.LoginActions();
//	}
	
}

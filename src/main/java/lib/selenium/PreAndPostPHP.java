package lib.selenium;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcelFile;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PreAndPostPHP extends WebDriverServiceImpl {
	
	public String testName, testDesc, testModule, testAuthor, testCategory, excelFileName;

	@Parameters({"url","username","password"})
	@BeforeMethod(groups= {"smoke", "sanity"})
	public void beforeMethod(String URL, String userName, String passWord) throws InterruptedException {
		startTestModule(testModule);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("beforeMethod");
		
		Thread.sleep(3000);
		
		//Click on Account
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle go-text-right'])[3]")).click();
		
		//Click on Login
		driver.findElement(By.xpath("(//a[@href='https://www.phptravels.net/login'])[2]")).click();
		
		Thread.sleep(2000);
		
		//Enter user name
		driver.findElement(By.name("username")).sendKeys(userName);
		
		//Enter Password
		driver.findElement(By.name("password")).sendKeys(passWord);
		
		//Click on Login button
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
//		driver.findElement(By.linkText("Logout")).click();
		closeActiveBrowser();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testName, testDesc);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	@DataProvider(name = "PHP")
	public Object[][] phpTstData() throws IOException
	{
		ReadExcelFile readData = new ReadExcelFile();
		Object[][] arrData = readData.readExcel(excelFileName);
		return arrData;
	}
}

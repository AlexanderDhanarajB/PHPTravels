package pages.php;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class PhpUserHomePage extends WebDriverServiceImpl{

	public PhpUserHomePage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='Hotels']")
	WebElement eleHotels;
	
	public PhpHotelsPage clickHotels() throws InterruptedException
	{
		click(eleHotels);
		Thread.sleep(3000);
		return new PhpHotelsPage(test, driver);
	}
}

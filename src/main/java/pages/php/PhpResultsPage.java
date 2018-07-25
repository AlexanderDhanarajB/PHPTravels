package pages.php;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class PhpResultsPage extends WebDriverServiceImpl{

	public PhpResultsPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='mob-trip-info-head ttu']")
	WebElement eleHotelAddr;
	
	@FindBy(xpath = "(//button[text()='Book Now'])[1]")
	WebElement eleBookNow;
	
	public boolean verifyNoResult()
	{
		if (getElementsSize("xpath", "//h2[text()='No Results Found']") > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public PhpDetailsPage clickBookNow()
	{
		/*click(eleHotelAddr);
		eleHotelAddr.sendKeys(Keys.PAGE_DOWN);
		eleHotelAddr.sendKeys(Keys.PAGE_DOWN);
		eleHotelAddr.sendKeys(Keys.PAGE_DOWN);*/
		click(eleBookNow);
		return new PhpDetailsPage(test, driver);
	}
}

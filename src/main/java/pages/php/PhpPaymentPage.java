package pages.php;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class PhpPaymentPage extends WebDriverServiceImpl{

	public PhpPaymentPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Pay on Arrival']")
	WebElement elePayOnArrival;
	
	@FindBy(xpath = "//button[text()='Pay Now']")
	WebElement elePayNow;
	
	@FindBy(id = "gateway")
	WebElement eleSelectGateway;
	
	public PhpBookingConfirmationPage clickPayOnArrival()
	{
		click(elePayOnArrival);
		acceptAlert();
		return new PhpBookingConfirmationPage(test, driver);
	}
	
	public PhpPaymentPage clickPayNow()
	{
		click(elePayNow);
		return this;
	}
	
	public PhpPaymentPage selectGateway(String gatewayName)
	{
		selectDropDownUsingVisibleText(eleSelectGateway, gatewayName);
		return this;
	}
	
}

package pages.php;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class PhpBookingConfirmationPage extends WebDriverServiceImpl{

	public PhpBookingConfirmationPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[@class='wow flash animted']")
	WebElement eleBookingStatus;
	
	@FindBy(xpath = "(//table[@id='invoiceTable']//table//td/div)[4]")
	WebElement eleInvoiceNo;
	
	@FindBy(xpath = "(//table[@id='invoiceTable']//table//td/div)[5]")
	WebElement eleBookingNo;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement eleHomeMenu;
	
	public PhpBookingConfirmationPage getStatus()
	{
		System.out.println(getText(eleBookingStatus));
		return this;
	}
	
	public PhpBookingConfirmationPage getInvoiceNo()
	{
		System.out.println(getText(eleInvoiceNo));
		return this;
	}
	
	public PhpBookingConfirmationPage getBookingNo()
	{
		System.out.println(getText(eleBookingNo));
		return this;
	}
	
	public PhpHomePage clickHome()
	{
		click(eleHomeMenu);
		return new PhpHomePage(test, driver);
	}
}

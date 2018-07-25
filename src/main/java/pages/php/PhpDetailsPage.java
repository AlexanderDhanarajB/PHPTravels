package pages.php;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class PhpDetailsPage extends WebDriverServiceImpl{

	public PhpDetailsPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "additionalnotes")
	WebElement eleNotes;
	
	@FindBy(xpath = "//button[text()='CONFIRM THIS BOOKING']")
	WebElement eleBtnConfirm;
		
	public PhpDetailsPage enterNotes(String notes)
	{
		type(eleNotes, notes);
		return this;
	}
	
	public PhpPaymentPage clickConfirm()
	{
		click(eleBtnConfirm);
		return new PhpPaymentPage(test, driver);
	}
}

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

public class PhpHomePage extends WebDriverServiceImpl{

	public PhpHomePage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='dropdown-toggle go-text-right'])[3]")
	WebElement eleAccount;
	
	@FindBy(xpath = "(//a[@href='https://www.phptravels.net/login'])[2]")
	WebElement eleLogin;
	
	@FindBy(linkText = "Logout")
	WebElement eleLogout;
	
	public PhpHomePage clickAccount()
	{
		click(eleAccount);
		return this;
	}
	
	public PhpLoginPage clickLogin()
	{
		click(eleLogin);
		return new PhpLoginPage(test, driver);
	}
	
	public PhpLoginPage clickLogout()
	{
		click(eleLogout);
		return new PhpLoginPage(test, driver);
	}
	
}

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

public class PhpLoginPage extends WebDriverServiceImpl{

	public PhpLoginPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement eleUser;
	
	@FindBy(name = "password")
	WebElement elePass;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement eleBtnLogin;
	
	public PhpLoginPage enterUserName(String userName)
	{
		type(eleUser, userName);
		return this;
	}
	
	public PhpLoginPage enterPassword(String passWord)
	{
		type(elePass, passWord);
		return this;
	}
	
	public PhpUserHomePage clickBtnLogin()
	{
		click(eleBtnLogin);
		return new PhpUserHomePage(test, driver);
	}
}

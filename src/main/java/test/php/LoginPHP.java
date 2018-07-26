package test.php;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import lib.selenium.PreAndPostAnnotations;
import lib.selenium.PreAndPostPHP;
//import pages.lead.CreateLeadPage;
//import pages.lead.MyHomePage;
//import pages.lead.MyLeadsPage;
//import pages.lead.ViewLeadPage;
import pages.php.PhpHomePage;
import pages.php.PhpLoginPage;

public class LoginPHP extends PreAndPostPHP{
	
	@BeforeTest
	public void setVal()
	{
		testName = "PHP Travels login";
		testDesc = "Login to PHP Travels site";
		testModule = "PHP Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "LoginCredentials";
	}

	@Test(dataProvider = "PHP")
	public void loginToPhp(String userName, String password) {

		new PhpHomePage(test, driver)
		.clickAccount()
		.clickLogin();
		
		new PhpLoginPage(test, driver)
		.enterUserName(userName)
		.enterPassword(password)
		.clickBtnLogin();
	}
}

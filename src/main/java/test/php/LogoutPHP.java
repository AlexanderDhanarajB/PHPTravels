package test.php;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostPHP;
import pages.php.PhpHomePage;
//import pages.php.PhpLoginPage;

public class LogoutPHP extends PreAndPostPHP{
	
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

	@Test
	public void logoutPhp() {

		new PhpHomePage(test, driver)
		.clickAccount()
		.clickLogout();
	}
}

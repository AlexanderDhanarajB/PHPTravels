package test.php;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostPHP;
import pages.php.PhpBookingConfirmationPage;
import pages.php.PhpDetailsPage;
import pages.php.PhpHotelsPage;
import pages.php.PhpPaymentPage;
import pages.php.PhpResultsPage;
import pages.php.PhpUserHomePage;

public class BookHotel extends PreAndPostPHP{
	
	@BeforeTest
	public void setVal()
	{
		testName = "BookHotel";
		testDesc = "Book a hotel";
		testModule = "PHP Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "HotelBooking";
	}

	@Test(dataProvider = "PHP")
	public void bookHotel(String hotelName, String checkInDate, String checkOutDate, String adultCnt, String childCnt) throws InterruptedException
	{

		new PhpUserHomePage(test, driver)
		.clickHotels();
		
		new PhpHotelsPage(test, driver)
		.typeHotelName(hotelName)
		.typeCheckIn(checkInDate)
		.typeCheckOut(checkOutDate)
		.clickTravelers()
		.typeAdultCount(adultCnt)
		.typeChildCount(childCnt)
		.clickBtnSearch();
		
		if (new PhpResultsPage(test, driver).verifyNoResult())
		{
			reportSteps("Search doesn't return any value", "Fail");
		}
		else
		{
			new PhpResultsPage(test, driver)
			.clickBookNow();
			
			new PhpDetailsPage(test, driver)
			.clickConfirm();
			
			new PhpPaymentPage(test, driver)
			.clickPayOnArrival();
			
			new PhpBookingConfirmationPage(test, driver)
			.getStatus()
			.getBookingNo()
			.getInvoiceNo()
			.clickHome()
			.clickAccount()
			.clickLogout();
		}
		
	}
}

package pages.php;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class PhpHotelsPage extends WebDriverServiceImpl{

	public PhpHotelsPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//span[@class='select2-chosen']")
	WebElement eleNameSearch;
	
	@FindBy(xpath = "//input[contains(@class,'select2-input')]")
	WebElement eleHotelName;
	
	@FindBy(xpath = "(//ul[@class='select2-results']//div[@class='select2-result-label'])[2]")
	WebElement eleSelectHotel;
	
	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//input[@placeholder='Check in']")
	WebElement eleChkInSearch;
	
	@FindBy(xpath = "//input[@placeholder='Check in']")
	WebElement eleCheckIn;
	
	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//input[@placeholder='Check out']")
	WebElement eleChkOutSearch;
	
	@FindBy(xpath = "//input[@placeholder='Check out']")
	WebElement eleCheckOut;
	
	@FindBy(id = "travellersInput")
	WebElement eleTravelersCount;
	
	@FindBy(id = "adultInput")
	WebElement eleAdultCount;
	
	@FindBy(id = "childInput")
	WebElement eleChildCount;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement eleBtnSearch;
	
	public PhpHotelsPage typeHotelName(String hotelName)
	{
		click(eleNameSearch);
		type(eleHotelName, hotelName);
		click(eleSelectHotel);
		return this;
	}
	
	public PhpHotelsPage typeCheckIn(String checkInDate)
	{
		click(eleChkInSearch);
		type(eleCheckIn, checkInDate);
		return this;
	}
	
	public PhpHotelsPage typeCheckOut(String checkOutDate)
	{
		click(eleChkOutSearch);
		type(eleCheckOut, checkOutDate);
		return this;
	}
	
	public PhpHotelsPage clickTravelers() throws InterruptedException
	{
		click(eleTravelersCount);
		Thread.sleep(1000);
		return new PhpHotelsPage(test, driver);
	}
	
	public PhpHotelsPage typeAdultCount(String adultCnt)
	{
		clearType(eleAdultCount, adultCnt);
		return this;
	}
	
	public PhpHotelsPage typeChildCount(String childCnt)
	{
		clearType(eleChildCount, childCnt);
		return this;
	}
	
	public PhpResultsPage clickBtnSearch()
	{
		click(eleBtnSearch);
		return new PhpResultsPage(test, driver);
	}
}

package ratecalculator.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import ratecalculator.objects.RateCalculator;

public class RateCalculatorTests {

	WebDriver driver;
	
	@BeforeClass
	void setUp() {
		
		driver = new ChromeDriver();
		driver.get("https://www.pos.com.my/send/ratecalculator");
		driver.manage().window().maximize();
		
	 
	}
	
	@Test
	void calculateShippingRate() throws InterruptedException {
		
		RateCalculator rate_cal = new RateCalculator(driver);
		rate_cal.enterFromPostcode("35600");
		rate_cal.selectToCountry();
		rate_cal.enterWeight("1");
		rate_cal.calculateRate();
		rate_cal.verifyQuotes();
	}
	
	@AfterClass
	void endTest() {
		
		driver.quit();
	}
	
}


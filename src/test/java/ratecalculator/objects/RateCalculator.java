package ratecalculator.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class RateCalculator {

	WebDriver driver;
	WebDriverWait wait;

	//default constructor
	public RateCalculator(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	}

	// locators
	By fromPostcode_txt = By.xpath("//input[@formControlName='postcodeFrom']");
	By country_ddown = By.xpath("//input[@name='country']");
	By option_india = By.xpath("//div[@id='cdk-overlay-4']");
	By weight_txt = By.xpath("//input[@formcontrolname='itemWeight']");
	By calculate_btn = By.xpath("//*[starts-with(@type,' button')]");
	By quote_details = By.xpath("//*[contains(@class, 'border-gray-300')]");

	// methods
	public void enterFromPostcode(String postcode) {

		WebElement fromPostcode = wait.until(ExpectedConditions.visibilityOfElementLocated(fromPostcode_txt));
		fromPostcode.sendKeys(postcode);

	}

	public void selectToCountry() throws InterruptedException {

		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(country_ddown));
		countryDropdown.click();
		countryDropdown.clear();
		countryDropdown.sendKeys("India");
		Thread.sleep(1000);

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(option_india));
		option.click();

	}

	public void enterWeight(String weight) {

		WebElement inputWeight = wait.until(ExpectedConditions.visibilityOfElementLocated(weight_txt));
		inputWeight.sendKeys(weight);

	}

	public void calculateRate() {

		WebElement calculate = wait.until(ExpectedConditions.elementToBeClickable(calculate_btn));
		calculate.click();

	}

	public void verifyQuotes() {

		List<WebElement> quotes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((quote_details)));
		Assert.assertTrue(quotes.size() > 0, "Shipment quotes populated");
	}

}

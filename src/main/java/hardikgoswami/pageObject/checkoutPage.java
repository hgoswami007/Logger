package hardikgoswami.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import hardikgoswami.Abstract.AbstractData;

public class checkoutPage extends AbstractData{
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy (xpath = "//div[text()='CVV Code ']")
	WebElement cvvCode;
	
	@FindBy (xpath = "//div[text()='Name on Card ']")
	WebElement nameOnCard;
	
	
	@FindBy (xpath = "//input[@placeholder='Select Country']")
	WebElement countryNameTextBox;
	
	@FindBy (xpath = "//button/span")
	List<WebElement> countrySuggestionAppear;

	@FindBy (css=".action__submit")
	WebElement placeorder;
	
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String selectCoutryName) throws InterruptedException {
		By selectCountry = By.xpath("//button/span[text()=' %s']".formatted(selectCoutryName));
		Actions a = new Actions(driver);
		a.sendKeys(countryNameTextBox, selectCoutryName).build().perform();	
		waitForElementVisible(results);
		clickOnElement(selectCountry);	
	}
	
	public confirmationPage placeOrder() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(placeorder);
		return new confirmationPage(driver);
	}
}

package hardikgoswami.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hardikgoswami.Abstract.AbstractData;

public class confirmationPage extends AbstractData {
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary") 
	WebElement thankyouText;
	
	public String verifyOrderText() {
		return thankyouText.getText();
	}

	
}

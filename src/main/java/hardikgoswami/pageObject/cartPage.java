package hardikgoswami.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hardikgoswami.Abstract.AbstractData;


public class cartPage extends AbstractData {
	
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement gotoCheckoutPage;
	
	public Boolean verifyProductDisplay(String ProductName) {
		cartProducts.stream().forEach(cartProduct->System.out.println(cartProduct.getText()));
		Boolean matchProducts = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return matchProducts;
	}
	
	public checkoutPage gotoCheckOutPage() {
		gotoCheckoutPage.click();
		checkoutPage checkoutPage = new checkoutPage(driver);
		return checkoutPage;
	}

}

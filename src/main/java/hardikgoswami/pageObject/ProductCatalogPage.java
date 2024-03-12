package hardikgoswami.pageObject;


import java.util.List;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import haardikgoswami.logger.loggerData;
import hardikgoswami.Abstract.AbstractData;

public class ProductCatalogPage extends AbstractData {

	WebDriver driver;
	List<String> Produts;
	Logger log = new loggerData().getLog();
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	
	By ListElement = By.cssSelector(".mb-3");
	By AddtoCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> GetAllProductList() {
		try {
			waitForElementVisible(ListElement);		
			log.info("All the products are visible");
		} catch (Exception e) {
			System.out.println(e);
			log.error("Something is not working in GetAllProductList");
		}
		return Products;	
	}
	public WebElement GetProductbyName(String productName) {
		WebElement ProdName = Products.stream().filter(Products->Products.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return ProdName;
	}
	
	public void AddProductToCart(String productName) {
		WebElement getProduct = GetProductbyName(productName);
		getProduct.findElement(AddtoCart).click();
		waitForElementVisible(spinner);
		waitForElementVisible(toastMessage);
	}
	
}

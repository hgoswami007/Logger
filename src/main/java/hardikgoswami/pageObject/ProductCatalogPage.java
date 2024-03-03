package hardikgoswami.pageObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hardikgoswami.Abstract.AbstractData;

public class ProductCatalogPage extends AbstractData {

	WebDriver driver;
	List<String> ProdutsName;
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	public List<String> GetAllProductsName() {
		ProdutsName = Products.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(ProdutsName);
		return ProdutsName;	
	}
	public void GetProductbyName() {
		
	}
	public void AddProductToCart() {
		
	}
	
}

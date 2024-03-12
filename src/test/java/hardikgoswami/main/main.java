package hardikgoswami.main;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.css.model.StyleSheetOrigin;
import org.testng.Assert;
import org.testng.annotations.Test;

import hardikgoswami.Abstract.AbstractData;
import hardikgoswami.Abstract.excelData;
import hardikgoswami.TestComponents.BaseTest;
import hardikgoswami.pageObject.LandingPage;
import hardikgoswami.pageObject.ProductCatalogPage;
import hardikgoswami.pageObject.cartPage;
import hardikgoswami.pageObject.checkoutPage;
import hardikgoswami.pageObject.confirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class main  {
	BaseTest bTest = new BaseTest();
	
//	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
//		AbstractData ss = new AbstractData(driver);
		
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.NavigatesToURL();
//		landingPage.loginApplication("warforpeace50@gmail.com","Test@123" );
		
				
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		
//	WebElement prod =	products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		//ng-animating
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
//	Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//	Assert.assertTrue(match);
//	driver.findElement(By.cssSelector(".totalRow button")).click();
//	
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
//	
//	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
//	}
	@Test
	public void runMethod() throws IOException, InterruptedException {
		
		WebDriver driver = bTest.initiliazeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ProductName = "ZARA COAT 3";
		LandingPage loginApp = new LandingPage(driver);
		loginApp.NavigatesToURL();
		ProductCatalogPage ProductCatalogPage = loginApp.loginApplication("warforpeace50@gmail.com","Test@123");

		ProductCatalogPage.GetAllProductList();
		ProductCatalogPage.AddProductToCart(ProductName);
		Thread.sleep(2000);
		cartPage cartPage =ProductCatalogPage.gotoCartPage();
		Boolean match = cartPage.verifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		Thread.sleep(2000);
		checkoutPage checkoutPage = cartPage.gotoCheckOutPage();
		checkoutPage.selectCountry("India");
		confirmationPage confirmationPage = checkoutPage.placeOrder();
		String text = confirmationPage.verifyOrderText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));;
		driver.close();
		
		
	}


}
package hardikgoswami.main;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hardikgoswami.Abstract.AbstractData;
import hardikgoswami.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class main  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		AbstractData ss = new AbstractData(driver);
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.NavigatesToURL();
		landingPage.loginApplication("warforpeace50@gmail.com","Test@123" );
		
		ss.getScreenshot();
		
		
		
//		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//		driver.findElement(By.id("login")).click();
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
		
		
	}

}
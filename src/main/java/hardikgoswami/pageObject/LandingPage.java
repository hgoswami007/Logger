package hardikgoswami.pageObject;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import hardikgoswami.Abstract.AbstractData;


public class LandingPage  {	
	
//	Logger log = getLog();
	WebDriver driver;
	 
	 
	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginApplication(String Email, String Password) 
	{
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		loginButton.click();
		
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
//	

	
	public void NavigatesToURL() {
		driver.get("https://rahulshettyacademy.com/client/");
//		log.info("User is navigate to URL");
				
	}
	
//	public ProductCatalogPage LoginApplication(String Email,String Password) throws InterruptedException {
//		userEmail.sendKeys(Email);
//		userPassword.sendKeys("Password");
//		Thread.sleep(3000);
//		LoginButton.click();
//		ProductCatalogPage productcatalogpage = new ProductCatalogPage(driver);
//		return productcatalogpage;
//}

}

package hardikgoswami.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import haardikgoswami.logger.loggerData;
import org.apache.logging.log4j.core.Logger;


import hardikgoswami.Abstract.AbstractData;


public class LandingPage extends AbstractData {	
	

	
	WebDriver driver;
	Logger log = new loggerData().getLog();
	public String Email; public String Password;
	 
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ProductCatalogPage loginApplication(String Email, String Password) 
	{
		ProductCatalogPage ProductCatalogPage = null;
		
		try {
			userEmail.sendKeys(Email);
			log.info("Email has been added", Email);
			userPassword.sendKeys(Password);
			log.info("Password has been added", Password);
			loginButton.click();
			log.info("User has click on Login button");
			ProductCatalogPage = new ProductCatalogPage(driver);
			
		}
		catch(Exception e){
			log.error("Something is wrong in login Application methods",e);
		}
		log.info("User has successfully login to the applicaiton");
		
		return ProductCatalogPage;
		
		
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	
	public void NavigatesToURL() {
		driver.get("https://rahulshettyacademy.com/client/");
		log.info("User is navigate to URL");				
	}
	
	public String  getErrorMessage() {
		String getText = errorMessage.getText();
		return getText;
		
		
	}
		

}

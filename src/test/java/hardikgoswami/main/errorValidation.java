package hardikgoswami.main;

import org.testng.Assert;

import hardikgoswami.TestComponents.BaseTest;
import hardikgoswami.pageObject.LandingPage;

public class errorValidation extends BaseTest {
	
	public void loginErrorValidation() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.NavigatesToURL();
		landingPage.loginApplication("warforpeace50@gmail.com","Test@123456");
		
		Assert.assertEquals("Incorrect email or password", landingPage.getErrorMessage());
	}

}

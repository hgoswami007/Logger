package hardikgoswami.main;

import java.io.IOException;

import org.testng.annotations.Test;

import hardikgoswami.TestComponents.BaseTest;
import hardikgoswami.pageObject.LandingPage;
import hardikgoswami.pageObject.ProductCatalogPage;
import jdk.internal.org.jline.utils.Log;

public class main extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		LandingPage landingPage = launchApplication();
		ProductCatalogPage productcatalogpage = landingPage.LoginApplication("warforpeace50@gmail.com", "Test@123");
		productcatalogpage.GetAllProductsName();
		
		
	}
}

package hardikgoswami.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import hardikgoswami.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver initiliazeDriver() throws IOException {
	Properties prop = new Properties(); 
	FileInputStream fis = new FileInputStream("D:\\Selenium Framework\\SeleniumFramework\\src\\main\\java\\hardikgoswami\\resourse\\global.properties");
	prop.load(fis);
	String browserName= prop.getProperty("browser");
	
	System.out.println(browserName);
	
	if (browserName.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (browserName.contains("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(browserName.contains("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	return driver;
	}
	
	
//	public LandingPage launchApplication() throws IOException {
//		driver = initiliazeDriver();
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.NavigatesToURL();
//		return landingPage;
//	}
}

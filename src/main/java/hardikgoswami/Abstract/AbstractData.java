package hardikgoswami.Abstract;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class AbstractData {

	WebDriver driver;
	public AbstractData(WebDriver driver) {
		this.driver = driver;
	}
	
	public Logger getLog()  {
		// TODO Auto-generated method stub
		Logger log = (Logger) LogManager.getLogger(AbstractData.class.getName());
		return log;

	}
	public void getScreenshot() throws IOException {
		System.out.println("Hello==========");
//		File ssfileSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(ssfileSrc, new File("D://Selenium Framework//SeleniumFramework//ss.png"));
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("D://Selenium Framework//SeleniumFramework//ss.png");
		FileUtils.copyFile(source, file);
	}
}

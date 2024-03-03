package hardikgoswami.Abstract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
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
	
}

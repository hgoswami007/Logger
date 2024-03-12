package hardikgoswami.Abstract;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hardikgoswami.pageObject.cartPage;

public class AbstractData {

	static WebDriver driver;

	public AbstractData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public static String getScreenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports" + "\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports" + "\\" + testCaseName + ".png";
	}

	public void waitForElementVisible(By visibleElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visibleElement));
	}

	public void waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public cartPage gotoCartPage() {
		cartHeader.click();
		cartPage cartPage = new cartPage(driver);
		return cartPage;

	}

	public void gotoOrderPage() {
		orderHeader.click();
	}

	public void sendKeys(WebElement keys, String data) {
		keys.sendKeys(data);
	}
	
	public void clickOnElement(WebElement keys) {
		keys.click();
	}
	public void clickOnElement(By keys) {
		driver.findElement(keys).click();
	}
}

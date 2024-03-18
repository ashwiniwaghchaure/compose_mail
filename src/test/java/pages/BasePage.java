package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public TakesScreenshot ts = (TakesScreenshot) driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void selectDropdownOption(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void sendKeys(WebElement element, String text) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			try {
				element.sendKeys(text);
			} catch (IllegalArgumentException e) {
				System.out.println("You can not enter null value in text box");
			}
		}
	}

	public String captureScreenshot(String name) {

		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + name + ".jpg";
		File dest = new File(path);
		try {
			FileHandler.copy(src, dest);
		} catch (Exception e) {
		}
		return path;
	}

	public void clickElement(By locator) {
		wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void actionClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

}

package pages;

import java.util.Base64;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public Logger log = Logger.getLogger(LoginPage.class);

	By email = By.name("identifier");
	By nextButton = By.xpath("//button/span[text() ='Next']");
	By password = By.xpath("//input[@name='Passwd']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String emailId, String passwordText) {
		setEmail(emailId);
		clickOnNextButton();
		setPassword(passwordText);
		clickOnNextButton();
	}

	public void setEmail(String emailId) {
		driver.findElement(email).sendKeys(emailId);
	}

	public void setPassword(String passwordText) {

		driver.findElement(password).sendKeys(new String(Base64.getDecoder().decode(passwordText)));
	}

	public void clickOnNextButton() {
		try {
			driver.findElement(nextButton).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//button/span[text() ='Next']")).click();
		}

	}

}

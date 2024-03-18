package pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InboxPage extends BasePage {

	public Logger log = Logger.getLogger(InboxPage.class);

	By composeButton = By.xpath("//div[.='Compose' and @Role='button']");
	By sendBtn = By.xpath("//div[@role='dialog']//div[.='Send']");
	By subject = By.xpath("//input[@name='subjectbox']");

	By msgBody = By.xpath("//div[@aria-label='Message Body']");
	By toField = By.xpath("//span[text()='To']");
	By toFieldEmailInput = By.xpath("//span[text()='To']/parent::div/parent::td/parent::tr//input");
	By cc = By.xpath("//span[text()='Cc'][1]");
	By bcc = By.xpath("//span[text()='Bcc'][1]");
	By myContactDropdown = By.xpath("//span[text()='My contacts']");
	By searchForContact = By.xpath("//input[@value='Search for contacts']");
	By sentBox = By.xpath("//a[text()='Sent']");
	By cancleBtn = By.xpath("//img[@class='Ha']");
	By recipients = By.xpath("//div[.='Recipients']");
	By sendBtnError = By.xpath("//div[@class='bwApif-bHk']");
	By errorOKBtn = By.xpath("//span[text()='OK']");

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	public void verifySuccessfulLogin() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(composeButton)));
		String currentTitle = driver.getTitle();
		log.debug("Current title is: " + currentTitle);
		assertTrue(currentTitle.contains("Inbox"), "User is not logged in!");

	}

	public void verifyComposeButtonIsDisplayed() {
		Assert.assertTrue(driver.findElements(composeButton).size() > 0, "Compose Button Could not be found !");
	}

	public void clickOnComposeBtn() {

		clickElement(composeButton);
	}

	public void verifyNewMessagePopupIsDisplayed() {
		Assert.assertTrue(driver.findElement(sendBtn).isDisplayed(), " New Message Popup is not displayed !");

	}

	public void enterValidRecepientEmailid() {
		log.info("Fail");
		WebElement recipientElement = wait.until(ExpectedConditions.elementToBeClickable(recipients));
		actionClick(recipientElement);
		sendKeys(driver.findElement(toFieldEmailInput), "ajitthakare123@gmail.com");
	}

	public void enterSubject() {

		driver.findElement(subject).sendKeys("compose mail");
	}

	public void enterMsgInBody() {
		WebElement bodyElement = wait.until(ExpectedConditions.elementToBeClickable(msgBody));
		System.out.println("Is element displayed: " + bodyElement.isDisplayed());
		System.out.println("Is element enabled: " + bodyElement.isEnabled());
		bodyElement.click();
		try {
			Thread.sleep(5000);
			bodyElement.sendKeys("Hallo all see you soon...");
		} catch (InterruptedException e) {
			System.out.println("Element still not interactable. Investigate further.");
			e.printStackTrace();
		}

	}

	public void clickSendBtn() {

		clickElement(sendBtn);
	}

	public void clickCancleBtn() {
		clickElement(cancleBtn);

	}

	public String errorOnClickingSendBtnOnly() {
		WebElement sendErrorElement = wait.until(ExpectedConditions.elementToBeClickable(sendBtnError));
		System.out.println("Is element displayed: " + sendErrorElement.isDisplayed());
		System.out.println("Is element enabled: " + sendErrorElement.isEnabled());
		return (sendErrorElement.getText());

	}
}

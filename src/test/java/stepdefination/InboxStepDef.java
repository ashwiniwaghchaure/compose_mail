package stepdefination;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InboxStepDef extends BaseTest {

	@When("user click on compose button")
	public void userClickOnComposeButton() {
		inboxPage.clickOnComposeBtn();

	}

	@Then("user verifies compose button is displayed")
	public void verifyComposeButtonIsDisplayed() {
		inboxPage.verifyComposeButtonIsDisplayed();
	}

	@Then("verify user is logged in successfully")
	public void verifyUserLogin() {
		inboxPage.verifySuccessfulLogin();
	}

	@Then("verify compose window is open")
	public void verifyComposeWindowIsDisplayed() {

		inboxPage.verifyNewMessagePopupIsDisplayed();
	}

	@When("user enter recepient email id")
	public void clickOnToFieldandEnterValidRecepientEmailid() {

		inboxPage.enterValidRecepientEmailid();
	}

	@When("user enter subject in subject field")
	public void enterSubjectInSubjectField() {
		inboxPage.enterSubject();
	}

	@When("user enter mail message in message body")
	public void enterMailMessageInMessageBody() throws InterruptedException {
		inboxPage.enterMsgInBody();

	}

	@When("user click on Send button")
	public void clickOnSendBtn() {
		inboxPage.clickSendBtn();
	}

	@Then("verify mail get send successfully.")
	public void verifyMailGetSendSuccessfully() {

	}

	@When("user click on cancle button")
	public void clickOnCancleButton() {
		inboxPage.clickCancleBtn();
	}

	@Then("verify mail get saved as a draft")
	public void verifyMailGetSavedAsaDraft() {
		log.info("Mail saved as a draft");
	}

	

	@Then("verify Error message for invalid emailid.")
	public void verifyErrorForInvalidEmail() {
		String mailError = inboxPage.invalidEmailIdError();
		Assert.assertEquals(mailError, "Send this message without a subject or text in the body?");

	}

	@Then("verify Error message for clicking on Send btn without entering credentials.")
	public void verifyErrorOnClickingSendBtnOnly() {
		String sendErrorMsg = inboxPage.errorOnClickingSendBtnOnly();
		Assert.assertEquals(sendErrorMsg, "Please specify at least one recipient.");
	}
	@When("user enter invalid recepient email id")
	public void EnterInvalidValidRecepientEmailid() {
		inboxPage.enterInvalidRecepientEmailid();
	}


	@After
	public void browserTearDown() {
		driver.close();
	}

}

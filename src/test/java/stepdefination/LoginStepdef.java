package stepdefination;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepdef extends BaseTest {

	@Given("user is on login page")
	public void openLoginPage() {
		LoginStepdef.setup();

	}

	@When("user enters email as {string}")
	public void userEntersEmail(String emailId) {
		loginPage.setEmail(emailId);
	}

	@When("user enters encoded password as {string}")
	public void userEntersPassword(String passwordText) {
		loginPage.setPassword(passwordText);
	}

	@When("user click on Next button")
	public void click_on_next_button() {
		loginPage.clickOnNextButton();
	}

}

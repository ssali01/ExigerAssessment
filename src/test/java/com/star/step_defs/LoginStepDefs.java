package com.star.step_defs;

import com.star.pages.LoginPage;
import com.star.utils.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("This part is taken care by Hooks Class");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.signin("role1");
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        BrowserUtils.waitForClickablility(loginPage.loginButton, 5).click();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        BrowserUtils.verifyElementDisplayed(By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));
    }

    @Then("user should see the dashboard page")
    public void user_should_see_the_dashboard_page() {
        BrowserUtils.waitForUrlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        loginPage.signin("role2");
        BrowserUtils.waitForClickablility(loginPage.loginButton, 5).click();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(loginPage.invalidCredentialsMsg.isDisplayed());
    }

    @When("user enters invalid data")
    public void user_enters_invalid_data(List<Map<String, String>> credentials) {
       loginPage.enteringInvalidCredentials(credentials);
    }
    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
       assertTrue(loginPage.invalidCredentialsMsg.isDisplayed());
    }


    @When("user enters  {string} and {string}")
    public void userEntersAnd(String username, String password) {
        loginPage.enterInvalidCredWithScenarioOutline(username, password);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        BrowserUtils.waitForClickablility(loginPage.loginButton, 5).click();
    }
}




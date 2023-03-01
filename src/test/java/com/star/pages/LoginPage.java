package com.star.pages;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import com.star.utils.ConfigurationReader;
import com.star.utils.Driver;
import com.star.utils.Environment;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[.='Invalid credentials']")
    public WebElement invalidCredentialsMsg;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

    public void signin(String role) {
        String username = "";
        String password = "";

        switch (role) {
            case "role1":
                username = Environment.ROLE1_EMAIL;
                password = Environment.ROLE1_PASSWORD;
                break;

            case "role2":
                username = Environment.ROLE2_EMAIL;
                password = Environment.ROLE2_PASSWORD;
                break;
            case "role3":
                username = Environment.ROLE3_EMAIL;
                password = Environment.ROLE3_PASSWORD;
                break;
            default:

                throw new RuntimeException("Invalid Role Entry : >> " + role + " <<");
        }


        wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
        inputUsername.sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        inputPassword.sendKeys(password);

    }

    /**
     * Invalid credentials
     *
     * @param
     */
    public void enteringInvalidCredentials(List<Map<String, String>> data) {

        for (Map<String, String> row : data) {
            String username = row.get("username");
            String password = row.get("password");

            wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
            inputUsername.sendKeys(username);

            wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
            inputPassword.sendKeys(password);

            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        }

    }
    public void enterInvalidCredWithScenarioOutline(String username, String password){
        wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
        inputUsername.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        inputPassword.sendKeys(password);

    }

}

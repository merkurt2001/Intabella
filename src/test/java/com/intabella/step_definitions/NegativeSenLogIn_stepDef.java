package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NegativeSenLogIn_stepDef {

    @When("the user logs in using following credentials {string} and {string}")
    public void the_user_logs_in_using_following_credentials_and(String username, String password) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
        new LoginPage().login(username, password);
    }

    @Then("the following {string} should be displayed")
    public void the_following_should_be_displayed(String message) {

        LoginPage loginPage = new LoginPage();

        switch (message) {
            case "Invalid user name or password.":
                String msg = loginPage.getMessage();
                System.out.println("msg = " + msg);
                Assert.assertEquals(message, msg);

                break;
            case "Please fill in this field.":

//                if (loginPage.userName.getAttribute("value") == null &&
//                        loginPage.password.getAttribute("value") == null) {
//                    Assert.assertEquals(message, loginPage.userName.getAttribute("validationMessage"));
                if (loginPage.userName.getAttribute("value") == null) {
                    Assert.assertEquals(message, loginPage.userName.getAttribute("validationMessage"));
                } else if (loginPage.password.getAttribute("value") == null) {
                    Assert.assertEquals(message, loginPage.password.getAttribute("validationMessage"));
                }
                break;

        }

    }
}
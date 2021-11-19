package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserShouldntlog_stepDeff {

    @Given("the user enters the username {string} and password {string} information")
    public void the_user_enters_the_username_and_password_information(String username, String password) {
        new LoginPage().login(username,password);
    }

    @When("the user copy the url after log in")
    public void the_user_copy_the_url_after_log_in() {

        BrowserUtils.waitFor(5);
        String url = Driver.get().getCurrentUrl();
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Dashboard";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("the user log out")
    public void the_user_log_out() {

        new LoginPage().logOutUser();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user can not login with paste the url to browser")
    public void the_user_can_not_login_with_paste_the_url_to_browser() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,actualTitle);



    }


}

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
import org.openqa.selenium.By;

public class LogInFun_stepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the {string} enters the username {string} and password {string} information")
    public void the_enters_the_username_and_password_information(String userType, String username,
                                                                 String password) {
        new LoginPage().login(username,password);

    }

    @Then("the {string} should land on {string}")
    public void the_should_land_on(String userType, String land){
        DashboardPage dashboardPage = new DashboardPage();
        String pageSubTitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(land,pageSubTitle);
    }

}

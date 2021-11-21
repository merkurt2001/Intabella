package com.intabella.step_definitions;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOutFun_stepDef {

    @Then("the user should land at login page")
    public void the_user_should_land_at_login_page() {

        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user can go back to home page by clicking the step back arrow button")
    public void the_user_can_go_back_to_home_page_by_clicking_the_step_back_arrow_button() {

        Driver.get().navigate().back();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user close the current tab or all the others")
    public void the_user_close_the_current_tab_or_all_the_others() {

        String url = Driver.get().getCurrentUrl();
        Driver.closeDriver();
    }

    @Then("user should loged out")
    public void user_should_loged_out() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}

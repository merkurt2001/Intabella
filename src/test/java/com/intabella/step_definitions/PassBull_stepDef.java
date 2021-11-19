package com.intabella.step_definitions;

import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PassBull_stepDef {

    @When("typing anything {string} in the password input box")
    public void typing_anything_in_the_password_input_box(String typing) {

        new LoginPage().password.sendKeys(typing);
    }

    @Then("the user should see the input box field in bullet sings by default")
    public void the_user_should_see_the_input_box_field_in_bullet_sings_by_default() {

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.password.isEnabled());

    }
}

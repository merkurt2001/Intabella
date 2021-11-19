package com.intabella.step_definitions;

import com.intabella.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class UserLandForgot_stepDef {

    @When("the user click on the Forgot Passord")
    public void the_user_click_on_the_Forgot_Passord() {

        Driver.get().findElement(By.linkText("Forgot your password?")).click();

    }

    @Then("the user should land on the Forgot Password page")
    public void the_user_should_land_on_the_Forgot_Password_page() {

        String atualTitle = Driver.get().getTitle();
        String expectedTitle = "Forgot Password";
        Assert.assertEquals(expectedTitle,atualTitle);
    }

}

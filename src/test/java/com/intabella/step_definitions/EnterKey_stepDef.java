package com.intabella.step_definitions;

import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.awt.*;


public class EnterKey_stepDef {

    @When("the user clicks the username input box hits the Enter key from keyboard")
    public void the_user_clicks_the_username_input_box_hits_the_Enter_key_from_keyboard() throws AWTException {

        LoginPage loginPage = new LoginPage();
        loginPage.userName.click();
        loginPage.userName.sendKeys("user1");
        BrowserUtils.pressKeyboardKey("ENTER",1);


    }

    @Then("the user coursor should land on the password input box hits Enter again Login button should cklicked")
    public void the_user_coursor_should_land_on_the_password_input_box_hits_Enter_again_Login_button_should_cklicked() throws AWTException {// Write code here that turns the phrase above into concrete actions

        LoginPage loginPage = new LoginPage();
        loginPage.password.sendKeys("UserUser123");
        BrowserUtils.pressKeyboardKey("ENTER",1);
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

}

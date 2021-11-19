package com.intabella.step_definitions;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserCanRem_stepDef {

    @Given("the user should see the Remember me and should be able to clcik")
    public void the_user_should_see_the_Remember_me_and_should_be_able_to_clcik() {

        WebElement remeberMe = Driver.get().findElement(By.cssSelector(".custom-checkbox__icon"));
        remeberMe.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(remeberMe.isEnabled());

        remeberMe.click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(remeberMe.isEnabled());
    }
}

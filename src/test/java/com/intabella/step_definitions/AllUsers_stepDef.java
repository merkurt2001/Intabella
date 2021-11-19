package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class AllUsers_stepDef {

    @Then("the user {string} can see own username {string} after successful login")
    public void the_user_can_see_own_username_after_successful_login(String string, String UserName) {

        String actualName = new DashboardPage().getUserName();
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(UserName,actualName);


    }

}
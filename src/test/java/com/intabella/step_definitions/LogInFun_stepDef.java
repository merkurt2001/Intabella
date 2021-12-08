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
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LogInFun_stepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        new LoginPage().logInAsdifferntUser(userType);
    }

    @When("the {string} enters the username {string} and password {string} information")
    public void the_enters_the_username_and_password_information(String userType, String username,
                                                                 String password) {
        new LoginPage().login(username,password);
    }

    @Then("the {string} should land on {string}")
    public void the_should_land_on(String userType, String land)throws Exception{

        DashboardPage dashboardPage = new DashboardPage();
        String pageSubTitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(land,pageSubTitle);
    }

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

        new DashboardPage().waitUntilLoaderScreenDisappear();
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

    @Then("the user {string} can see own username {string} after successful login")
    public void the_user_can_see_own_username_after_successful_login(String string, String UserName) {

        String actualName = new DashboardPage().getUserName();
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(UserName,actualName);
    }

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

    @When("typing anything {string} in the password input box")
    public void typing_anything_in_the_password_input_box(String typing) {

        new LoginPage().password.sendKeys(typing);
    }

    @Then("the user should see the input box field in bullet sings by default")
    public void the_user_should_see_the_input_box_field_in_bullet_sings_by_default() {

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.password.isEnabled());
    }

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

    @When("the user clicks the username input box hits the Enter key from keyboard")
    public void the_user_clicks_the_username_input_box_hits_the_Enter_key_from_keyboard() throws AWTException {

        LoginPage loginPage = new LoginPage();
        loginPage.userName.click();
        loginPage.userName.sendKeys("user1");
        BrowserUtils.pressKeyboardKey("ENTER",1);
//        Driver.get().findElement(By.id("prependedInput")).sendKeys("user1", Keys.ENTER);
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

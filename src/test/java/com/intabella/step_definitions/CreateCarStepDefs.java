package com.intabella.step_definitions;


import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.pages.CreateCarPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;
import com.intabella.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefs {

    CreateCarPage createCarPage = new CreateCarPage();

    @Given("the user goes to the login page")
    public void the_user_goes_to_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
    }

    @When("^the user logged in as (.*) and (.*)$")
    public void the_user_logged_in_as_something_and_something(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Then("^the user hover over Fleet$")
    public void the_user_hover_over_fleet() throws InterruptedException {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        new DashboardPage().waitUntilElementAppear("(//span[contains(text(),'Fleet')])[1]");
        Actions builder = new Actions(Driver.get());
        WebElement element = Driver.get().findElement(By.xpath("(//span[contains(text(),'Fleet')])[1]"));
        builder.moveToElement(element).build().perform();
    }

    @Then("^the user clicks on Vehicles menu item$")
    public void the_user_clicks_on_vehicles_menu_item() throws InterruptedException {
        new DashboardPage().waitUntilElementAppear("//span[text()='Vehicles']");
        Driver.get().findElement(By.xpath("//span[text()='Vehicles']")).click();
    }

    @Then("^the user click on Create car button$")
    public void the_user_click_on_create_car_button() {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().waitUntilElementAppear("//a[@title='Create Car']");
        Driver.get().findElement(By.xpath("//a[@title='Create Car']")).click();
    }

    @Then("^the user lands on Create Car Form$")
    public void the_user_lans_on_create_car_form() throws Throwable {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().waitUntilElementAppear("//input[@name='custom_entity_type[LicensePlate]']");
    }

    @And("^All form elements should be filled according to their types$")
    public void all_form_elements_should_be_filled_according_to_their_types() {
        createCarPage.shouldBeFilledFromExcel();
    }
}


package com.intabella.step_definitions;


import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.CarInfoReader;
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

import java.util.List;
import java.util.Map;

public class CreateCarStepDefs {

    @Given("the user goes to the login page")
    public void the_user_goes_to_the_login_page(){
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
    }

    @When("^the user logged in as (.*) and (.*)$")
    public void the_user_logged_in_as_something_and_something(String username, String password) {
        new LoginPage().login(username,password);
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
    public void the_user_click_on_create_car_button(){
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
    public void all_form_elements_should_be_filled_according_to_their_types(){
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LicensePlate]']")).sendKeys(CarInfoReader.get("licence_plate"));
            int count = Driver.get().findElements(By.xpath("//div[@data-ftid='custom_entity_type_Tags']/div")).size();
            for(int c=1; c <= count; c++){
                Driver.get().findElement(By.xpath("(//div[@data-ftid='custom_entity_type_Tags']/div)["+c+"]/input")).click();
            }
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Driver]']")).sendKeys(CarInfoReader.get("driver_name"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Location]']")).sendKeys(CarInfoReader.get("location"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ChassisNumber]']")).sendKeys(CarInfoReader.get("chassis_number").replace(".0",""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ModelYear]']")).sendKeys(CarInfoReader.get("model_year"));
            System.out.println("Last otomater");
            String lastOdometer = CarInfoReader.get("last_odometer").replace(".0","");
            System.out.print(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LastOdometer]']")).sendKeys(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CatalogValue]']")).sendKeys(CarInfoReader.get("catalog_value"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[SeatsNumber]']")).sendKeys(CarInfoReader.get("seats_number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[DoorsNumber]']")).sendKeys(CarInfoReader.get("doors_number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Color]']")).sendKeys(CarInfoReader.get("color"));

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Automatic']")).click();

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Hybrid']")).click();

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CO2Emissions]']")).sendKeys(CarInfoReader.get("co2_emissions"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Horsepower]']")).sendKeys(CarInfoReader.get("horsepower").replace(".0",""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[HorsepowerTaxation]']")).sendKeys(CarInfoReader.get("horsepower_taxation"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Power]']")).sendKeys(CarInfoReader.get("power").replace(".0",""));
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")).sendKeys(CarInfoReader.get("immatriculation_date"));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_FirstContractDate')]")).sendKeys(CarInfoReader.get("first_contract_date"));
            File file = new File("src/test/resources/volvo.png");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Logo][file]']")).sendKeys(file.getAbsolutePath());
            JavascriptExecutor js = (JavascriptExecutor) Driver.get();
            js.executeScript("document.getElementsByClassName('btn btn-success action-button')[0].click()");
            new DashboardPage().waitUntilLoaderScreenDisappear();
    }


}

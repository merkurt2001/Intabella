package com.intabella.step_definitions;

import com.intabella.pages.VehicleTableArrangementPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import com.intabella.utilities.Pages;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleTableArrangementStepDef {
   Pages pages=new Pages();

    @Given("User click to View per page button")
    public void user_click_to_View_per_page_button() {

        pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.click();
    }

    @Given("user verify if the value of View per page is {int}")
    public void user_verify_if_the_value_of_View_per_page_is(Integer int1) {
        Assert.assertEquals("25",pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.getText());
    }

    @Given("User select  one of the options")
    public void user_select_one_of_the_options() {
    List<String> expectednumbers= new ArrayList<>();
    expectednumbers.add("10");
    expectednumbers.add("25");
    expectednumbers.add("50");
    expectednumbers.add("100");

        for (int i = 1; i <= pages.vehicleTableArrangementPage().vehicleViewPerPageDropdown.size(); i++) {
             WebElement element = Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])["+i+"]"));

             element.click();
            pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.click();
             Assert.assertEquals(expectednumbers.get(i-1),pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.getText());

        }

    }

    @Given("user should click on the model year module")
    public void user_should_click_on_the_model_year_module() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user verify if the model year  colum is on decending")
    public void user_verify_if_the_model_year_colum_is_on_decending() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user should click the reset button")
    public void user_should_click_the_reset_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user vefiry if model year module is back on default")
    public void user_vefiry_if_model_year_module_is_back_on_default() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

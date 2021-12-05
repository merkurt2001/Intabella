package com.intabella.step_definitions;

import com.intabella.pages.VehicleTableArrangementPage;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class VehicleTableArrangementStepDef {
    VehicleTableArrangementPage vehicleTableArrangementPage=new VehicleTableArrangementPage();
    @Given("User click to View per page button")
    public void user_click_to_View_per_page_button() {
vehicleTableArrangementPage.vehicleViewPerPageDefault.click();
    }

    @Given("user verify if the value of View per page is {int}")
    public void user_verify_if_the_value_of_View_per_page_is(Integer int1) {
        Assert.assertEquals("25",vehicleTableArrangementPage.vehicleViewPerPageDefault.getText());
    }

    @Given("user should click on view per page icon")
    public void user_should_click_on_view_per_page_icon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User select  one of the options")
    public void user_select_one_of_the_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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

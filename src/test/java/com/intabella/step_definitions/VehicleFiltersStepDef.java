package com.intabella.step_definitions;

import com.intabella.pages.Vehicle_Fleet_Page;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class VehicleFiltersStepDef {

    Vehicle_Fleet_Page vehicleFleetPage = new Vehicle_Fleet_Page();

    @Given("the user click on the filters button")
    public void the_user_click_on_the_filters_button() {
        BrowserUtils.clickWithTimeOut(vehicleFleetPage.filtersButton, 3);
    }


    @Then("the user can select the {string} under manage filters")
    public void theUserCanSelectTheUnderManageFilters(String checkbox) {
        vehicleFleetPage.manageFiltersDropdown.click();
        BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@value='"+checkbox+"']")),true);
        BrowserUtils.waitFor(3);
    }
}

package com.intabella.step_definitions;

import com.intabella.pages.Vehicle_Fleet_Page;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VehicleFiltersStepDef {

    Vehicle_Fleet_Page vehicleFleetPage = new Vehicle_Fleet_Page();

    @Given("the user click on the filters button")
    public void the_user_click_on_the_filters_button() {
        BrowserUtils.clickWithTimeOut(vehicleFleetPage.filtersButton, 3);
    }

    @Then("the user can select the {string} under manage filters")
    public void theUserCanSelectTheUnderManageFilters(String checkbox) {
        vehicleFleetPage.manageFiltersDropdown.click();
        BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@value='" + checkbox + "']")), true);
        BrowserUtils.waitFor(3);
    }

    @And("the user click {string}:All button")
    public void theUserClickAllButton(String name) {
        Driver.get().findElement(
                        By.xpath("//div[contains(text(),'" + name + "')]"))
                .click();
    }

    @Then("the user click default button under {string} filter")
    public void theUserClickDefaultButtonUnderFilter(String name) {

        Driver.get().findElement(
                By.xpath("//div[contains(text(),'"+name+"')]//parent::div//following-sibling::div//child::button[@data-toggle='dropdown']"))
                .click();

    }

    @Then("the user should see following methods under {string} filter")
    public void theUserShouldSeeFollowingMethodsUnderFilter(String filter, List<String> expectedMethods) {
        String locator = "//div[contains(text(),'"+filter+"')]/following-sibling::div//child::a[@class='dropdown-item choice-value']";
        List<WebElement> methods = Driver.get().findElements(By.xpath(locator));
        System.out.println("methods.size() = " + methods.size());
        List<String> actualMethods = BrowserUtils.getElementsText(methods);
        System.out.println("expectedMethods = " + expectedMethods);
        System.out.println("actualMethods = " + actualMethods);
        assertEquals(expectedMethods,actualMethods);
    }


    @Then("the user click {string} method under {string} filter")
    public void theUserClickMethodUnderFilter(String method, String filter) {
        String locator = "//div[contains(text(),'"+filter+"')]//following-sibling::div//child::a[contains(text(),'"+method.toLowerCase()+"')]";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    @And("the user click choose values button and select {string}")
    public void theUserClickChooseValuesButtonAndSelect(String option) {
        String locator = "//ul[@class='select2-results']//child::div[contains(text(),'"+option+"')]";
        vehicleFleetPage.TagsChooseValuesButton.click();
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(locator)),3).click();
    }

    @Then("the user click update under {string} filter")
    public void theUserClickUpdateUnderFilter(String filter) {
        Driver.get().findElement(By.xpath("//input[@id='"+filter+"']//following-sibling::button[@type='button']")).click();
        BrowserUtils.waitFor(5);
    }

    @Then("verify the table should include corresponding {string} under {string} column")
    public void verifyTheTableShouldIncludeCorrespondingUnderColumn(String expectedValue, String filter) {
        List<String> listOfValuesUnderFilterRow = vehicleFleetPage.getListOfAnyRow(filter);
        for (String row:listOfValuesUnderFilterRow){
            assertEquals(expectedValue,row);
        }
    }
}


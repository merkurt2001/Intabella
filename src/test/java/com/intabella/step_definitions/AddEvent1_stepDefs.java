package com.intabella.step_definitions;

import com.intabella.pages.Add_Event_2;
import com.intabella.pages.DashboardPage;
import com.intabella.pages.GeneralInfoPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEvent1_stepDefs {

    @And("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        BrowserUtils.waitFor(5);
        new DashboardPage().navigateToModule(tab, module);
    }


    @And("the user navigates to General Information page")
    public void the_user_navigates_to_General_Information_page() {
        BrowserUtils.waitFor(5);
        String actualSubtitle = new GeneralInfoPage().GeneralInfoPageSubtitle.getText();
        String expectedSubtitle = "General Information";
        Assert.assertEquals("Subtitle does not match", expectedSubtitle, actualSubtitle);

    }

    @And("the user clicks on the first row in the list")
    public void theUserClicksOnTheFirstRowInTheList() {
        BrowserUtils.waitFor(3);
        new GeneralInfoPage().TableFirstRow.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the user should be able to see Add Event button displayed on the top right corner next to Delete button")
    public void the_user_should_be_able_to_see_Add_Event_button_displayed_on_the_top_right_corner_next_to_Delete_button() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(new GeneralInfoPage().addEventBtn.isDisplayed());
    }


    @Then("the {string} should be able to see Add Event button displayed on the top right corner next to Delete button")
    public void theShouldBeAbleToSeeAddEventButtonDisplayedOnTheTopRightCornerNextToDeleteButton(String userType) {

        BrowserUtils.waitFor(5);
        if (userType.equals("sales manager") || userType.equals("store manager")) {
            Assert.assertTrue("Sales Manager and Store Manager cannot click on AddEvent Button", new GeneralInfoPage().addEventBtn.isEnabled());

        }
    }


    @Then("the {string} should not be able to see Add Event Button")
    public void theShouldNotBeAbleToSeeAddEventButton(String userType) {
        BrowserUtils.waitFor(5);
        if (userType.equals("driver")) {
            Assert.assertFalse("Driver can see the AddEvent Button", new GeneralInfoPage().addEventBtn.isDisplayed());

        }
    }

    @And("the user clicks on the Add Event button")
    public void theUserClicksOnTheAddEventButton() {
        BrowserUtils.waitFor(5);
        new GeneralInfoPage().addEventBtn.click();
    }

    @Then("Add Event page should pop up")
    public void addEventPageShouldPopUp() {
        BrowserUtils.waitFor(3);
        String actualPopUpText = new Add_Event_2().AddEventButton.getText();
        String expectedPopUpText = "Add Event";
        Assert.assertEquals(expectedPopUpText, actualPopUpText);

    }

    @Then("the compulsory fields should be displayed as follows")
    public void theCompulsoryFieldsShouldBeDisplayedAsFollows(List<String> compulsoryElements) {
        BrowserUtils.waitFor(3);
        List<String> actualCompulsoryFields = BrowserUtils.getElementsText(new DashboardPage().compulsoryElements);
        Assert.assertEquals(compulsoryElements, actualCompulsoryFields);
        System.out.println("compulsoryElements = " + compulsoryElements);
        System.out.println("actualCompulsoryFields = " + actualCompulsoryFields);
    }


    @And("the user fills in only Title* input box and leaves the rest empty")
    public void theUserFillsInOnlyTitleInputBoxAndLeavesTheRestEmpty() {
        BrowserUtils.waitFor(2);
        new DashboardPage().AddEventPopUpPage_Title_input_box.sendKeys("Mr");
    }

    @And("the user clicks on the Save button")
    public void theUserClicksOnTheSaveButton() {
        BrowserUtils.waitFor(2);
        new DashboardPage().AddEventPopUpPage_Save_button.click();


    }

    @Then("This value should not be blank message should be displayed after clicking on save button")
    public void thisValueShouldNotBeBlankMessageShouldBeDisplayedAfterClickingOnSaveButton() {
        BrowserUtils.waitFor(3);
        String actualAlertMessage = new DashboardPage().CalendarEventSavedAlertMessage.getText();
        System.out.println("actualAlertMessage = " + actualAlertMessage);
        String expectedAlertMessage = "This value should not be blank.";
        Assert.assertEquals("Expected alert message is not displayed", expectedAlertMessage, actualAlertMessage);

    }


}






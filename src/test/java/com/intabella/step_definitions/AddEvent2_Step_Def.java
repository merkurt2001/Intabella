package com.intabella.step_definitions;

import com.intabella.pages.Add_Event_2;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.cy_gb.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AddEvent2_Step_Def {
    Add_Event_2 add_event_2 = new Add_Event_2();

    @Then("the user see the Add Event button at the upper right most corner")
    public void the_user_see_the_Add_Event_button_at_the_upper_right_most_corner() {
        BrowserUtils.waitFor(4);
        new Add_Event_2().theUserSeeTheAddEventButton();

    }

    @Given("the user clicks on the Add Event button and Add Event pop up")
    public void the_user_clicks_on_the_Add_Event_button_and_Add_Event_pop_up() {
        BrowserUtils.waitFor(4);
        new Add_Event_2().clicksOnAddEventEventPopUp();
    }

    @Then("the user clicks any desired colour in the Color selection")
    public void the_user_clicks_any_desired_colour_in_the_Color_selection() {

        new Add_Event_2().colorSelection();

    }

    @Then("the user clicks the All-day event box")
    public void the_user_clicks_the_All_day_event_box() {

        new Add_Event_2().AlldayEventCheck();

    }

    @Given("the user clicks on the Repeat box")
    public void the_user_clicks_on_the_Repeat_box() {

        new Add_Event_2().RepeatBox.click();

    }

    @Then("the user clicks the Repeats dropdown menu")
    public void the_user_clicks_the_Repeats_dropdown_menu() {

        new Add_Event_2().RepeatDropDownDaily.click();
    }
    //    @Then("the user verifies if {string} Daily Weekly Monthly Yearly appears")
//    public void the_user_verifies_if_Daily_Weekly_Monthly_Yearly_appears(String DropDownMenu) {
//        Select dropDown = new Select(Driver.get().findElement(By.xpath("//*[@class='recurrence-repeats__select']")));
//
//    }
//
//    @Given("the user clicks on the EndsRadio button")
//    public void the_user_clicks_on_the_EndsRadio_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the user verifies if EndsRadioButton options such as Never After By are clickable")
//    public void the_user_verifies_if_EndsRadioButton_options_such_as_Never_After_By_are_clickable() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
    @Then("the user fills in the Description box with a brief explanation regarding the event")
    public void the_user_fills_in_the_Description_box_with_a_brief_explanation_regarding_the_event() {

        new Add_Event_2().DescriptionBox.sendKeys("Birthday party for the Mr");
    }

    @And("the user should be able to see {string} {string} {string} {string}")
    public void theUserShouldBeAbleToSee(String daily, String weekly, String monthly, String yearly) {
        WebElement dropDown = Driver.get().findElement(By.xpath("//select[starts-with(@id, 'recurrence-repeats')]"));
        List<WebElement> dropDownMenu=Driver.get().findElements(By.xpath("//select[starts-with(@id, 'recurrence-repeats')]"));
        List<String>str= new ArrayList();
        str.add(0,daily);
        str.add(1,weekly);
        str.add(2,monthly);
        str.add(3,yearly);

        /*for (int i = 0; i < dropDownMenu.size(); i++) {
            //System.out.println("dropDownMenu.get(1).getText() = " + str[i]);
            Assert.assertEquals(str.get(i),dropDownMenu.get(i).getText());
        }*/

        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }
    @And("the user should be able to click {string} radio button")
    public void theUserShouldBeAbleToClickRadioButton(String neverRadio) {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("input[checked='checked']")).isSelected());

    }

    @Then("the user should be able to see {string} {string} {string}")
    public void theUserShouldBeAbleToSee(String never, String after, String by) {
        Assert.assertEquals(never, Driver.get().findElement(By.xpath("//span[normalize-space()='Never']")).getText());
        Assert.assertEquals(after, Driver.get().findElement(By.xpath("//span[normalize-space()='After']")).getText());
        Assert.assertEquals(by, Driver.get().findElement(By.xpath("//span[normalize-space()='By']")).getText());
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @Given("the user fills the form")
    public void theUserFillsTheForm() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_title-uid-')]")).sendKeys("Happy birthday");
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_organizerDisplayName')]")).sendKeys("Beach Party");
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_organizerEmail')]")).sendKeys("gol@yahoo.com");
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//button[@type='submit']")).click();
        BrowserUtils.waitFor(2);
    }
    @Then("the user sees all events_activities in the General information page")
    public void the_user_sees_all_events_activities_in_the_General_information_page() {
        Assert.assertTrue(new Add_Event_2().CreatedEventActivity.isDisplayed());
    }

}



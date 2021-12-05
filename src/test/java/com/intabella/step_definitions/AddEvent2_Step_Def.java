package com.intabella.step_definitions;

import com.intabella.pages.Add_Event_2;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.Driver;
import io.cucumber.java.cy_gb.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddEvent2_Step_Def {
//Add_Event_2 add_event_2 = new Add_Event_2();

    @Then("the user see the Add Event button at the upper right most corner")
    public void the_user_see_the_Add_Event_button_at_the_upper_right_most_corner() {

        new Add_Event_2().theUserSeeTheAddEventButton();

    }

    @Given("the user clicks on the Add Event button and Add Event pop up")
    public void the_user_clicks_on_the_Add_Event_button_and_Add_Event_pop_up() {

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

        new Add_Event_2().RepeatBox();
    }

    @Then("the user clicks the Repeats dropdown menu")
    public void the_user_clicks_the_Repeats_dropdown_menu() {

        new Add_Event_2().RepeatDropDown();
    }

    @Then("the user checks {string}")
    public void the_user_checks(String RepeatDropDown) {

        new Add_Event_2().RepeatDropDown();
    }

    @Given("the user clicks on Ends button")
    public void the_user_clicks_on_Ends_button() {

        new Add_Event_2().EndingOption();
    }

    @Then("the user checks if {string} are clickable")
    public void the_user_checks_if_are_clickable(String string) {

        new Add_Event_2().EndingOption();
    }

    @Given("the user enters the desired event in the Title box")
    public void the_user_enters_the_desired_event_in_the_Title_box() {

        new Add_Event_2().TitleBox();
    }

    @Then("the user fills in the Description box with a brief explanation regarding the event")
    public void the_user_fills_in_the_Description_box_with_a_brief_explanation_regarding_the_event() {

        new Add_Event_2().DescriptionBox();
    }

    @Then("the user clicks on the Save icon")
    public void the_user_clicks_on_the_Save_icon() {

        new Add_Event_2().SaveButton();
    }


}

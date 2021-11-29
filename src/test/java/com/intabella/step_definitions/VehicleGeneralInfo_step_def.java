package com.intabella.step_definitions;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class VehicleGeneralInfo_step_def {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        new LoginPage().logInAsdifferntUser(userType);
    }

    @Given("the user click on the {string} tab {string} module as user {string}")
    public void the_user_click_on_the_tab_module_as_user(String tab, String module, String UserType) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule(tab,module,UserType);

    }

    @Given("the user should see the General Information by clicking on any vehicle row")
    public void the_user_should_see_the_General_Information_by_clicking_on_any_vehicle_row() {

        new GeneralInfoPage().TheUserShouldSeeGIP();
    }

    @Given("the user can see the General Information page by clicking the Eye icon")
    public void the_user_can_see_the_General_Information_page_by_clicking_the_Eye_icon() {

        new GeneralInfoPage().clickEye();
    }

    @When("the {string} clicks on any vehicle row and he lands to the General Information page he should see the Delete Edit and Add Event buttons")
    public void the_clicks_on_any_vehicle_row_and_he_lands_to_the_General_Information_page_he_should_see_the_Delete_Edit_and_Add_Event_buttons(String string) {

        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        WebElement row = Driver.get().findElement(By.xpath("//table[1]/tbody/tr[1]"));
        row.click();
        BrowserUtils.waitFor(5);

    }

    @When("the user by clicking on any vehicle row navigates to General Information page")
    public void the_user_by_clicking_on_any_vehicle_row_navigates_to_General_Information_page() {

        new GeneralInfoPage().navigateToGIP();
    }

    @Then("the user should not have any Add Event Edit Delete buttons")
    public void the_user_should_not_have_any_Add_Event_Edit_Delete_buttons() {

        new GeneralInfoPage().shouldNotHaveAddEventBtn();
    }

    @Given("information should be the same")
    public void information_should_be_the_same() {

        new GeneralInfoPage().InfoShouldBeTheSame();
    }


}
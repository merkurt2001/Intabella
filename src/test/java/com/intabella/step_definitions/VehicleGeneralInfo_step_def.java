package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.GeneralInfoPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VehicleGeneralInfo_step_def {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("salesmanager_username");
            password = ConfigurationReader.get("salesmanager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("storemanager_username");
            password = ConfigurationReader.get("storemanager_password");
        } else {
            System.out.println("Invalid user");
        }
        new LoginPage().login(username, password);
    }

    @Given("the user clicks on the {string} {string} module")
    public void the_user_clicks_on_the_module(String tab, String module) {

        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule(tab, module);
    }

    @Given("the user should see the General Information page on any vehicle")
    public void the_user_should_see_the_General_Information_page_on_any_vehicle() {

        new GeneralInfoPage().TheUserShouldSeeGIP();
    }

    @Given("the user can see the General Information page by clicking the Eye icon")
    public void the_user_can_see_the_General_Information_page_by_clicking_the_Eye_icon() {

        new GeneralInfoPage().clickEye();
    }

}
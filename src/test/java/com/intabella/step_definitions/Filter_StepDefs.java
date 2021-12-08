package com.intabella.step_definitions;

import com.intabella.pages.BasePage;
import com.intabella.pages.GeneralFiltersMenuPage;
import com.intabella.utilities.Driver;
import com.intabella.utilities.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.intabella.pages.DashboardPage;
import com.intabella.pages.GeneralInfoPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Filter_StepDefs {

    //Pages pages = new Pages();

    @Then("Manage Filter button is hidden by default")
    public void manage_Filter_button_is_hidden_by_default() {

        //new DashboardPage().navigateToModule("Fleet", "Vehicles");
        //new GeneralFiltersMenuPage().ManageFilterButtonIsHiddenByDefault();

        new DashboardPage().navigateToModule("Fleet", "Vehicles");
        WebElement filter = Driver.get().findElement(By.cssSelector("a[title=Filters]"));
        //String actualText = filter.getAttribute("class");
       // String expected = "action btn mode-icon-only";

        BrowserUtils.waitFor(3);
        Assert.assertTrue(filter.isDisplayed());


    }


    @When("the user clicks on the Filters button")
    public void the_user_clicks_on_the_Filters_button() {
        //userClicksOnFilterButton();
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Fleet", "Vehicles");
        Driver.get().findElement(By.cssSelector("a[title=Filters]")).click();
    }

    @Then("Manage Filter button should be visible")
    public void button_should_be_visible() {
        //String actual = Driver.get().findElement(By.cssSelector("a.add-filter-button")).getText();
        //WebElement filter = Driver.get().findElement(By.cssSelector("a[title=Filters]"));
        //System.out.println("filter.getAttribute(\"class\") = " + filter.getAttribute("class"));
        String actualText = Driver.get().findElement(By.cssSelector("a[title=Filters]")).getAttribute("class");
        System.out.println("actualText = " + actualText);
        Assert.assertEquals("action btn mode-icon-only pressed", actualText);
    }

    @When("the user clicks on Manage filters dropdown menu")
    public void the_user_clicks_on_Manage_filters_dropdown_menu() {
        //theUserClicksOnManageFiltersDropdownMenu();
        Driver.get().findElement(By.cssSelector("a.add-filter-button")).click();
    }

    @Then("the user can select the {string} under manage filters dropdown")
    public void the_user_can_select_the_filterName_under_manage_filters(String filterName) {

        BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@title='" + filterName + "']")), true);
        BrowserUtils.waitFor(3);

        //theUserCanSelectTheFilterNameUnderManageFilters("Driver");
    }

    @Then("the user can apply filters for {string} user")
    public void the_user_can_apply_filters_for(String filterName) {

        Assert.assertTrue("not selected",Driver.get().findElement(By.xpath("//input[@title='" + filterName + "']")).isSelected());
        //theUserCanApplyFiltersForFilterName("Driver");
    }


    @Then("User can find a filter by typing the filter name {string}")
    public void user_can_find_filter_by_typing_the_filter_name(String filterName) {

        Driver.get().findElement(By.cssSelector("input[type = 'search']")).sendKeys(filterName);
        //Assert.assertTrue("not selected",Driver.get().findElement(By.xpath("//input[@value='" + filterName + "']")).isSelected());
        BrowserUtils.waitFor(3);
        WebElement act =Driver.get().findElement(By.xpath("//label[@title='"+filterName+"']"));
        //String actual= act.getAttribute("class");
        //String expected = "ui-corner-all ui-state-hover";

        //System.out.println("actual = " + actual);
        //Assert.assertEquals(expected, actual);
        Assert.assertTrue(act.isDisplayed());
    }



    @Then("the user can remove all filters")
    public void the_user_can_remove_all_filters_by_clicking_on_the_reset_icon() {
        Driver.get().findElement(By.cssSelector("a[title='Reset']")).click();
        
        
        //Assert.assertFalse("selected",Driver.get().findElement(By.xpath("//input[@title='" + filterName + "']")).isSelected());
    }

    @And("the user clicks on several filter name from Manage filters menu")
    public void the_user_clicks_on_several_filter_name_from_manage_filters_menu() {

        BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@title='Driver']")), true);
        BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@title='Tags']")), true);
        BrowserUtils.waitFor(2);
        WebElement modelYear= Driver.get().findElement(By.xpath("//input[@title='Model Year']"));
        BrowserUtils.clickWithJS(modelYear);
        //BrowserUtils.selectCheckBox(Driver.get().findElement(By.xpath("//input[@value='Model Year']")), true);



    }

    @Then("the user can apply filters")
    public void the_user_can_apply_filters() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue("not selected",Driver.get().findElement(By.xpath("//input[@title='Driver']")).isSelected());
        Assert.assertTrue("not selected",Driver.get().findElement(By.xpath("//input[@title='Tags']")).isSelected());
        Assert.assertTrue("not selected",Driver.get().findElement(By.xpath("//input[@title='Model Year']")).isSelected());
    }

    @Then("user clicks on reset icon")
    public void userClicksOnResetIcon() {
    }

    @And("user click on the {string} tab {string} module")
    public void userClickOnTheTabModule(String arg0, String arg1) {
    }
}

package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralFiltersMenuPage {

    @FindBy (css = "a[title=Filters]")
    public WebElement btn_Filter;

    @FindBy (css = "a.add-filter-button")
    public WebElement bnt_ManageFilters;

    @FindBy(xpath = "//input[@value='\" + filterName + \"']")
    public WebElement chb_filterOptions;

    @FindBy(css = "input[type = 'search']")
    public WebElement inputBox_manageFilters;

    @FindBy(css = "a[title='Reset']")
    public WebElement icon_reset;


    public void ManageFilterButtonIsHiddenByDefault(){

        BrowserUtils.waitFor(3);
        String expectedText = "action btn mode-icon-only";

        System.out.println("btn_Filter.getAttribute(\"class\") = " + btn_Filter.getAttribute("class"));

        Assert.assertEquals(expectedText, btn_Filter.getAttribute("class") );

    }

    public void userClicksOnFilterButton(){
        btn_Filter.click();
    }

    public void theUserClicksOnManageFiltersDropdownMenu(){
        bnt_ManageFilters.click();
    }

    public void theUserCanSelectTheFilterNameUnderManageFilters(String filterName) {

        BrowserUtils.selectCheckBox(chb_filterOptions, true);
        BrowserUtils.waitFor(3);
    }

    public void theUserCanApplyFiltersForFilterName(String filterName){

        BrowserUtils.waitFor(2);
        Assert.assertTrue("not selected",chb_filterOptions.isSelected());

    }

    public void userCanApplyFiltersByTypingTheFilterName(String filterName){
        inputBox_manageFilters.sendKeys(filterName);
        Assert.assertTrue(chb_filterOptions.isSelected());

    }

    public void theUserCanRemoveAllFiltersByClickingOnTheResetIcon() {
        icon_reset.click();
    }

    public void theUserClicksOnSeveralFilterNameFromManageFiltersMenu() {}

    public void theUserCanApplyFilters() {
    }

    public void userClicksOnResetIcon() {
    }

}

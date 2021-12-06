package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class Vehicle_Fleet_Page extends BasePage {
    /*
    gecici
     *///''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    @FindBy(xpath = "//span[@class='title title-level-1'][normalize-space()='Fleet']")
    public WebElement tabLocator;
    @FindBy(xpath = "//span[normalize-space()='Vehicles']")
    public WebElement moduleLocator;

    @FindBy(xpath = "//label[normalize-space()='of 5 |']")
    public WebElement numberOfPage;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement rightClick;


    @FindBy(xpath = "//i[@class='fa-chevron-left hide-text']")
    public WebElement leftClick;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement isOne;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[4]/label[3]")
    public WebElement totalRecord;


    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")
    public WebElement exportGrid;

    @FindBy(xpath = "//a[@title='CSV']")
    public WebElement csvFormat;

    @FindBy(xpath = "//a[@title='XLSX']")
    public WebElement xlsxFormat;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement exportConfirmationMessage;


    @FindBy(css = "a[title='Filters']")
    public WebElement filtersButton;

    @FindBy(linkText = "Manage filters")
    public WebElement manageFiltersDropdown;

    @FindBy(css = ".select2-choices")
    public WebElement TagsChooseValuesButton;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']")
    public WebElement table;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//th")
    public List<WebElement> tableRows;

    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeletebutton;

    public int getIndexNumberRow(String row) {
        List<String> rowNames = BrowserUtils.getElementsText(tableRows);
        return rowNames.indexOf(row.toUpperCase());
    }

    public List<String> getListOfAnyRow(String row){
        int indexNumber = getIndexNumberRow(row);
        String locator = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr/td["+(indexNumber+1)+"]";
        return BrowserUtils.getElementsText(Driver.get().findElements(By.xpath(locator)));
    }

  }


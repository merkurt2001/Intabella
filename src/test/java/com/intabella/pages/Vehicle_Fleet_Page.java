package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Vehicle_Fleet_Page extends BasePage {
    /*
    gecici
     *///''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    @FindBy(xpath ="//span[@class='title title-level-1'][normalize-space()='Fleet']")
    public WebElement tabLocator;
    @FindBy(xpath ="//span[normalize-space()='Vehicles']")
    public WebElement moduleLocator;

    @FindBy(xpath = "//label[normalize-space()='of 5 |']")
    public WebElement numberOfPage;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement rightClick;



    @FindBy(xpath = "//i[@class='fa-chevron-left hide-text']" )
    public  WebElement leftClick;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement isOne;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[4]/label[3]")
    public WebElement totalRecord;


    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")
    public WebElement exportGrid;

    @FindBy(xpath ="//a[@title='CSV']")
    public WebElement csvFormat;

    @FindBy(xpath ="//a[@title='XLSX']")
    public WebElement xlsxFormat;

    @FindBy(xpath ="//div[@class='message']")
    public WebElement exportConfirmationMessage;


}

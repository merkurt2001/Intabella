package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Add_Event_2 extends BasePage {


    @FindBy(xpath = "//span[@class='color']")
    public WebElement colorSelection;


    @FindBy(xpath = "//i[@class='fa-clock-o hide-text']")
    public WebElement AddEventButton;

    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    public WebElement AddEventTitle;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement AlldayEvent;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement RepeatBox;

    @FindBy(xpath = "//*[@*='recurrence-repeats__select']")
    public WebElement RepeatDropDownDaily;

    // @FindBy (xpath = "(//*[@*='control-section-switcher'])[3]")
    //public WebElement EndsRadioBtnNever;


    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement EndsRadioBtnNever;

    @FindBy(xpath = "(//*[@*='oro_calendar_event_form_title-uid-61ace574eb9ba'])[2]")
    public WebElement TitleBox;

    @FindBy(xpath = "//input[@data-ftid='oro_calendar_event_form_title']")
    public WebElement TitleBoxFilled;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement DescriptionBox;

    @FindBy(xpath = "//*[@*='btn btn-primary']")
    public WebElement SaveButton;

    @FindBy (xpath = "//div[@class='details']")
    public WebElement CreatedEventActivity;


    public void theUserSeeTheAddEventButton() {

        BrowserUtils.waitFor(5);
        Assert.assertEquals("Add Event", AddEventButton.getText());
    }

    public void clicksOnAddEventEventPopUp() {
        BrowserUtils.waitFor(3);
        AddEventButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertEquals("Add Event", AddEventTitle.getText());

    }

    public void colorSelection() {
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        List<WebElement> colors = Driver.get().findElements(By.xpath("//span[@class='color']"));
        for (int i = 1; i < colors.size(); i++) {
            WebElement color = Driver.get().findElement(By.xpath("//span[@class='color'][" + i + "]"));
            color.click();
            BrowserUtils.waitFor(2);
            Assert.assertTrue(colorSelection.isEnabled());
        }
    }

    public void AlldayEventCheck() {
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        AlldayEvent.click();
        Assert.assertTrue("should be selected", AlldayEvent.isSelected());
    }


    public void RepeatBox() {
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        BrowserUtils.waitFor(3);
        RepeatBox.click();
        Assert.assertTrue("should be selected", RepeatBox.isSelected());
    }

//    public void RepeatDropDown(String RepeatDropDownDaily){
//        //Driver.get().findElement(By.xpath("(//div[@class='selector input-widget-select'])[1]")).click();
//        BrowserUtils.waitFor(3);
//       // RepeatBox.click();
//        BrowserUtils.waitFor(3);
//        Select dropDown = new Select(Driver.get().findElement(By.xpath("//*[@class='recurrence-repeats__select']")));
//
//        for (int i = 0; i < dropDown.getOptions().size(); i++) {
//
//
//
//
//        }
//
//
//
////        BrowserUtils.waitFor(7);
//    }
//
//    public void EndsRadioBtnNever(){
//        AddEventButton.click();
//        RepeatBox.click();
//        EndsRadioBtnNever.click();
//        Assert.assertTrue("Ending option is clickable", EndsRadioBtnNever.isEnabled());
//        //Assert.assertTrue("Repeat ending option should be displayed", EndsRadioBtnNever.isDisplayed());
//    }
//
//    public void TitleBox(){
//        AddEventButton.click();
//        BrowserUtils.waitFor(3);
//        Assert.assertTrue("User can enter the desired event in the Title box", TitleBox.isEnabled());
//    }
//
//    public void DescriptionBox(){
//        AddEventButton.click();
//        Assert.assertTrue("User fills in the Description box with a brief explanation regarding the event",
//                DescriptionBox.isEnabled());
//    }
//
//    public void SaveButton(){
//        AddEventButton.click();
//        Assert.assertTrue("Save button is clickable", SaveButton.isEnabled());
//        SaveButton.click();
//    }

}
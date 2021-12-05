package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Add_Event_2 extends BasePage {


    @FindBy(xpath = "//span[@class='color']")
    public WebElement colorSelection;


    @FindBy(xpath = "//i[@class='fa-clock-o hide-text']")
    public WebElement AddEventButton;

    @FindBy(id = "ui-id-2")
    public WebElement AddEventTitle;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement AlldayEvent;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement RepeatBox;

    @FindBy(xpath = "//*[@*='recurrence-repeats__select']")
    public WebElement RepeatDropDown;

    @FindBy (xpath = "(//*[@*='control-section-switcher'])[3]")
    public WebElement EndingOption;

    @FindBy (xpath = "(//*[@*='oro_calendar_event_form_title-uid-61ace574eb9ba'])[2]")
    public WebElement TitleBox;

    //@FindBy (xpath = "//input[@data-ftid='oro_calendar_event_form_title']")
    //public WebElement TitleBoxFilled;

    @FindBy (xpath = "//label[@*='oro_calendar_event_form_description-uid-61acf49ece961']")
    public WebElement DescriptionBox;

    @FindBy (xpath = "//*[@*='btn btn-primary']")
    public WebElement SaveButton;


    public void theUserSeeTheAddEventButton(){

        BrowserUtils.waitFor(5);
        Assert.assertEquals("Add Event",AddEventButton.getText());
    }

    public void clicksOnAddEventEventPopUp(){
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        Assert.assertEquals("Add Event",AddEventTitle.getText());

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
    public void AlldayEventCheck(){
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        AlldayEvent.click();
        Assert.assertTrue("should be selected",AlldayEvent.isSelected());
    }

    public void RepeatBox(){
        BrowserUtils.waitFor(5);
        AddEventButton.click();
        RepeatBox.click();
        Assert.assertTrue("should be selected", RepeatBox.isSelected());
    }
    public void RepeatDropDown(){
        AddEventButton.click();
        RepeatBox.click();
        RepeatDropDown.click();
        Assert.assertTrue("Repeat dropdown should be displayed", RepeatDropDown.isDisplayed());

    }

    public void EndingOption(){
        AddEventButton.click();
        RepeatBox.click();
        EndingOption.click();
        Assert.assertTrue("Ending option is clickable", EndingOption.isEnabled());
        Assert.assertTrue("Repeat ending option should be displayed", EndingOption.isDisplayed());
    }

    public void TitleBox(){
        AddEventButton.click();
        Assert.assertTrue("User can enter the desired event in the Title box", TitleBox.isEnabled());
    }

    public void DescriptionBox(){
        AddEventButton.click();
        Assert.assertTrue("User fills in the Description box with a brief explanation regarding the event",
                DescriptionBox.isEnabled());
    }

    public void SaveButton(){
        AddEventButton.click();
        Assert.assertTrue("Save button is clickable", SaveButton.isEnabled());
        SaveButton.click();
    }

}

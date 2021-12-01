package com.intabella.pages;

import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Add_Event_2 extends BasePage {

    @FindBy(xpath = "//i[@class='fa-clock-o hide-text']")
    public WebElement AddEventButton;

    @FindBy(id = "ui-id-2")
    public WebElement AddEventTitle;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement AlldayEvent;

    @FindBy(xpath = "//*[@recurrence-repeat='recurrence-repeat']")
    public WebElement RepeatBox;

    @FindBy(xpath = "//*[@*='recurrence-repeats__select']")
    public WebElement RepeatDropDown;




   public void theUserSeeTheAddEventButton(){
       Assert.assertEquals("Add Event",AddEventButton.getText());
   }

   public void clicksOnAddEventEventPopUp(){
       AddEventButton.click();
     Assert.assertEquals("Add Event",AddEventTitle.getText());

   }

   public void colorSelection() {
       AddEventButton.click();
       List<WebElement> colors = Driver.get().findElements(By.xpath("//span[@class='color']"));
       for (int i = 0; i < colors.size(); i++) {
           WebElement color = Driver.get().findElement(By.xpath("//span[@class='color'][" + i + "]"));
           color.click();
           Assert.assertTrue(color.isSelected());
       }
   }
   public void AlldayEventCheck(){
       AddEventButton.click();
       AlldayEvent.click();
       Assert.assertTrue("should be clickable",AlldayEvent.isSelected());
   }

   public void RepeatBox(){
       AddEventButton.click();
       RepeatBox.click();
       Assert.assertTrue("should be clickable", RepeatBox.isSelected());
   }
   public void RepeatDropDown(){
       AddEventButton.click();
       RepeatDropDown.click();
       Assert.assertTrue("Drop down should be displayed", RepeatDropDown.isSelected());
   }
}



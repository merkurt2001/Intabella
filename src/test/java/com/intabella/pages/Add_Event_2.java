package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
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

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement RepeatBox;

   public void theUserSeeTheAddEventButton(){

       BrowserUtils.waitFor(5);
       Assert.assertEquals("Add Event",AddEventButton.getText());
   }

   public void clicksOnAddEventEventPopUp(){
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
           Assert.assertTrue(color.isEnabled());
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
}



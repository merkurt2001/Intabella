package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class GeneralInfoPage extends BasePage{

    public void TheUserShouldSeeGIP(){
        BrowserUtils.waitFor(10);

        List<WebElement> row = Driver.get().findElements(By.xpath("//table[1]/tbody/tr"));
        for (int i = 1; i < row.size(); i++) {
            WebElement row1 = Driver.get().findElement(By.xpath("//table[1]/tbody/tr[" + i + "]"));
            row1.click();
            BrowserUtils.waitFor(5);
            WebElement element = Driver.get().findElement(By.xpath("//*[@class='user-fieldset']"));
            String actualPage = element.getText();
            String expectedPage = "General Information";
            Assert.assertEquals(expectedPage,actualPage);
            Driver.get().navigate().back();
            BrowserUtils.waitFor(3);
        }
        new LoginPage().logOutUser();
    }
}

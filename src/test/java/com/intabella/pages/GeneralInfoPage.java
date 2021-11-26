package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class GeneralInfoPage extends BasePage{

    public void TheUserShouldSeeGIP(){

        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

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

    public void clickEye(){

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        List<WebElement> cell = Driver.get().findElements(By.xpath("//table[1]/tbody/tr"));

        for (int i = 1; i < cell.size(); i++) {

            WebElement dots = Driver.get().findElement(By.xpath("//table[1]/tbody/tr["+i+"]/td[20]"));
            BrowserUtils.doubleClick(dots);
            dashboardPage.waitUntilLoaderScreenDisappear();
            WebElement eye = Driver.get().findElement(By.xpath("//*[@class='fa-eye hide-text']"));
            eye.click();
            dashboardPage.waitUntilLoaderScreenDisappear();
            BrowserUtils.waitFor(3);
            WebElement gi = Driver.get().findElement(By.xpath("//i[@class='fa-clock-o hide-text']"));
            String actualPage = gi.getText();
            String expectedPage = "General Information";
            Assert.assertEquals(expectedPage,actualPage);
            Driver.get().navigate().back();
            BrowserUtils.waitFor(3);
        }
    }

    public void navigateToGIP(){
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

        WebElement row = Driver.get().findElement(By.xpath("//table[1]/tbody/tr[1]"));
        row.click();
    }

    public void shouldNotHaveAddEventBtn(){
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        WebElement addEventBtn = Driver.get().findElement(By.xpath("//i[@class='fa-clock-o hide-text']"));
        String expectedTxt = "Add Event";
        Assert.assertEquals(expectedTxt,addEventBtn.getText());
    }
}

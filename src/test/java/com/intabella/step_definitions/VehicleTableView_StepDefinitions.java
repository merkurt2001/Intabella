package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.Vehicle_Fleet_Page;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VehicleTableView_StepDefinitions {
    Vehicle_Fleet_Page fleetPage= new Vehicle_Fleet_Page();

    @Given("the user can see the vehicle information page")
    public void theUserCanSeeTheVehicleInformationPage() {
        Assert.assertEquals("Cars",fleetPage.pageSubTitle.getText());
    }

    @Given("the user can see the total number of pages")
    public void theUserCanSeeTheTotalNumberOfPages() {
        Assert.assertEquals("Of 5 |",fleetPage.numberOfPage.getText());
    }

    @Given("that users can navigate back and forth")
    public void thatUsersCanNavigateBackAndForth() {
        fleetPage.rightClick.click();
        BrowserUtils.waitFor(3);
        WebElement isTwo=Driver.get().findElement(By.xpath("//input[@value='2']"));
        Assert.assertEquals(isTwo.getAttribute("value"),"2");
        fleetPage.leftClick.click();
        BrowserUtils.waitFor(3);
        WebElement isOne=Driver.get().findElement(By.xpath("//input[@value='1']"));
        Assert.assertEquals(isOne.getAttribute("value"),"1");
        BrowserUtils.waitFor(3);
    }

    @Given("that Users can see total recordings of vehicles")
    public void thatUsersCanSeeTotalRecordingsOfVehicles() {
//        String totalRecord=fleetPage.totalRecord.getText();
//        boolean a= totalRecord.contains("Total of");
//        Assert.assertTrue("true",a);
        String totalRecord=fleetPage.totalRecord.getAttribute("innerHTML");
        Assert.assertTrue(totalRecord.contains("Total"));

    }


    @Given("that users can download table data in XLS or CSV format")
    public void thatUsersCanDownloadTableDataInXLSOrCSVFormat() {
        fleetPage.exportGrid.click();
        fleetPage.csvFormat.click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(fleetPage.exportConfirmationMessage.isDisplayed());
        BrowserUtils.waitFor(10);
        fleetPage.exportGrid.click();
        fleetPage.xlsxFormat.click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(fleetPage.exportConfirmationMessage.isDisplayed());
    }

    @And("the user clicks on the Fleet tab Vehicles module")
    public void theUserClickOnTheFleetTabVehiclesModule() {
        new Actions(Driver.get()).moveToElement(fleetPage.tabLocator).pause(200).click(fleetPage.moduleLocator).perform();
        BrowserUtils.waitFor(10);
    }
}

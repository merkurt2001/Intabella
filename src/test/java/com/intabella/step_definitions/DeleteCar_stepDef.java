package com.intabella.step_definitions;


import com.intabella.pages.GeneralInfoPage;
import com.intabella.pages.Vehicle_Fleet_Page;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DeleteCar_stepDef {

    Vehicle_Fleet_Page vehicle_fleet_page = new Vehicle_Fleet_Page();
    GeneralInfoPage generalInfoPage=new GeneralInfoPage();
    public String licencetext;

    @Then("the {string} should see delete button by hovering over end of the page")
    public void theShouldSeeDeleteButtonByHoveringOverEndOfThePage(String userType) {
        if (userType.contains("sales manager") || userType.contains("store manager")) {

            BrowserUtils.waitFor(3);
            WebElement threeDots = Driver.get().findElement(By.xpath("//table/tbody/tr[1]/td[21]"));
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(threeDots).perform();
            BrowserUtils.waitFor(3);
            WebElement deleteButton = Driver.get().findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));
            BrowserUtils.waitFor(3);
            boolean deleteButnDisplayed = deleteButton.isDisplayed();
            Assert.assertTrue(deleteButnDisplayed);
        }else {
            BrowserUtils.waitFor(3);
            WebElement threeDots = Driver.get().findElement(By.xpath("//table/tbody/tr[1]/td[20]"));
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(threeDots).perform();
            BrowserUtils.waitFor(3);
            WebElement deleteButton = Driver.get().findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));
            boolean deleteButnDisplayed = deleteButton.isDisplayed();
            Assert.assertTrue(deleteButnDisplayed);
        }

    }

    @When("the driver clicks on the delete button")
    public void theDriverClicksOnTheDeleteButton() {

        BrowserUtils.waitFor(3);
        WebElement threeDots = Driver.get().findElement(By.xpath("//table/tbody/tr[1]/td[20]"));
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(threeDots).perform();
        BrowserUtils.waitFor(3);
        WebElement deleteButton = Driver.get().
                findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//i[@class='fa-trash-o hide-text']"));
       deleteButton.click();

    }
    @When("the manager clicks on the delete button")
    public void theManagerClicksOnTheDeleteButton() {

        BrowserUtils.waitFor(3);
        WebElement threeDots = Driver.get().findElement(By.xpath("//table/tbody/tr[1]/td[21]"));
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(threeDots).perform();
        BrowserUtils.waitFor(3);
        WebElement deleteButton = Driver.get().
                findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//i[@class='fa-trash-o hide-text']"));
        deleteButton.click();

    }

    @Then("the user should see {string} pop up")
    public void the_user_should_see_pop_up(String popUp) {
        String actualpopUp = Driver.get().findElement(By.cssSelector("div[class='modal-header'] h3")).getText();
        System.out.println(actualpopUp);
        Assert.assertEquals(popUp, actualpopUp);
    }

    @And("the user click {string} button.")
    public void the_user_click_button(String yesButton) {

        vehicle_fleet_page.yesDeletebutton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) {
        String actualMessage = Driver.get().findElement(By.xpath("//div[@class='message']")).getText();
        System.out.println("Actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, message);
    }


    @Then("the user should see  {string} message")
    public void theUserShouldSeeMessage(String message) {

        String actualMessage = Driver.get().findElement(By.xpath("//div[@class='message']")).getText();
        System.out.println("Actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, message);

    }


    @When("the user click row and click the delete button")
    public void theUserClickRowAndClickTheDeleteButton() {
        WebElement row1 = Driver.get().findElement(By.xpath("//table/tbody/tr[1]"));
        row1.click();
        BrowserUtils.waitFor(5);
        generalInfoPage.deleteBtn.click();
        generalInfoPage.yesDeletebutton.click();
        BrowserUtils.waitFor(3);




    }

    @Then("the {string} message should be displayed.")
    public void theMessageShouldBeDisplayed(String message) {
        String actualMessage = Driver.get().findElement(By.xpath("//div[@class='message']")).getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage, message);

    }

    @And("the user chooses the row")
    public void theUserChoosesTheRow() {
        WebElement licencePlate = Driver.get().findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)"));
        licencetext = licencePlate.getText();
        BrowserUtils.waitFor(5);
    }

    @Then("Deleted item should not be in vehicles page")
    public void deletedItemShouldNotBeInVehiclesPage() {

        BrowserUtils.waitFor(3);
        String actualtitle=Driver.get().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)")).getText();
        Assert.assertNotEquals("The item is seen in page",licencetext,actualtitle);
    }


}

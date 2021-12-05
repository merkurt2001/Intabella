package com.intabella.step_definitions;


import com.intabella.pages.Vehicle_Fleet_Page;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;



public class DeleteCar_stepDef {

    Vehicle_Fleet_Page vehicle_fleet_page = new Vehicle_Fleet_Page();

    @Then("the user should see delete button by hovering over end of the page")
    public void the_user_should_see_delete_button_by_hovering_over_end_of_the_page() {

        vehicle_fleet_page.hoverDots();
        BrowserUtils.verifyElementDisplayed(vehicle_fleet_page.deleteSembol);

    }

    @When("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {

        vehicle_fleet_page.deleteSembol.click();
        BrowserUtils.waitFor(2);

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

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
        String actualMessage = alert.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage, message);

    }
}

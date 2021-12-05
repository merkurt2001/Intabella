package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
;

import java.util.List;

public class DeleteCar_stepDef {
    @Then("the user should see delete button by hovering over end of the page")
    public void the_user_should_see_delete_button_by_hovering_over_end_of_the_page() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        List<WebElement> cell = Driver.get().findElements(By.xpath("//table[1]/tbody/tr"));

        for (int i = 1; i < cell.size(); i++) {

            WebElement threeDots = Driver.get().findElement(By.xpath("//table[1]/tbody/tr[" + i + "]/td[20]"));
            BrowserUtils.hover(threeDots);
            BrowserUtils.waitFor(3);
            WebElement deleteButton = Driver.get().findElement(By.xpath("//*[@class='fa-trash-o hide-text']"));

        }
    }

    @When("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        WebElement threeDots = Driver.get().findElement(By.xpath("//table[1]/tbody/tr[3]/td[20]"));
        BrowserUtils.hover(threeDots);
        BrowserUtils.waitFor(3);
        WebElement deleteButton = Driver.get().findElement(By.xpath("//*[@class='fa-trash-o hide-text']"));
        deleteButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user should see {string} pop up")
    public void the_user_should_see_pop_up(String popUp) {
        String actualpopUp=Driver.get().findElement(By.cssSelector("div[class='modal-header'] h3")).getText();
        System.out.println(actualpopUp);
        Assert.assertEquals(popUp,actualpopUp);


    }

    @And("the user click {string} button.")
    public void the_user_click_button(String yesButton) {

        WebElement yesDelete = Driver.get().findElement(By.cssSelector(".btn.ok.btn-danger"));
        yesDelete.click();
        BrowserUtils.waitFor(2);


    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) {
        String actualMessage = Driver.get().findElement(By.xpath("//div[@class='message']")).getText();
        System.out.println("Actual message: "+ actualMessage);
        Assert.assertEquals(actualMessage,message);

    }





    @Then("the user should see  {string} message")
    public void theUserShouldSeeMessage(String message) {

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
        String actualMessage=alert.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,message);

    }
}

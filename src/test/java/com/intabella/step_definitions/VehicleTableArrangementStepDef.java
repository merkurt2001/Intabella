package com.intabella.step_definitions;

import com.intabella.pages.VehicleTableArrangementPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import com.intabella.utilities.Pages;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VehicleTableArrangementStepDef {
   Pages pages=new Pages();

    @Given("User click to View per page button")
    public void user_click_to_View_per_page_button() {

        pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.click();
    }

    @Given("user verify if the value of View per page is {int}")
    public void user_verify_if_the_value_of_View_per_page_is(Integer int1) {
        Assert.assertEquals("25",pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.getText());
    }

    @Given("User select each of the options")
    public void user_select_each_of_the_options() {
    List<String> expectednumbers= new ArrayList<>();
    expectednumbers.add("10");
    expectednumbers.add("25");
    expectednumbers.add("50");
    expectednumbers.add("100");

        for (int i = 1; i <= pages.vehicleTableArrangementPage().vehicleViewPerPageDropdown.size(); i++) {
             WebElement element = Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])["+i+"]"));

             element.click();
            pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.click();
             Assert.assertEquals(expectednumbers.get(i-1),pages.vehicleTableArrangementPage().vehicleViewPerPageDefault.getText());

        }

    }

    @Given("user should click on the model year module")
    public void user_should_click_on_the_model_year_module() {
        BrowserUtils.waitFor(3);
       pages.vehicleTableArrangementPage().ModelYearClick.click();
       BrowserUtils.waitFor(3);

    }

    @Given("user verify if the model year  colum is on decending")
    public void user_verify_if_the_model_year_colum_is_on_decending() {
        List<String> Modelyear= new ArrayList<>();
       List<WebElement> size= Driver.get().findElements(By.xpath("//table/tbody/tr"));

       for (int i = 0; i < size.size(); i++) {
           WebElement RowCellSixInfo=Driver.get().findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[6]"));
            Modelyear.add(RowCellSixInfo.getText());
        }
        boolean match=true;
        for (int i = 0; i < size.size()-1; i++) {
           //'' System.out.println(Modelyear.get(i));
        if (Integer.parseInt(Modelyear.get(i))>Integer.parseInt(Modelyear.get(i+1))){
            match=false;
            break;
        }}

            Assert.assertTrue(match);
        }


    @Given("user should click the reset button")
    public void user_should_click_the_reset_button() {
        pages.vehicleTableArrangementPage().RefreshButton.click();
    }
    @Given("user choose the {int} options from the View per page dropdown")
    public void user_choose_the_options_from_the_View_per_page_dropdown(Integer int1) {
       Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).click();
    }
}

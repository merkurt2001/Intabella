package com.intabella.pages;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.newCarInfoReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;
//import com.intabella.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class CreateCarPage {
    public CreateCarPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    /*
     @FindBy(id="prependedInput")
    public WebElement userName;
    * */

    public void shouldBeFilledFromExcel () {
        //ExcelUtil crtCar = new ExcelUtil("src/test/resources/createCar.xls", "crt");
        //List<Map<String, String>> dataList = crtCar.getDataList();
        for (int i = 0; i < 1; i++) {
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LicensePlate]']")).sendKeys(newCarInfoReader.get("licence_plate"));
            int count = Driver.get().findElements(By.xpath("//div[@data-ftid='custom_entity_type_Tags']/div")).size();
            for(int c=1; c <= count; c++){
                Driver.get().findElement(By.xpath("(//div[@data-ftid='custom_entity_type_Tags']/div)["+c+"]/input")).click();
            }
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Driver]']")).sendKeys(newCarInfoReader.get("driver_name"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Location]']")).sendKeys(newCarInfoReader.get("location"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ChassisNumber]']")).sendKeys(newCarInfoReader.get("chassis_number").replace(".0",""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ModelYear]']")).sendKeys(newCarInfoReader.get("model_year"));
            System.out.println("Last otomater");
            String lastOdometer =  newCarInfoReader.get("last_odometer").replace(".0","");
            System.out.print(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LastOdometer]']")).sendKeys(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CatalogValue]']")).sendKeys( newCarInfoReader.get("catalog_value"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[SeatsNumber]']")).sendKeys( newCarInfoReader.get("seats_number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[DoorsNumber]']")).sendKeys( newCarInfoReader.get("doors_number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Color]']")).sendKeys( newCarInfoReader.get("color"));

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Automatic']")).click();

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Hybrid']")).click();

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CO2Emissions]']")).sendKeys( newCarInfoReader.get("co2_emissions"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Horsepower]']")).sendKeys( newCarInfoReader.get("horsepower").replace(".0",""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[HorsepowerTaxation]']")).sendKeys( newCarInfoReader.get("horsepower_taxation"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Power]']")).sendKeys( newCarInfoReader.get("power").replace(".0",""));
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")).sendKeys( newCarInfoReader.get("immatriculation_date"));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_FirstContractDate')]")).sendKeys( newCarInfoReader.get("first_contract_date"));
            File file = new File("src/test/resources/volvo.png");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Logo][file]']")).sendKeys(file.getAbsolutePath());
            JavascriptExecutor js = (JavascriptExecutor) Driver.get();
            js.executeScript("document.getElementsByClassName('btn btn-success action-button')[0].click()");
            new DashboardPage().waitUntilLoaderScreenDisappear();
        }
    }

}

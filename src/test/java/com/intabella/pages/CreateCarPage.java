package com.intabella.pages;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
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
import com.intabella.utilities.ExcelUtil;

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
        ExcelUtil crtCar = new ExcelUtil("src/test/resources/createCar.xls", "crt");
        List<Map<String, String>> dataList = crtCar.getDataList();
        for (int i = 0; i < 1; i++) {
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LicensePlate]']")).sendKeys(dataList.get(i).get("License Plate"));
            int count = Driver.get().findElements(By.xpath("//div[@data-ftid='custom_entity_type_Tags']/div")).size();
            for (int c = 1; c <= count; c++) {
                Driver.get().findElement(By.xpath("(//div[@data-ftid='custom_entity_type_Tags']/div)[" + c + "]/input")).click();
            }
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Driver]']")).sendKeys(dataList.get(i).get("driver"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Location]']")).sendKeys(dataList.get(i).get("Location"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ChassisNumber]']")).sendKeys(dataList.get(i).get("Chassis number").replace(".0", ""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ModelYear]']")).sendKeys(dataList.get(i).get("Model year"));
            System.out.println("Last otomater");
            String lastOdometer = dataList.get(i).get("Last Odometer").replace(".0", "");
            System.out.print(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LastOdometer]']")).sendKeys(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CatalogValue]']")).sendKeys(dataList.get(i).get("Catalog Value"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[SeatsNumber]']")).sendKeys(dataList.get(i).get("Seats Number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[DoorsNumber]']")).sendKeys(dataList.get(i).get("Doors Number"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Color]']")).sendKeys(dataList.get(i).get("Color"));

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Automatic']")).click();

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Hybrid']")).click();

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CO2Emissions]']")).sendKeys(dataList.get(i).get("CO2 Emissions"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Horsepower]']")).sendKeys(dataList.get(i).get("Horsepower").replace(".0", ""));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[HorsepowerTaxation]']")).sendKeys(dataList.get(i).get("Horsepower Taxation"));
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Power]']")).sendKeys(dataList.get(i).get("Power").replace(".0", ""));
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")).sendKeys(dataList.get(i).get("Immatriculation Date"));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_FirstContractDate')]")).sendKeys(dataList.get(i).get("First Contract Date"));
            File file = new File("src/test/resources/volvo.png");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Logo][file]']")).sendKeys(file.getAbsolutePath());
            JavascriptExecutor js = (JavascriptExecutor) Driver.get();
            js.executeScript("document.getElementsByClassName('btn btn-success action-button')[0].click()");
            new DashboardPage().waitUntilLoaderScreenDisappear();
        }
    }

}

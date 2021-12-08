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
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LicensePlate]']")).sendKeys("FE124578");
            int count = Driver.get().findElements(By.xpath("//div[@data-ftid='custom_entity_type_Tags']/div")).size();
            for (int c = 1; c <= count; c++) {
                Driver.get().findElement(By.xpath("(//div[@data-ftid='custom_entity_type_Tags']/div)[" + c + "]/input")).click();
            }
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Driver]']")).sendKeys("Fatih ERDEN");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Location]']")).sendKeys("Istanbul");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ChassisNumber]']")).sendKeys("C320");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[ModelYear]']")).sendKeys("2020");
            System.out.println("Last otomater");
            String lastOdometer = "12350".replace(".0", "");
            System.out.print(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[LastOdometer]']")).sendKeys(lastOdometer);

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CatalogValue]']")).sendKeys("25000");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[SeatsNumber]']")).sendKeys("4");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[DoorsNumber]']")).sendKeys("4");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Color]']")).sendKeys("Black");

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Automatic']")).click();

            Driver.get().findElement(By.xpath("(//span[text()='Choose a value...'])[1]")).click();
            Driver.get().findElement(By.xpath("//div[text()='Hybrid']")).click();

            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[CO2Emissions]']")).sendKeys("170");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Horsepower]']")).sendKeys("300");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[HorsepowerTaxation]']")).sendKeys("10");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Power]']")).sendKeys("700");
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")));
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_ImmatriculationDate')]")).sendKeys("Dec 13, 2020");
            Driver.get().findElement(By.xpath("//input[contains(@name,'date_selector_custom_entity_type_FirstContractDate')]")).sendKeys("Dec 8, 2020");
            File file = new File("src/test/resources/volvo.png");
            Driver.get().findElement(By.xpath("//input[@name='custom_entity_type[Logo][file]']")).sendKeys(file.getAbsolutePath());
            JavascriptExecutor js = (JavascriptExecutor) Driver.get();
            js.executeScript("document.getElementsByClassName('btn btn-success action-button')[0].click()");
            new DashboardPage().waitUntilLoaderScreenDisappear();
        }
    }

}

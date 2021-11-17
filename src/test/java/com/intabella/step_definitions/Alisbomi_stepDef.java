package com.intabella.step_definitions;

import com.intabella.pages.LoginPage;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alisbomi_stepDef {

    @Given("Login with {string} {string}")
    public void login_with(String username, String password) {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        WebElement element = Driver.get().findElement(By.xpath("//div[@class='input-prepend']/passwordboxicon"));
        String text = element.getText();
        System.out.println("text = " + text);

    }

}

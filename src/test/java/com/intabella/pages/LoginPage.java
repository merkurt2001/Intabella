package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement message;

   @FindBy(xpath = "//*[@class='dropdown-toggle']")
   public WebElement JonDoeDropDown;

   @FindBy(linkText = "Logout")
   public WebElement logout;

   public void logOutUser(){
       JonDoeDropDown.click();
       BrowserUtils.waitFor(2);
       logout.click();
   }

    public String getMessage(){
        return message.getText();
    }

    public String getAtribute(){

        return userName.getAttribute("validationMessage");
    }

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

 Almpano_Vehicle_General_Information
    public void logInAsdifferntUser(String userType){

        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("salesmanager_username");
            password = ConfigurationReader.get("salesmanager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("storemanager_username");
            password = ConfigurationReader.get("storemanager_password");
        } else {
            System.out.println("Invalid user");
        }
        new LoginPage().login(username, password);
    }
 Almpano_Vehicle_General_Information


}

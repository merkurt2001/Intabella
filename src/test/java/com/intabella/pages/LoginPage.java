package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    //Test Control1

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


}

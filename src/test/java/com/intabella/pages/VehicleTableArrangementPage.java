package com.intabella.pages;

import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleTableArrangementPage{
    public VehicleTableArrangementPage(){
        PageFactory.initElements(Driver.get(), this);}

   @FindBy(className = "btn dropdown-toggle ")
    public WebElement vehicleViewPerPageDefault;







}

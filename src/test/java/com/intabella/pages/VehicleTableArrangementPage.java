package com.intabella.pages;

import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleTableArrangementPage{
    public VehicleTableArrangementPage(){
        PageFactory.initElements(Driver.get(), this);}

   @FindBy(xpath= "//*[@class='btn dropdown-toggle ']")
    public WebElement vehicleViewPerPageDefault;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> vehicleViewPerPageDropdown;

@FindBy(xpath = "//table/thead/tr/th[6]")
    public WebElement ModelYearClick;





}

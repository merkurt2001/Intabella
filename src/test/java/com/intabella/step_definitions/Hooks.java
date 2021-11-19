package com.intabella.step_definitions;

import com.intabella.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
//        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpDb(){
        System.out.println("\tconecting to database....");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconecting database....");
    }
}

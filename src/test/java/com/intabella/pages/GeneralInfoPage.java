package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import com.intabella.utilities.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.*;

public class GeneralInfoPage extends BasePage{

    Pages pages = new Pages();

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> AllTableRow;

    @FindBy(xpath = "//h5[@class='user-fieldset']" )
    public WebElement GeneralInfoPageSubtitle;

    @FindBy(xpath = "//*[@class='fa-eye hide-text']")
    public WebElement eyeIcon;

    @FindBy(xpath = "//i[@class='fa-clock-o hide-text']")
    public WebElement addEventBtn;

    @FindBy(xpath = "//i[@class='fa-pencil-square-o hide-text']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='fa-trash-o hide-text']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='control-label']")
    public List<WebElement> ListOfGeneralInfoPageRowInfo;

    @FindBy(xpath ="//table/tbody/tr[1]")
    public WebElement TableFirstRow;

    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeletebutton;


    public void NavGeneralInformationPage(){
        BrowserUtils.waitFor(5);
        TableFirstRow.click();
    }


    public void TheUserShouldSeeGIP(){

        BrowserUtils.waitFor(3);

        for (int i = 1; i <= AllTableRow.size(); i++) {
            WebElement row1 = Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            row1.click();
            BrowserUtils.waitFor(5);
            Assert.assertEquals("General Information",GeneralInfoPageSubtitle.getText());
            Driver.get().navigate().back();
        }
        pages.loginPage().logOutUser();
    }

    public void clickEye(String userType){

        String driver = "driver";

        if (driver.equals(userType)) {

            BrowserUtils.waitFor(3);

            for (int i = 1; i <= AllTableRow.size(); i++) {

                WebElement dots = Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[20]"));
                BrowserUtils.doubleClick(dots);
                eyeIcon.click();
                BrowserUtils.waitFor(3);
                Assert.assertEquals("General Information",GeneralInfoPageSubtitle.getText());
                Driver.get().navigate().back();
            }
            pages.loginPage().logOutUser();
        }else {

            BrowserUtils.waitFor(3);

            for (int i = 1; i <= AllTableRow.size(); i++) {

                WebElement dots = Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[21]"));
                BrowserUtils.doubleClick(dots);
                eyeIcon.click();
                BrowserUtils.waitFor(3);
                Assert.assertEquals("General Information",GeneralInfoPageSubtitle.getText());
                Driver.get().navigate().back();
            }
            pages.loginPage().logOutUser();
        }
    }

    public void shouldSeeTheAddEventEditDeleteBtn(){

        BrowserUtils.waitFor(3);

        for (int i = 1; i <= AllTableRow.size(); i++) {

            WebElement row1 = Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            row1.click();
            BrowserUtils.waitFor(5);

            Assert.assertTrue(addEventBtn.isDisplayed());
            Assert.assertTrue(editBtn.isDisplayed());
            Assert.assertTrue(deleteBtn.isDisplayed());

            Driver.get().navigate().back();
        }
        pages.loginPage().logOutUser();
    }

    public void shouldNotHaveAddEventEditDeleteBtn(){

        BrowserUtils.waitFor(3);

        for (int i = 1; i <= AllTableRow.size(); i++) {

            WebElement row1 = Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            row1.click();
            BrowserUtils.waitFor(5);

            Assert.assertFalse("should not be displayed", editBtn.isDisplayed());
            Assert.assertFalse("should not be displayed", deleteBtn.isDisplayed());
            Assert.assertFalse("should not be displayed",addEventBtn.isDisplayed());

            Driver.get().navigate().back();
        }
        pages.loginPage().logOutUser();
    }

    public void InfoShouldBeTheSame(String userType){

        String dr = "driver";
        String slmn = "sales manager";
        String stmn = "store manager";

        if (dr.equals(userType)) {

            BrowserUtils.waitFor(3);

            List<String> allInfoRow = new ArrayList<>();
            List<String> GIPInfoPage = new ArrayList<>();

            for (int i = 1; i < AllTableRow.size(); i++) {

                List<WebElement> rowCellInfo = Driver.get().findElements(By.xpath("//table/tbody/tr[" + i + "]/td"));
                for (int j = 0; j < rowCellInfo.size() - 1; j++) {
                    allInfoRow.add(rowCellInfo.get(j).getText());
                }

                Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]")).click();

                new DashboardPage().waitUntilLoaderScreenDisappear();
                BrowserUtils.waitFor(3);

                for (int j = 0; j < ListOfGeneralInfoPageRowInfo.size() - 3; j++) {
                    GIPInfoPage.add(ListOfGeneralInfoPageRowInfo.get(j).getText());
                }

                Assert.assertEquals(allInfoRow, GIPInfoPage);
                Driver.get().navigate().back();
            }
            pages.loginPage().logOutUser();

        }else if (slmn.equals(userType) || stmn.equals(userType)) {
            BrowserUtils.waitFor(3);

            List<String> allInfoRow = new ArrayList<>();
            List<String> GIPInfoPage = new ArrayList<>();

            for (int i = 1; i < AllTableRow.size(); i++) {

                List<WebElement> rowCellInfo = Driver.get().findElements(By.xpath("//table/tbody/tr[" + i + "]/td"));
                for (int j = 1; j < rowCellInfo.size() - 1; j++) {
                    allInfoRow.add(rowCellInfo.get(j).getText());
                }

                Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]")).click();

                new DashboardPage().waitUntilLoaderScreenDisappear();
                BrowserUtils.waitFor(3);

                for (int j = 0; j < ListOfGeneralInfoPageRowInfo.size() - 3; j++) {
                    GIPInfoPage.add(ListOfGeneralInfoPageRowInfo.get(j).getText());
                }

                Assert.assertEquals(allInfoRow, GIPInfoPage);
                Driver.get().navigate().back();
            }
            pages.loginPage().logOutUser();
        }
    }
}

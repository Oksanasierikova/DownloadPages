package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddOfficeButton extends OfficesListPage {

    protected static final String OFFICEINFO = "//h5[text()='Office info']";
    protected static final String NAME = "//input[@name='Name']";
    protected static final String COUNTRY = "//span[@title='Ukraine']";
    protected static final String CITY = "//span[@title='Kharkiv']";
    protected static final String ADDRESS = "//input[@name='AddressText']";
    protected static final String SAVE = "//button[@type='submit']";

    public AddOfficeButton(WebDriver driver) {
        super(driver);
    }

    public String getOfficeInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OFFICEINFO))).getText();
    }

    public OfficesListPage addNewOffice(String name, String address) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME))).sendKeys(name);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COUNTRY))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CITY))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDRESS))).sendKeys(address);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE))).click();
        WebElement element = driver.findElement(By.xpath(SAVE));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Thread.sleep(3000);
        return new OfficesListPage(driver);
    }

//    public String getOfficeName() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME))).getText();
//    }
//
//    public String getOfficeCountry() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COUNTRY))).getText();
//    }
//
//    public String getOfficeCity() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CITY))).getText();
//    }
//
//    public String getOfficeAddress() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDRESS))).getText();
//    }



}

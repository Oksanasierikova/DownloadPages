package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.ref.SoftReference;

public class OfficesListPage extends LogIn {
    protected static final String OFFICE_LIST = "//div[contains(text(),'Offices')]";
    //protected static final String ADD_BUTTON = "//a[@href='/offices/office/add']";
    protected static final String ADD_BUTTON = "a.btn btn-sm btn-white";
    protected static final String GO = "//button[text()='Go!']";
    protected static final String NAME_OFFICE = "//a[contains(text(),'Automation')]";
    protected static final String X = "//span[contains(text(),'×')]";
    protected static final String GENERAL = "//a[@href='/offices/office/view/5']";
    protected static final String EDIT_BUTTON = "//a[@href='/offices/office/edit/5']";
    protected static final String ACTIVE_BUTTON = "//button[text()='Active']";
    protected static final String INCTIVE_BUTTON = "//button[text()='Inactive']";

    public OfficesListPage(WebDriver driver) {
        super(driver);
    }

    public String getOfficeListBreadcrumb() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OFFICE_LIST))).getText();
    }


    public AddOfficeButton addOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(ADD_BUTTON));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(ADD_BUTTON))));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

//        Thread.sleep(2000);
//        element.click();
        return new AddOfficeButton(driver);
    }

    public String search() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchText"))).sendKeys("Automation2");
        WebElement element = driver.findElement(By.xpath(GO));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(GO))));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        //Thread.sleep(2000);
        //element.click();
        // Thread.sleep(1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_OFFICE))).getText();
    }

    public String cancelSearch() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(X));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(X))));
        //Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        //element.click();
        //Thread.sleep(1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchText"))).getText();
    }

    public ViewOffice viewOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(GENERAL));
        // Actions actions = new Actions(driver);
        // actions.moveToElement(element).click().perform();
        Thread.sleep(5000);
        element.click();
        return new ViewOffice(driver);
    }

    public EditOffice editOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(EDIT_BUTTON));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().perform();
        Thread.sleep(5000);
        element.click();
        return new EditOffice(driver);
    }

    public String clickActiveOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(ACTIVE_BUTTON));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACTIVE_BUTTON)));
        element.click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACTIVE_BUTTON))).getText();
    }

    public String clickInactiveOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(INCTIVE_BUTTON));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INCTIVE_BUTTON)));
        Thread.sleep(1000);
        element.click();
//        Actions actions2 = new Actions(driver);
//        actions2.moveToElement(element2).click().perform();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACTIVE_BUTTON))).getText();
    }
}

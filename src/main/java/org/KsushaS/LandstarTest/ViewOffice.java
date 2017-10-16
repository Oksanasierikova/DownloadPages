package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewOffice extends OfficesListPage {
    protected static final String GENERAL = "//strong[text()='General']";
    protected static final String OFFICES_VIEW = "//a[@title='Offices']";

    public ViewOffice(WebDriver driver) {
        super(driver);
    }

    public String getNameOfOffice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GENERAL))).getText();
    }

    public String getOfficesBC() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OFFICES_VIEW))).getText();
    }

    public OfficesListPage back() throws InterruptedException {
        WebElement element = driver.findElement(By.id("btn-back"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("btn-back"))));
        //Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        // Thread.sleep(10000);
        return new OfficesListPage(driver);
    }

}

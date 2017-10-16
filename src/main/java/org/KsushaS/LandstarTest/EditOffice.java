package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditOffice extends OfficesListPage {
    protected static final String GENERAL = "//strong[text()='General']";

    public EditOffice(WebDriver driver) {
        super(driver);
    }

    public String generalLink(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GENERAL))).getText();
    }

    public EditYourPhoto editYourPhoto() throws InterruptedException {

        WebElement element = driver.findElement(By.id("update-avatar"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update-avatar"))));
        //Thread.sleep(5000);
        element.click();
        return new EditYourPhoto(driver);
    }


}

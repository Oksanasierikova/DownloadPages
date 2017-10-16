package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class EditYourPhoto extends EditOffice {

    protected static final String UPLOAD_NEW_IMAGE = "//label[@title='Upload new image']";
    protected static final String SAVE = "//button[text()='Save']";

    public EditYourPhoto(WebDriver driver) {
        super(driver);
    }

    public static void setClipboard(String str) {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }

    public EditOffice uploadNewImage() throws InterruptedException, AWTException {
        setClipboard("file://C:/Users/Ksu Sierra/IdeaProjects/DownloadPages/Pictures/office.jpg");
        //Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(UPLOAD_NEW_IMAGE)))); //explicit wait
        driver.findElement(By.xpath(UPLOAD_NEW_IMAGE)).click();
        Thread.sleep(7000);
        try {
            Robot robot = new Robot();
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(SAVE))));//explicit wait
        driver.findElement(By.xpath(SAVE)).click();
        return new EditOffice(driver);
    }

}

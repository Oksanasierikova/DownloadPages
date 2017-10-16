package org.KsushaS.LandstarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class LogIn {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    protected Actions actions;
    private long DEFAULT_TIMEOUT = 1;

    private static final String SITE_URL = "http://test.imbatransport.com/login";
    protected static final String EMAIL = "Email";
    protected static final String PASSWORD = "Password";
    protected static final String LOGIN = "//button[@type='submit']";

    public LogIn(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public LogIn navigate() {
        driver.get(SITE_URL);
        return this;
    }

    public OfficesListPage login(String email, String passw) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD))).sendKeys(passw);
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(LOGIN));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Thread.sleep(2000);
        return new OfficesListPage(driver);
    }

}

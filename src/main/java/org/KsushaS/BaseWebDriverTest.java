package org.KsushaS;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
public class BaseWebDriverTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert softAssert;
    public WebElement element;
    public Actions actions;
    private long startTime;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void initDriver(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280 ,1024));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startTime = Reporter.getCurrentTestResult().getStartMillis();
        wait = new WebDriverWait(driver, 150);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void destroyDriver(){
        if(driver!=null) {
            driver.quit();
        }

        Reporter.log("Elapsed time: "+(Reporter.getCurrentTestResult().getEndMillis()-startTime/1000),true);
    }

}


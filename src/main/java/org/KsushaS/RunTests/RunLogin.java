package org.KsushaS.RunTests;

import org.KsushaS.BaseWebDriverTest;
import org.KsushaS.LandstarTest.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class RunLogin extends BaseWebDriverTest {

    @DataProvider(name = "logIn")
    public Object[][] logIn() {
        return new Object[][]{
                {"osierikova@devsymmetrix.com", "Q1w2e3r4"}
        };
    }

    @Test(dataProvider = "logIn")
    public void logInToLandstar(String email, String passw) throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login(email, passw);
        OfficesListPage officePage = new OfficesListPage(driver);
        softAssert.assertTrue(officePage.getOfficeListBreadcrumb().contains("Office"));
        softAssert.assertAll();
    }

    @DataProvider(name = "addNewOffice")
    public Object[][] addNewOffice() {
        return new Object[][]{
                {"Auto2", "Proton"}
        };
    }

//    @DataProvider(name = "addNewOffice")
//    public Object[][] addNewOffice() {
//        int a = 0; // Начальное значение диапазона - "от"
//        int b = 10;
//        int random_number1 = a + (int) (Math.random() * b);
//        int random_number2 = a + (int) (Math.random() * b);
//        return new Object[][]{
//                {random_number1, random_number2}
//        };
//    }

    @Test(dataProvider = "addNewOffice")
    public void addOffice(String name, String address) throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage addOffice = new OfficesListPage(driver);
        addOffice.addOffice().addNewOffice(name, address);
        softAssert.assertTrue(addOffice.getOfficeListBreadcrumb().contains("Office"));
        softAssert.assertAll();
    }

    @Test()
    public void search() throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage addOffice = new OfficesListPage(driver);
        addOffice.search();
        addOffice.cancelSearch();
    }

    @Test()
    public void goToViewOffice() throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage addOffice = new OfficesListPage(driver);
        addOffice.viewOffice();
        ViewOffice clickBack = new ViewOffice(driver);
        softAssert.assertTrue(clickBack.getOfficesBC().contains("Offices"));
        softAssert.assertTrue(clickBack.getNameOfOffice().contains("General"));
        clickBack.back();
        softAssert.assertAll();
    }

    @Test()
    public void uploadPhoto() throws InterruptedException, AWTException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage editOffice = new OfficesListPage(driver);
        editOffice.editOffice();
        EditOffice editOfficePage = new EditOffice(driver);
        softAssert.assertTrue(editOfficePage.generalLink().contains("General"));
        editOfficePage.editYourPhoto();
        EditYourPhoto editYourPhoto = new EditYourPhoto(driver);
        editYourPhoto.uploadNewImage();
        softAssert.assertTrue(editOfficePage.generalLink().contains("General"));
        softAssert.assertAll();
    }

    @Test()
    public void setInactive() throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage clickActive = new OfficesListPage(driver);
        clickActive.clickActiveOffice();
        OfficesListPage clickActive1 = new OfficesListPage(driver);
        clickActive1.clickInactiveOffice();
    }

    @Test()
    public void setActive() throws InterruptedException {
        LogIn landstar = new LogIn(driver).navigate().login("osierikova@devsymmetrix.com", "Q1w2e3r4");
        OfficesListPage clickActive = new OfficesListPage(driver);
        clickActive.clickInactiveOffice();
    }

}

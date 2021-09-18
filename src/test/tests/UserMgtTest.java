package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UserMngPage;


public class UserMgtTest extends BaseTest {
    UserMngPage userMngPage;
    @BeforeMethod
    public void setUp(){
        userMngPage = new UserMngPage(driver);
        userMngPage.UserMngBtn.click();
    }

    @Test(testName = "Log in page" , description = "Click and verify the title Login Page", groups = {"smokeTest", "regression"})
    public void test01() {

        String currentWindow = driver.getWindowHandle();
        userMngPage.loginBtn.click();
        userMngPage.switchWindows();
        String actual = driver.getTitle();
        logScreenshot("Login Page");

        driver.switchTo().window(currentWindow);

        String expected = "Login Page";

        Assert.assertEquals(actual, expected);

        extentTest.assignAuthor("Madi");
        extentTest.assignDevice("Windows PC");

        extentTest.pass("Login page title | " + expected);
    }
    @Test(testName = "User DB page", description = "Click and verify the title User DB Page", groups = {"smokeTest", "regression"})
    public void test02() {

        String currentWindow = driver.getWindowHandle();
        userMngPage.accesBtn.click();
        userMngPage.switchWindows();
        String actual = driver.getTitle();
        logScreenshot("User DB Page");

        driver.switchTo().window(currentWindow);

        String expected = "User DB";

        Assert.assertEquals(actual, expected);

        extentTest.assignAuthor("Madi");
        extentTest.assignDevice("Windows PC");

        extentTest.pass("User DB page title | " + expected);
    }

}

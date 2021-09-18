package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserMngPage;

import java.util.Set;

public class UserMgtTest extends BaseTest {
    UserMngPage userMngPage;
    @BeforeMethod
    public void setUp(){
        userMngPage = new UserMngPage(driver);
    }

    @Test(description = "Click and verify the title", groups = {"smokeTest", "regression"})
    public void test01(){

        userMngPage.click(userMngPage.UserMngBtn);
        logScreenshot("UserManegementButtent");

        userMngPage.loginBtn.click();

        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(eachWindow);
            }
        }

        String actualLogin = driver.getTitle();

        driver.switchTo().window(currentWindow);

        userMngPage.accesBtn.click();
        String currentWindow1 = driver.getWindowHandle();
        Set<String> windows1 = driver.getWindowHandles();
        for(String eachWindow: windows1){
            if (!eachWindow.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(eachWindow);
            }
        }
        String actualUserDB = driver.getTitle();

        String expectedlLogin = "Login Page";
        String expectedUserDB = "User DB";

        Assert.assertEquals(actualLogin,expectedlLogin);
        Assert.assertEquals(actualUserDB,expectedUserDB);

        extentTest.assignAuthor("Madi");
        extentTest.assignDevice("Windows PC");
        extentTest.info("Login page title");
        extentTest.pass(expectedlLogin);
        extentTest.info("User DB page title");
        extentTest.pass(expectedUserDB);

    }

}

package tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test(description = "Validation you can see 7 links in the bottom of the page", groups = {"smokeTest", "regression"})
    public void test01(){
        homePage.moveIntoView(homePage.bottom);
        logScreenshot("Home page");
    }
}

package tests;

import Base.BaseTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test(testName = "Home page", description = "Validation you can see 7 links in the bottom of the page", groups = {"smokeTest", "regression"})
    public void test01(){
        homePage.moveIntoView(homePage.bottom);
        logScreenshot("Home page");

        List <WebElement> links = driver.findElements(By.xpath("//a[@class='link']"));

        List<String> actualLinks = new ArrayList<>();
        for(WebElement each: links){
            actualLinks.add(each.getText());
        }

        extentTest.info("Bottom links list:");
        extentTest.info(MarkupHelper.createUnorderedList(actualLinks));

        Assert.assertTrue(links.size()==7);
        extentTest.pass("Quantity of the links = " + links.size());
    }
}

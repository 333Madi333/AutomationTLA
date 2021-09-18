package pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMngPage extends BasePage {
    protected WebDriver driver;

    public UserMngPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='User-Mgt']")
    public WebElement UserMngBtn;

    @FindBy(id = "login-btn")
    public WebElement loginBtn;

    @FindBy(id = "access-db-btn")
    public WebElement accesBtn;


}
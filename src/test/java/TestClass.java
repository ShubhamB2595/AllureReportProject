import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{

    // Initialization of URLs
    private String HOMEPAGE_URL = "https://www.bookswagon.com/";
    
    // Initialization of Web elements
    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement SEARCH_TXT;
    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement SEARCH_BTN;

    @BeforeTest
    public void testSetup() {
        driverSetup();
        PageFactory.initElements(driver, this);
        driver.get(HOMEPAGE_URL);
    }

    @Test
    @Description("Verify search result")
    public void searchResult() {
        SEARCH_TXT.sendKeys("Selenium");
        SEARCH_BTN.click();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

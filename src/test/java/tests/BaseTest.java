package tests;

import driver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    WebDriver driver;
    ChromeDriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        driverManager = new ChromeDriverManager();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }

}

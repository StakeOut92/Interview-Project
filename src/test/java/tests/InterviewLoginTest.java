package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class InterviewLoginTest extends BaseTest {
    LoginPage loginPage;
    private static final Logger LOGGER = LogManager.getLogger("Interview");

    @Test
    public void loginTest() {
        LOGGER.info("Login Test started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        Boolean pageTitle = driver.findElement(By.className("titleLabel")).isEnabled();
        Assert.assertTrue(pageTitle, "Page title is not available");
    }
}

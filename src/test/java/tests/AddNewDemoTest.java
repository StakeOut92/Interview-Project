package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateInterviewPage;
import pages.LoginPage;

public class AddNewDemoTest extends BaseTest {
    LoginPage loginPage;
    CreateInterviewPage createInterviewPage;
    private static final Logger LOGGER = LogManager.getLogger("Interview");

    @Test
    public void goToDemoAndFillAllFieldsTest() {
        LOGGER.info("Go to demo and fill all fields test started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        createInterviewPage = new CreateInterviewPage(driver);
        createInterviewPage.clickToInterviewLink();
        createInterviewPage.clickToDemoLink();
        createInterviewPage.inputName();
        createInterviewPage.inputEmail();
        createInterviewPage.clickMalePointer();
        createInterviewPage.clickYesPointer();
        createInterviewPage.fillDate();
        createInterviewPage.dropDownSelect();
        createInterviewPage.imageUpload();
        createInterviewPage.slideSlider();
        createInterviewPage.clickRadioButton1();
        createInterviewPage.clickRadioButton2();
        createInterviewPage.clickCancelButton();
        Boolean notStartedMessage = driver.findElement(By.className("crfStatusAvailable")).isDisplayed();
        Assert.assertTrue(notStartedMessage, "Message not showing or otherwise");
    }
}

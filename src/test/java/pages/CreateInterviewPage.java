package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class CreateInterviewPage extends HtmlElement {
    private static final Logger LOGGER = LogManager.getLogger("Interview");
    WebDriver driver;
    String filePath = "C:\\Users\\inoze\\IdeaProjects\\Interview Project\\src\\test\\resources\\Selenium_Logo.png";

    @Name("Interview button")
    @FindBy(className = "cardStudyName")
    private Button interviewLink;

    @Name("Demo activity button")
    @FindBy(xpath = "//div[@class='linkLabel' and contains(text(),'Demo')]")
    private Button demoActivityLink;

    @Name("Name input field")
    @FindBy(id = "name")
    private TextInput nameInputField;

    @Name("Email input field")
    @FindBy(id = "e_mail")
    private TextInput emailInputField;

    @Name("Gender male pointer")
    @FindBy(xpath = "//div[@class='gwt-Label' and (text()='male')]")
    private Button malePointer;

    @Name("Yes pointer")
    @FindBy(xpath = "//div[@class='gwt-HTML' and contains (text(),'Yes')]")
    private Button yesPointer;

    @Name("date")
    @FindBy(id = "date")
    private TextInput datefield;

    @Name("Dropdown")
    @FindBy(id = "dropdown_input")
    private TextInput dropDown;

    @Name("Upload image file")
    @FindBy(xpath = "//input[@type='file']")
    private TextInput uploadImageFile;

    @Name("Slider")
    @FindBy(id = "simple-slider")
    private WebElement sliderValue;

    @Name("Radio button 1")
    @FindBy(id = "gwt-uid-135")
    private Radio radioButton1;

    @Name("Radio button 2")
    @FindBy(id = "gwt-uid-142")
    private Radio radioButton2;

    @Name("Cancel button")
    @FindBy(xpath = "//div[@class='myHealthButtonsBottom']//span[text()='Cancel']")
    private Button cancelButton;

    @Name("Not started message")
    @FindBy(className = "crfStatusAvailable")
    private WebElement notStartedMessage;

    public void clickToInterviewLink() {
        LOGGER.info("Start method click to interview link");
        interviewLink.click();
    }

    public void clickToDemoLink() {
        LOGGER.info("Start method click to demo link");
        demoActivityLink.click();
    }

    public void inputName() {
        LOGGER.info("Start method inputName");
        nameInputField.sendKeys("Evgeny");
    }

    public void inputEmail() {
        LOGGER.info("Start method inputEmail");
        emailInputField.sendKeys("anyway@yopmail.com");
    }

    public void clickMalePointer() {
        LOGGER.info("Start method clickMalePointer");
        malePointer.click();
    }

    public void clickYesPointer() {
        LOGGER.info("Start method clickYesPointer");
        yesPointer.click();
    }

    public void fillDate() {
        LOGGER.info("Start method fillDate");
        String pattern = "MMM dd, YYYY";
        DateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date today = Calendar.getInstance().getTime();
        datefield.sendKeys(df.format(today));
        datefield.sendKeys(Keys.ENTER);
    }

    public void dropDownSelect() {
        LOGGER.info("Start method dropDownSelect");
        dropDown.sendKeys("Yes");
        dropDown.sendKeys(Keys.ENTER);
    }

    public void imageUpload() {
        LOGGER.info("Start method imageUpload");
        uploadImageFile.sendKeys(filePath);
    }

    public void slideSlider() {
        LOGGER.info("Start method slideSlider");
        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderValue,10,0).click();
        action.build().perform();
    }

    public void clickRadioButton1() {
        LOGGER.info("Start method clickRadioButton1");
        radioButton1.click();
    }

    public void clickRadioButton2() {
        LOGGER.info("Start method clickRadioButton2");
        radioButton2.click();
    }

    public void clickCancelButton() {
        LOGGER.info("Start method clickCancelButton");
        cancelButton.click();
    }


    public CreateInterviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }
}

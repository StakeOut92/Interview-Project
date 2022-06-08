package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import staticdata.EmailAndPasswords;
import staticdata.WebUrls;


public class LoginPage extends HtmlElement {
    private static final Logger LOGGER = LogManager.getLogger("Interview");
    WebDriver driver;


    @Name("Email input")
    @FindBy(id = "login_username")
    private TextInput emailInput;

    @Name("Login Button")
    @FindBy(id = "login_applyButton")
    private Button signInButton;

    @Name("Password Input")
    @FindBy(id = "login_password")
    private TextInput passwordInput;


    public void openPage() {
        LOGGER.info("openPage method started");
        driver.get(WebUrls.REDCAP_LOGIN_URL);
    }

    public void makeLogin() {
        LOGGER.info("makeLogin method started");
        emailInput.sendKeys(EmailAndPasswords.LOGIN_EMAIL);
        signInButton.click();
        passwordInput.sendKeys(EmailAndPasswords.LOGIN_PASSWORD);
        signInButton.click();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }


}

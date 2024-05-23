package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver = null;
    @FindBy(id = "input-18")
    WebElement username_id;
    @FindBy(id = "input-21")
    WebElement password_id;
    @FindBy(xpath = "//span[contains(.,'Login')]")
    WebElement loginButton_id;
    @FindBy(xpath = "//div[@class='v-messages__message'][contains(.,'These credentials do not match our records.')]")
    WebElement loginUnsuccessful_xpath;


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public LoginPage enterUsername(String username) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(username_id));

        username_id.clear();
        Thread.sleep(2000);
        username_id.sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) throws InterruptedException {
        password_id.clear();
        Thread.sleep(2000);
        password_id.sendKeys(password);

        return this;
    }

    public void clickLoginButton() {
        loginButton_id.click();
    }


    public LoginPage verifyUnsuccessfulLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginUnsuccessful_xpath));
        String loginUnsuccessful = loginUnsuccessful_xpath.getText();
        Assert.assertEquals(loginUnsuccessful, "These credentials do not match our records.");

        return this;

    }

}

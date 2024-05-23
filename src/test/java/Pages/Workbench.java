package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Workbench {

    WebDriver driver = null;

    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Workbench')]")
    WebElement homePage_xpath;


    public Workbench(WebDriver driver) {

        this.driver = driver;
    }

    public void verifySuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePage_xpath));
        String loginSuccessful = homePage_xpath.getText();
        Assert.assertEquals(loginSuccessful, "Workbench");
    }


}

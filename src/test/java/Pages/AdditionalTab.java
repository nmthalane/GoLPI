package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AdditionalTab {

    WebDriver driver = null;

    public AdditionalTab(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Additional')]")
    WebElement clickAdditional_xpath;

    @FindBy(xpath = "//div[@class='v-select__slot'][contains(.,'Marital Status')]")
    WebElement maritalStatusDropdownList_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Married (Community of Property)')]")
    WebElement marriedCommunityOfProperty_xpath;

    @FindBy(xpath = "//div[@class='col-sm-6 col-12'][contains(.,'Smoking Status')]")
    WebElement smokingStatusDropdownList_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Non-smoker')]")
    WebElement nonSmoker_xpath;

    @FindBy(xpath = "//div[@role='button'][contains(.,'Education')]")
    WebElement educationDropdownList_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Diploma')]")
    WebElement diploma_xpath;

    @FindBy(xpath = "//div[@class='v-input__slot'][contains(.,'Monthly IncomeR')]")
    WebElement monthlyIncome;
    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement decreaseMonthlyIncome;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement increaseMonthlyIncome;

    @FindBy(xpath = "//div[contains(@class,'v-input--selection-controls__ripple')]")
    WebElement hasWillRadioButton_xpath;
    @FindBy(xpath = "//div[@class='v-select__slot'][contains(.,'Will provider')]")
    WebElement WillProvider_xpath;

    @FindBy(xpath = "//input[contains(@placeholder,'Start typing to Search')]")
    WebElement searchStartTyping_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Capital legacy')]")
    WebElement selectWillProvider_xpath;

    @FindBy(xpath = "//span[@class='v-btn__content'][contains(.,'Update')]")
    WebElement updateButton_xpath;

    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'Success')]")
    WebElement successMessage_xpath;


    public void clickAdditionalTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickAdditional_xpath));
        clickAdditional_xpath.click();
    }

    public void selectMaritalStatus() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdownList_xpath));
        Thread.sleep(2000);
        maritalStatusDropdownList_xpath.click();
        marriedCommunityOfProperty_xpath.click();
    }

    public void selectSmokingStatus() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(smokingStatusDropdownList_xpath));
        smokingStatusDropdownList_xpath.click();
        Thread.sleep(2000);
        nonSmoker_xpath.click();
    }

    public void selectEducation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(educationDropdownList_xpath));
        educationDropdownList_xpath.click();
        Thread.sleep(2000);
        diploma_xpath.click();
    }

    public void enterMonthlyIncome() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            increaseMonthlyIncome.click();
        }
        Thread.sleep(3000);
        for (int i = 0; i < 3; i++) {
            decreaseMonthlyIncome.click();
        }

    }

    public void selectHasWillOption(){

        hasWillRadioButton_xpath.click();
    }

    public void searchForWillProvider() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(WillProvider_xpath));
        WillProvider_xpath.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(searchStartTyping_xpath));
        searchStartTyping_xpath.sendKeys("Capital");
        wait.until(ExpectedConditions.elementToBeClickable(selectWillProvider_xpath));
        selectWillProvider_xpath.click();

    }

    public void clickUpdateButton(){
        updateButton_xpath.click();
    }

    public void updateSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(successMessage_xpath));

        String successMessage = successMessage_xpath.getText();
        Assert.assertEquals(successMessage,"Success");

    }

}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class AddNewClient {
    WebDriver driver = null;

    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'TOOLS')]")
    WebElement clickToolsDropDown_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'New Business')]")
    WebElement clickNewBusinessButton_xpath;
    @FindBy(xpath = "(//input[contains(@autocomplete,'off')])[1]")
    WebElement clickSearchForClient_xpath;

    @FindBy(xpath = "//div[contains(@class,'title pointer')]")
    WebElement clickCreateClient_xpath;


    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement firstName_xpath;
    @FindBy(xpath = "//div[@class='v-stepper__label'][contains(.,'Client Information')]")
    WebElement clientScreen_xpath;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement lastName_xpath;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    WebElement selectIdTypes_xpath;
    @FindBy(xpath = "//div[@class='v-list-item__title'][contains(.,'ID')]")
    WebElement selectIdNumber_xpath;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    WebElement idNumber_xpath;
    @FindBy(xpath = "(//span[contains(.,'Next')])[1]")
    WebElement clickNext_xpath;

    @FindBy(xpath = "(//div[contains(@class,'text--placeholder')])[1]")
    WebElement attach_IdDocuments_xpath;

    @FindBy(xpath = "(//div[contains(@class,'text--placeholder')])[2]")
    WebElement attach_proofOfAddress_xpath;

    @FindBy(xpath = "//div[@class='v-input__slot'][contains(.,'Client Form')]")
    WebElement attach_ClientForm_xpath;

    @FindBy(xpath = "(//span[contains(.,'Next')])[2]")
    WebElement clickNextOnDocumentation_xpath;

    @FindBy(xpath = "//span[@class='v-btn__content'][contains(.,'Submit')]")
    WebElement clickSubmit_xpath;

    @FindBy(xpath = "//h3[contains(.,'Client information')]")
    WebElement clientInformationPage_xpath;

    public AddNewClient(WebDriver driver) {

        this.driver = driver;
    }

    public void clickTools() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickToolsDropDown_xpath));
        clickToolsDropDown_xpath.click();

    }

    public void clickNewBusiness() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickNewBusinessButton_xpath));
        clickNewBusinessButton_xpath.click();

    }

    public void clientInformationSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickSearchForClient_xpath));
        clickSearchForClient_xpath.click();
        clickSearchForClient_xpath.sendKeys("Brenda");
    }

    public void createNewClient() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickCreateClient_xpath));
        clickCreateClient_xpath.click();
    }

    public AddNewClient enterFirstname(String firstName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstName_xpath));
        Thread.sleep(3000);
        firstName_xpath.click();
        firstName_xpath.clear();
        firstName_xpath.sendKeys(firstName);
        return this;
    }

    public AddNewClient enterLastname(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastName_xpath));
        lastName_xpath.click();
        lastName_xpath.clear();
        lastName_xpath.sendKeys(lastName);
        return this;
    }

    public AddNewClient selectIdtype() {
        selectIdTypes_xpath.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectIdNumber_xpath));
        selectIdNumber_xpath.click();
        return this;
    }

    public AddNewClient enterIdNumber(String idNumber) {
        idNumber_xpath.sendKeys(idNumber);
        return this;
    }

    public void clickNextButton() {

        clickNext_xpath.click();
    }

    public void UploadIdentificationDocument() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(attach_IdDocuments_xpath));
        Thread.sleep(3000);
        upload.click();
        Runtime.getRuntime().exec("C:\\Users\\nkosinathim\\Documents\\fileupload.exe");
        Thread.sleep(3000);
    }

    public void uploadProofOfResidence() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(attach_proofOfAddress_xpath));
        Thread.sleep(3000);
        upload.click();
        Runtime.getRuntime().exec("C:\\Users\\nkosinathim\\Documents\\fileupload.exe");
        Thread.sleep(30000);
    }

    public void uploadClientForm() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement upload = wait.until(ExpectedConditions.elementToBeClickable(attach_ClientForm_xpath));
        upload.click();
        Runtime.getRuntime().exec("C:\\Users\\nkosinathim\\Documents\\fileupload.exe");
        Thread.sleep(50000);
    }

    public void clickNextButtonDocumentation() {

        clickNextOnDocumentation_xpath.click();
    }

    public void clickSubmitButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickSubmit_xpath));
        clickSubmit_xpath.click();
    }

    public void clientAddedSuccessfully() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clientInformationPage_xpath));

        String clientInfoPage = clientInformationPage_xpath.getText();
        Assert.assertEquals(clientInfoPage, "Client information");

    }

}

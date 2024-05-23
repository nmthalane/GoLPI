package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestGoLPI extends BaseTests {
    @Test
    public void verify_Login_is_Successful() throws InterruptedException {
        loginPage
                .enterUsername(readFromExcel.username)
                .enterPassword(readFromExcel.password)
                .clickLoginButton();
        workbench
                .verifySuccessful();
    }

    @Test(dependsOnMethods = "verify_Login_is_Successful")
    public void clickToolsThenNewBusiness() {

        addNewClient
                .clickTools();

        addNewClient
                .clickNewBusiness();
    }

    @Test(dependsOnMethods = "clickToolsThenNewBusiness")
    public void searchForClient() {
        addNewClient
                .clientInformationSearch();
        addNewClient
                .createNewClient();
    }

    @Test(dependsOnMethods = "searchForClient")
    public void enterClientInformation() throws InterruptedException {
        addNewClient
                //.enterFirstname(readFromExcel.firstName)
                .enterLastname(readFromExcel.lastName)
                .selectIdtype()
                .enterIdNumber(readFromExcel.idNumber)
                .clickNextButton();

    }

    @Test(dependsOnMethods = "enterClientInformation")
    public void uploadCopyOfIdentificationDocument() throws IOException, InterruptedException {
        addNewClient
                .UploadIdentificationDocument();
    }

    @Test(dependsOnMethods = "uploadCopyOfIdentificationDocument")
    public void uploadCopyOfProofOfResidence() throws IOException, InterruptedException {
        addNewClient
                .uploadProofOfResidence();
    }

    @Test(dependsOnMethods = "uploadCopyOfProofOfResidence")
    public void uploadCopyOfClientForm() throws IOException, InterruptedException {
        addNewClient
                .uploadClientForm();

    }

    @Test(dependsOnMethods = "uploadCopyOfClientForm")
    public void clickNextOnDocumentation() {
        addNewClient
                .clickNextButtonDocumentation();
    }

    @Test(dependsOnMethods = "clickNextOnDocumentation")
    public void clickSubmitButton() {

        addNewClient
                .clickSubmitButton();
    }

    @Test(dependsOnMethods = "clickSubmitButton")
    public void verifyClientAddedSuccessfully() {
        addNewClient
                .clientAddedSuccessfully();

    }
//
//    @Test(dependsOnMethods = "verifyClientAddedSuccessfully")
//    public void clickAdditionalTab() {
//        additionalTab
//                .clickAdditionalTab();
//
//    }
//
//    @Test(dependsOnMethods = "clickAdditionalTab")
//    public void selectMaritalStatusOption() throws InterruptedException {
//        additionalTab
//                .selectMaritalStatus();
//    }
//
//    @Test(dependsOnMethods = "selectMaritalStatusOption")
//    public void selectSmokerStatus() throws InterruptedException {
//        additionalTab
//                .selectSmokingStatus();
//    }
//
//    @Test(dependsOnMethods = "selectSmokerStatus")
//    public void selectEducation() throws InterruptedException {
//        additionalTab
//                .selectEducation();
//    }
//
//    @Test(dependsOnMethods = "selectEducation")
//    public void enterMonthlyIncome() throws InterruptedException {
//        additionalTab
//                .enterMonthlyIncome();
//    }
//
//    @Test(dependsOnMethods = "enterMonthlyIncome")
//    public void selectHasWillOption() {
//        additionalTab
//                .selectHasWillOption();
//    }
//
//    @Test(dependsOnMethods = "selectHasWillOption")
//    public void searchForWillProvider() throws InterruptedException {
//        additionalTab
//                .searchForWillProvider();
//    }
//
//    @Test(dependsOnMethods = "searchForWillProvider")
//    public void clickUpdateButton() {
//
//        additionalTab
//                .clickUpdateButton();
//    }
//
//    @Test(dependsOnMethods = "searchForWillProvider")
//    public void verifySuccessMessageIsDisplayed() {
//        additionalTab
//                .updateSuccessMessage();
//
//    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

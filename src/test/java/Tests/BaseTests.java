package Tests;

import Pages.AddNewClient;
import Pages.AdditionalTab;
import Pages.LoginPage;
import Pages.Workbench;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BaseTests {

    //BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = BrowserFactory.startBrowser("chrome", "https://go.lpi.co.za/login");

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    Workbench workbench = PageFactory.initElements(driver, Workbench.class);
    AddNewClient addNewClient = PageFactory.initElements(driver, AddNewClient.class);
    AdditionalTab additionalTab = PageFactory.initElements(driver, AdditionalTab.class);
    //TakeScreenshots takeScreenshots = PageFactory.initElements(driver, TakeScreenshots.class);
    ReadFromExcel readFromExcel;

    {
        try {
            readFromExcel = new ReadFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

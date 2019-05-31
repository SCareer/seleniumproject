package com.styleanalytics.sumo;

import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.utils.DataTables;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.text.ParseException;

public class SumoPage {

    WebDriver driver;

    @FindBy(name = "login")
    WebElement userNameBox;

    @FindBy(name = "password")
    WebElement passwordBox;

    @FindBy(id = "button-login")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"bento-nav\"]/bento-side-nav/div[2]/div/div[1]/span[4]")
    WebElement usersFolder;

    @FindBy(xpath = "//div[@class='tree-item__inside__label'][contains(text(),'Viswanath Selvaraj')]")
    WebElement myMainfolder;

    @FindBy(xpath = "//*[@id=\"bento-nav\"]/bento-side-nav/div[2]/div/div[2]/div[4]/library-tree-view/div/tree/div/div[2]/md-virtual-repeat-container/div/div[2]/div[12]/div/div[1]/div[2]")
    WebElement mySubFolder_Daily;

    @FindBy(xpath = "//div[contains(text(),'Daily Analysis Status')]")
    WebElement mySearch;

    @FindBy(xpath = "//div[@class='CodeMirror-code']")
    WebElement searchQueryBox;

    @FindBy(xpath = "//div[contains(@class,'table-font-medium')]//tbody")
    WebElement searchResultTable;


    public void mySearch(){

        Wait.waitForElementToDisplay(driver,usersFolder,60);
        usersFolder.click();
        Wait.waitForElementToDisplay(driver,myMainfolder,60);
        myMainfolder.click();
        Wait.waitForElementToDisplay(driver,mySubFolder_Daily,60);
        mySubFolder_Daily.click();
        Wait.waitForElementToDisplay(driver,mySearch,60);
        mySearch.click();
    }

    public void newSearchQuery(String query){

        Wait.waitForElementToDisplay(driver,searchQueryBox,60);
        searchQueryBox.sendKeys(query);
        searchQueryBox.sendKeys(Keys.RETURN);
    }

    public void newSearchByID(long id){
        try {
            driver.get("https://service.sumologic.com/ui/#/search/" + id);
            Wait.waitForElementToDisplay(driver, searchResultTable, 60);
        }catch (org.openqa.selenium.StaleElementReferenceException ex){
            driver.get("https://service.sumologic.com/ui/#/search/" + id);
            Wait.waitForElementToDisplay(driver, searchResultTable, 60);
        }
    }

    public int getResultsFromColumn(int column) throws ParseException {

        DataTables dataTables = new DataTables();
        int total = dataTables.getColumnValue(searchResultTable,column);
        return total;
        }

    public void getResultsFromrow(int row) throws ParseException {

        DataTables dataTables = new DataTables();
        dataTables.getRowValue(searchResultTable,row);
        //int total = dataTables.getRowValue(driver,searchResultTable,row);
       // return total;
    }

    public int getColumnCount() {

        DataTables dataTables = new DataTables();
        int total = dataTables.getNumberOfColumns(searchResultTable);
        return total;
    }

    public int getRowCount() {

        DataTables dataTables = new DataTables();
        int total = dataTables.getNumberOfRows(searchResultTable);
        return total;
    }

    public void setUserName(String userName) {

        Wait.waitForElementToDisplay(driver,userNameBox,60);
        userNameBox.sendKeys(userName);

    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);

    }

    public void setLoginButton() {
        loginButton.click();

    }

    public void login() throws IOException {

        String user = TestBase.property("sumoUser");
        String pass = TestBase.property("sumoPass");

        setUserName(user);
        setPassword(pass);
        setLoginButton();
    }

    public void login(String user,String pass) throws IOException {

        setUserName(user);
        setPassword(pass);
        setLoginButton();
    }

    public void getLoginPage() throws IOException {

        //String url = TestBase.property("URL");//Get the URL info from config file.
        driver.get("https://service.sumologic.com/ui/#/login");

    }

    public SumoPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}

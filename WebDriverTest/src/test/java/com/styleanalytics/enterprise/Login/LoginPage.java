package com.styleanalytics.enterprise.Login;

import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "ctl00_bodyContentPlaceholder_UserLogin_UserName")
    WebElement userNameBox;

    @FindBy(id = "ctl00_bodyContentPlaceholder_UserLogin_Password")
    WebElement passwordBox;

    @FindBy(id = "ctl00_bodyContentPlaceholder_UserLogin_LoginButton")
    WebElement loginButton;

    public void setUserName(String userName) {
        userNameBox.sendKeys(userName);

    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);

    }

    public void setLoginButton() {
        loginButton.click();

    }

    public void login() throws IOException {

        String user = TestBase.property("username");
        String pass = TestBase.property("password");

        setUserName(user);
        setPassword(pass);
        setLoginButton();
    }

    public void login(String user,String pass) throws IOException {

        setUserName(user);
        setPassword(pass);
        setLoginButton();
    }

    public void logout() throws IOException {

        String url = TestBase.property("URL");//Get the URL info from config file.
        driver.get(url + "/authentication/srlogout.aspx");

        }

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }


}
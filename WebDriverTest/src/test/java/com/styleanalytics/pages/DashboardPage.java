package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;
    private String reportName;

    @FindBy(id="masthead")
    WebElement dashboard;

    @FindBy(id = "hlMarketsAnalyzer")
    WebElement marketAnalyzer_btn;

    @FindBy(xpath = "//a[@title='Peer Insights Reports']")
    WebElement peerInsights_btn;

    @FindBy(xpath = "//a[@title='Custom Peer Groups']")
    WebElement customPeerGroup_btn;

    @FindBy(xpath = " //a[@title='Portfolio Reports']")
    WebElement portfolioReports_btn;

    @FindBy(xpath = "//a[@title='Load']")
    WebElement load_btn;

    @FindBy(xpath = "//a[@title='Explore']")
    WebElement explorer_btn;

    @FindBy(xpath = "//a[@title='Portfolio Labs']")
    WebElement portfolioLabs_btn;

    @FindBy(xpath = "//a[@title='Executive Reports']")
    WebElement executiveReports_btn;

    @FindBy(xpath = "//div[@class='starred']")
    WebElement starred_btn;

    @FindBy(xpath = "//div[@class='recent unrecent']")
    WebElement recent_btn;

    @FindBy(xpath = "//div[contains(text(),'MFS - Global Multi-Cap Core')]")
    WebElement report_tile;

    public void setDashboard() {

        dashboard.click();
        Wait.waitForElementToDisplay(driver,explorer_btn,30);
    }


    public void setMarketAnalyzer_btn() {

        marketAnalyzer_btn.click();
    }

    public void setPeerInsights_btn() {

        peerInsights_btn.click();
    }

    public void setCustomPeerGroup_btn() {
        customPeerGroup_btn.click();
    }

    public void setPortfolioReports_btn() {
       portfolioReports_btn.click();
    }

    public void setLoad_btn() {
        load_btn.click();

    }

    public void setExplorer_btn() {
        explorer_btn.click();

    }

    public void setPortfolioLabs_btn() {
        portfolioLabs_btn.click();

    }

    public void setExecutiveReports_btn() {
        executiveReports_btn.click();

    }

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}

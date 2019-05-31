package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viswanath on 26/03/2018.
 */
public class CustomPeerGroup extends EnterpriseBaseClass {


    @BeforeClass
    public void setup() throws IOException {

        GoTo.peerInsights();
        Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_radTabStripPeerGroup\"]/div/ul/li[2]/a/span/span/span", 3);
        Wait.waitForSpinnerToDisappear(Driver,10);

    }

    @Test(priority = 1)
    public void createCustomPeerGroup() throws InterruptedException {


        Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_RadButton1_input\"]", 3);

        WebElement customPIName = Utility.isElementPresent("//*[@id=\"txtCustomPeerGroupName\"]", 3);

        customPIName.sendKeys(Utility.todaysDate("dd/MM/yyyy") + " Custom Automated");

        WebElement customPIDis = Utility.isElementPresent("//*[@id=\"txtCustomPeerGroupDescription\"]", 3);

        customPIDis.sendKeys(Utility.todaysDate("dd/MM/yyyy") + "Custom Automated");

        Utility.isElementPresentAndClick(" //*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_ddlCustomBenchmark_Input\"]", 2);

        Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_ddlCustomBenchmark_DropDown\"]/div[2]/ul/li[2]/div/div[1]", 3);

        Thread.sleep(3000);

        Utility.isElementPresentAndClick("//input[contains(@value,'Save & Select Funds')]", 5);

        Utility.isElementPresentAndClick("//span[@class='slick-column-name']//input[@type='checkbox']", 30);

        Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_cmdAdd_input\"]", 3);

        Thread.sleep(3000);

        Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_cmdRebuid_input\"]", 3);

        Waits.isElementPresent(Driver,"//em[@unselectable='on']",25);

        Wait.waitForSpinnerToDisappear(Driver,60);

        Utility.clickOnConfirmPopup();

        Waits.isElementPresent(Driver,"//span[contains(text(),'Custom Name')]",25);

    }

    @Test(dependsOnMethods = "createCustomPeerGroup",priority = 2)
    public void verifyCustomPeerGroup() {

        SoftAssert softAssert = new SoftAssert();

        String slikGridID = getSlickGridID();

        WebElement provider = Utility.isElementPresent("//div[@id='" + slikGridID + "status']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(provider.getText(), "Status");

        WebElement status = Utility.isElementPresent("//div[@class='slick-cell l7 r7'][contains(text(),'Pending')]", 5);

        softAssert.assertEquals(status.getText(), "Pending");

        softAssert.assertAll();


    }


    public String getSlickGridID()  {

        String slickGridClass = Driver.findElement(By.id("divCustomPeerGroups")).getAttribute("class");  //Find the Slick Grid ID

        String slickGridID = slickGridClass.substring(0, 16);

        return slickGridID;
    }

    @Test(priority = 3)
    public void verifyLabels()  {


        SoftAssert softAssert = new SoftAssert();

        String slikGridID = getSlickGridID();

        WebElement cName = Utility.isElementPresent("//div[@id='" + slikGridID + "name']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(cName.getText(), "Custom Name");

        WebElement provider = Utility.isElementPresent("//div[@id='" + slikGridID + "provider']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(provider.getText(), "Provider");

        WebElement benchmark = Utility.isElementPresent("//div[@id='" + slikGridID + "Benchmark']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(benchmark.getText(), "Benchmark");

        WebElement classification = Utility.isElementPresent("//div[@id='" + slikGridID + "Classification']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(classification.getText(), "Class.");

        WebElement cur = Utility.isElementPresent("//div[@id='" + slikGridID + "CurrencyName']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(cur.getText(), "Curr.");

        WebElement shared = Utility.isElementPresent("//div[@id='" + slikGridID + "isPublic']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(shared.getText(), "Shared");

        WebElement sFunds = Utility.isElementPresent("//div[@id='" + slikGridID + "SelectedFundsCount']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(sFunds.getText(), "Sel. Funds");

        WebElement needsRebuilding = Utility.isElementPresent("//div[@id='" + slikGridID + "IsDirty']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(needsRebuilding.getText(), "Needs Rebuild?");

        WebElement user = Utility.isElementPresent("//div[@id='" + slikGridID + "username']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(user.getText(), "User");

        WebElement modified = Utility.isElementPresent("//div[@id='" + slikGridID + "modified']//span[@class='slick-column-name']", 3);

        softAssert.assertEquals(modified.getText(), "Modified");

        softAssert.assertAll();



    }




    @AfterClass
    public void deleteCustom() throws InterruptedException {

        //Rewrite this to get the list and delete.

        try {
            for (int i = 0; i < 50; i++) {
                Utility.isElementPresentAndClick(" //*[@id=\"divCustomPeerGroups\"]/div[4]/div[3]/div/div[1]/div[13]/a", 3);
                Thread.sleep(3000);
                Utility.clickOnConfirmPopup();
                Thread.sleep(3000);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can't Find Custom Peer Group to Delete");
        }

    }
}

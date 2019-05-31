package com.styleanalytics.enterprise.XML;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XMLLogFileTest {

    XMLReader reader;

    /*  FileName
    File Extension
    Status
    File Content Hash
    File Length
    Portfolio Name
    snapshot date
    number of securities
    Percentage Matched
    Matched Security Count
    Un Matched Security Count
    //Asset Breakdown
    Equity
    Bond
    Cash
    Fund
    Unknown
    Un Matched Securities

*/
    public XMLLogFileTest() {

        reader = new XMLReader("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\test.xml");
    }

    @Test
    public void XSDTest() throws Exception {

        Boolean schema = reader.validateSchema("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\test.xsd");
        if (schema != true) {

            throw new Exception("Schema Validation Failed");
        }
    }

    @Test
    public void fileNameTest() throws Exception {

        String fileName = reader.getTagContent("FileName");
        System.out.println(fileName);
        Assert.assertTrue(fileName.contains("Success"));

    }

    @Test
    public void fileExtensionTest() throws Exception {

        String fileExtension = reader.getTagContent("FileExtension");
        System.out.println(fileExtension);
        Assert.assertTrue(fileExtension.equalsIgnoreCase(".xlsx"));

    }

    @Test
    public void statusTest() throws Exception {

        String status = reader.getTagContent("Status");
        System.out.println(status);
        Assert.assertTrue(status.equalsIgnoreCase("success"));

    }

    @Test
    public void fileContentHash() throws Exception {

        String status = reader.getTagContent("FileContentHash");
        System.out.println(status);

    }

    @Test
    public void fileLengthTest() throws Exception {

        String fileLength = reader.getTagContent("FileLength");
        System.out.println(fileLength);
        //Need to verify the file length

    }

    @Test
    public void portfolioNameTest() throws Exception {

        String pName = reader.getTagContent("Name");
        System.out.println(pName);
        Assert.assertTrue(pName.equalsIgnoreCase("Automation on 181018"));

    }

    @Test
    public void snapshotDateTest() throws Exception {

        String snapDate = reader.getTagContent("SnapshotDate");
        System.out.println(snapDate);
        Assert.assertTrue(snapDate.equalsIgnoreCase("2017-03-31T00:00:00"));

    }

    @Test
    public void numberOfSecuritiesTest() throws Exception {

        String numberOfSecurities = reader.getTagContent("NumberOfSecurities");
        System.out.println(numberOfSecurities);
        Assert.assertTrue(numberOfSecurities.equalsIgnoreCase("234"));

    }

    @Test
    public void percentageMatchedTest() throws Exception {

        String percentMatch = reader.getTagContent("PercentageMatched");
        System.out.println(percentMatch);
        //Need to Verify this
    }
    @Test
    public void matchedSecurityCountTest() throws Exception {

        String matchedSecuritiesCount = reader.getTagContent("MatchedSecuritiesCount");
        System.out.println(matchedSecuritiesCount);
        Assert.assertTrue(matchedSecuritiesCount.equalsIgnoreCase("221"));

    }
    @Test
    public void unmatchedSecurityCountTest() throws Exception {

        String unMatchedSecuritiesCount = reader.getTagContent("UnMatchedSecuritiesCount");
        System.out.println(unMatchedSecuritiesCount);
        Assert.assertTrue(unMatchedSecuritiesCount.equalsIgnoreCase("13"));


    }
    @Test
    public void assetBreakDownEquityTest() throws Exception {

        String equity = reader.getTagContent("Equity");
        System.out.println(equity);
        Assert.assertTrue(equity.equalsIgnoreCase("98.00%"), "Equity % is Incorrect");

    }

    @Test
    public void assetBreakDownBondTest() throws Exception {

        String bond = reader.getTagContent("Bond");
        System.out.println(bond);
        Assert.assertTrue(bond.equalsIgnoreCase("0.00%"), "Bond % is Incorrect");

    }
    @Test
    public void assetBreakDownCashTest() throws Exception {

        String cash = reader.getTagContent("Cash");
        System.out.println(cash);
        Assert.assertTrue(cash.equalsIgnoreCase("2.00%"), "Cash % is Incorrect");

    }
    @Test
    public void assetBreakDownFundTest() throws Exception {

        String fund = reader.getTagContent("Fund");
        System.out.println(fund);
        Assert.assertTrue(fund.equalsIgnoreCase("0.00%"), "Fund % is Incorrect");
    }
    @Test
    public void assetBreakDownUnknownTest() throws Exception {

        String unknown = reader.getTagContent("Unknown");
        System.out.println(unknown);
        Assert.assertTrue(unknown.equalsIgnoreCase("0.00%"), "Unknown % is Incorrect");

    }

    @Test
    public void securityNameTest() throws Exception {

        String securityName = reader.getTagContent("SecurityName");
        System.out.println(securityName);


    }
    @Test
    public void securityCodeTest() throws Exception {

        String securityCode = reader.getTagContent("SecurityCode");
        System.out.println(securityCode);


    }
    @Test
    public void noOfOccurancesTest() throws Exception {

        String noOfOccurances = reader.getTagContent("NoOfOccurances");
        System.out.println(noOfOccurances);


    }
    @Test
    public void activeWeightTest() throws Exception {

        String avgWeight = reader.getTagContent("AvgWeight");
        System.out.println(avgWeight);


    }
    @Test
    public void impactTest() throws Exception {

        String impact = reader.getTagContent("Impact");
        System.out.println(impact);

    }


    /*
    <SecurityName>PACE PLC</SecurityName>
				<SecurityCode>C82688160</SecurityCode>
				<NoOfOccurances>1</NoOfOccurances>
				<AvgWeight>0.25%</AvgWeight>
				<Impact>0.25</Impact>
     */


}









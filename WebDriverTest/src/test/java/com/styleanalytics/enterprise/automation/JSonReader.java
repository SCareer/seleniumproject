package com.styleanalytics.enterprise.automation;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.setup.TestBase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class JSonReader extends TestBase {

    private Object object;
    private File jsonFile;
    private JSONParser jsonParser;
    private Xls_Reader reader;
    String path = property("jsonDownloadPath");

    public JSonReader(File jsonFile) throws IOException, ParseException {

        this.jsonFile = jsonFile;
        jsonParser = new JSONParser();
        object = jsonParser.parse(new FileReader(jsonFile));

    }


    public String readStringJSonObject(String parentObject, String childObject1, String childObject2) {

        JSONObject jsonObject = (JSONObject) object;

        JSONObject pObj = (JSONObject) jsonObject.get(parentObject);
        JSONObject cObj = (JSONObject) pObj.get(childObject1);

        String value = cObj.get(childObject2).toString();

        return value;
    }

    public String readStringJSonObject(String parentObject, String childObject1) {

        JSONObject jsonObject = (JSONObject) object;

        JSONObject pObj = (JSONObject) jsonObject.get(parentObject);


        String value = pObj.get(childObject1).toString();

        return value;
    }

    public String readStringJSonObject(String parentObject) {

        JSONObject jsonObject = (JSONObject) object;

        String value = String.valueOf(jsonObject.get(parentObject));

        return value;
    }

    public Double readDoubleJSonObject(String parentObject, String childObject1, String childObject2) {

        JSONObject jsonObject = (JSONObject) object;

        JSONObject pObj = (JSONObject) jsonObject.get(parentObject);
        JSONObject cObj = (JSONObject) pObj.get(childObject1);

        Double value = Double.valueOf(cObj.get(childObject2).toString());

        return value;
    }

    public Double readDoubleJSonObject(String parentObject, String childObject1) {

        JSONObject jsonObject = (JSONObject) object;

        JSONObject pObj = (JSONObject) jsonObject.get(parentObject);

        Double value = Double.valueOf(pObj.get(childObject1).toString());

        return value;
    }

    public Double readDoubleJSonObject(String parentObject) {

        JSONObject jsonObject = (JSONObject) object;

        Long val = (Long) jsonObject.get(parentObject);

        Double value = Double.valueOf(val);

        return value;
    }


    public void readArrayJSonObject1(String arrayObject1, String arrayObject2, String arrayObject3, String sheetName, String[] colName,String excelTestResultFile) {

       // Xls_Reader reader = new Xls_Reader("C:\\Selenium\\Build Outputs\\Json Expected\\Excel Worksheet.xlsx");
        reader = new Xls_Reader(path+excelTestResultFile);

        JSONObject jsonObject = (JSONObject) object;
        JSONArray arrayObject = (JSONArray) jsonObject.get(arrayObject1);


        for (int i = 0; i < arrayObject.size(); i++) {

            if (arrayObject.size() > 1) {
                if (i == 0) {
                    continue;
                }
            }

            JSONObject jsonObject1 = (JSONObject) arrayObject.get(i);
            JSONArray pObj = (JSONArray) jsonObject1.get(arrayObject2);


            for (int j = 0; j < pObj.size(); j++) {

                JSONObject jsonObject2 = (JSONObject) pObj.get(j);
                JSONArray pObj1 = (JSONArray) jsonObject2.get(arrayObject3);

                for (int k = 0; k < pObj1.size(); k++) {

                    System.out.println(pObj1.get(k));

                    if (pObj1.get(k) instanceof Long) {
                        Long longValue = ((Long) pObj1.get(k));
                        reader.setCellData(sheetName, colName[j], k + 2, longValue);

                    } else if (pObj1.get(k) instanceof String) {
                        String a = (String) pObj.get(j);
                        reader.setCellData(sheetName, colName[j], k + 2, a);

                    } else {
                        double sValue = (double) pObj1.get(k);
                        reader.setCellData(sheetName, colName[j], k + 2, sValue);

                    }

                }
            }

        }
    }

    public void readArrayJSonObject2(String arrayObject1, String jObject1, String arrayObject2, String sheetName, String colName,String excelTestResultFile) {

       // Xls_Reader reader = new Xls_Reader("C:\\Selenium\\Build Outputs\\Json Expected\\Excel Worksheet.xlsx");
        reader = new Xls_Reader(path+excelTestResultFile);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray arrayObject = (JSONArray) jsonObject.get(arrayObject1);


        for (int i = 0; i < arrayObject.size(); i++) {

            if (arrayObject.size() > 1) {
                if (i == 0) {
                    continue;
                }
            }
            JSONObject jsonObject1 = (JSONObject) arrayObject.get(i);
            JSONObject jsonObject3 = (JSONObject) jsonObject1.get(jObject1);
            JSONArray pObj = (JSONArray) jsonObject3.get(arrayObject2);


            for (int j = 0; j < pObj.size(); j++) {

                System.out.println(pObj.get(j));
                String a = (String) pObj.get(j);
                reader.setCellData(sheetName,colName,j+2,a);
            }

        }
    }

}










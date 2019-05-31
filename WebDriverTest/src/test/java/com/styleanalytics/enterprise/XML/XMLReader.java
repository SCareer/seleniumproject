package com.styleanalytics.enterprise.XML;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

    private File xmlFile;

    public XMLReader(String file) {

        this.xmlFile = new File(file);

    }

    public Document parse() throws IOException, SAXException, ParserConfigurationException {


        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();

        return document;
    }

    public String getTagContent(String tagName) throws Exception {


        Document document = parse();

        System.out.println("Root element :" + document.getDocumentElement().getNodeName());

        String value = document.getDocumentElement().getElementsByTagName(tagName).item(0).getTextContent();

        return value;


    }

    //Need to refactor this
    public void getElementFromList(String listTagName,String tagName) throws Exception {

        Document document =  parse();

        System.out.println("Root element :" + document.getDocumentElement().getNodeName());
        System.out.println("----------------------------");

        NodeList list = document.getElementsByTagName(listTagName);

        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);

            System.out.println("\nCurrent Element :" + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                System.out.println("ID: " + element.getElementsByTagName(tagName).item(0).getTextContent());

            }
        }

    }

    public boolean validateSchema(String xsd) throws SAXException, IOException {

        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(new File(xsd));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(String.valueOf(this.xmlFile))));

        }catch (SAXException e){

            System.out.println("Exception:"+e);

            return false;
        }

        return  true;
    }
}


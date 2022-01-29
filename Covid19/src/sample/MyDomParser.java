package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MyDomParser {
    @FXML
    protected  TextField urlTextField;

    @FXML
    protected void onGetDataClicked(ActionEvent event) throws ParserConfigurationException {
        String url =urlTextField.getText();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try {
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nodeList=doc.getElementsByTagName("record");
            System.out.println("\n");

            for (int temp=0; temp<nodeList.getLength();temp++){
                Node node=nodeList.item(temp);
                System.out.println("\nCurrent Element:" +node.getNodeName());
                if (node.getNodeType()==node.ELEMENT_NODE){
                    Element element=(Element)node;

                    System.out.println("dateRep : " + element.getElementsByTagName("dateRep").item(0).getTextContent());
                    System.out.println("day : " + element.getElementsByTagName("day").item(0).getTextContent());
                    System.out.println("month : " + element.getElementsByTagName("month").item(0).getTextContent());
                    System.out.println("year : " + element.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println("cases : " + element.getElementsByTagName("cases").item(0).getTextContent());
                    System.out.println("deaths : " + element.getElementsByTagName("deaths").item(0).getTextContent());
                    System.out.println("countriesAndTerritories : " + element.getElementsByTagName("countriesAndTerritories").item(0).getTextContent());
                    System.out.println("geoId : " + element.getElementsByTagName("geoId").item(0).getTextContent());
                    System.out.println("countryterritoryCode : " + element.getElementsByTagName("countryterritoryCode").item(0).getTextContent());
                    System.out.println("popData2018 : " + element.getElementsByTagName("popData2018").item(0).getTextContent());
                    System.out.println("continentExp : " + element.getElementsByTagName("continentExp").item(0).getTextContent());

                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

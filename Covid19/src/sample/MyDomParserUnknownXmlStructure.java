package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyDomParserUnknownXmlStructure {
    @FXML
    public TextField urlTextField;
    @FXML
    public void onGetDataClicked(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        String url =urlTextField.getText();
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(url);
        document.getDocumentElement().normalize();
        Element root=document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nodeList=document.getElementsByTagName("record");
        System.out.println("----------------");
        visitChildNode(nodeList);

    }

    private void visitChildNode(NodeList nodeList) {
        for (int temp=0;temp<nodeList.getLength();temp++){
            Node node=nodeList.item(temp);
            if (node.getNodeType()==node.ELEMENT_NODE){
                System.out.println("Node name= "+node.getNodeName()+";Value= "+node.getTextContent());
                if(node.hasAttributes()){
                    NamedNodeMap nodeMap=node.getAttributes();
                    for (int i=0;i<nodeMap.getLength();i++){
                        Node tempNode=nodeMap.item(i);
                        System.out.println("Attribute name: "+tempNode.getNodeName()+":Value= "+tempNode.getNodeValue());
                    }
                    if(node.hasChildNodes()) {
                        visitChildNode(node.getChildNodes());
                    }
                }
            }
        }
    }


}

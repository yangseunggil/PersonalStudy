package site.messageParser;

import java.io.FileReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MessageParser {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		   try{
			
			   InputSource   inputSource = new InputSource(new FileReader("resources/message_description.xml"));
			   Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
			   
			    // xpath 생성
			   XPath  xPath = XPathFactory.newInstance().newXPath();
			   
//			   String expression = "//*/type";
//			   NodeList  nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			   
//			   System.out.println(nodeList.item(0).getAttributes().item(0).getTextContent());
//			   for( int idx=0; idx < nodeList.getLength(); idx++ ){
//				   String ssn=nodeList.item(idx).getAttributes().item(0).getTextContent();
//				   System.out.println("attr................"+ssn);
//				   
//				   expression = "//*[@attr="+ssn+"]/item";
//				   String firstName = xPath.compile(expression).evaluate(document);
//				   System.out.println("firstName................"+firstName);
//				   
//				   expression = "//*[@ssn="+ssn+"]/lastName";
//				   String lastName = xPath.compile(expression).evaluate(document);
//				   System.out.println("lastName................"+lastName);
//				   expression = "//*[@attr="+nodeList.item(idx).getAttributes().item(0).getTextContent()+"]/item";
//				   System.out.println(expression);
//				   System.out.println(xPath.compile(expression).evaluate(document));
//			   }
			   
			   
			   
			   
			   String expression = "//*/person";
			   NodeList  cols = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			   
						
			   for( int idx=0; idx<cols.getLength(); idx++ ){
				   
				   String attr=cols.item(idx).getAttributes().item(0).getTextContent();
				   System.out.println("attr................"+attr);
				   
				   expression = "//*[@attr="+attr+"]/firstName";
				   String firstName = xPath.compile(expression).evaluate(document);
				   System.out.println("firstName................"+firstName);
				   
				   expression = "//*[@attr="+attr+"]/lastName";
				   String lastName = xPath.compile(expression).evaluate(document);
				   System.out.println("lastName................"+lastName);
				  
			   }
	 		
		   }catch(Exception e){
			   e.printStackTrace();
		   }

	}

}

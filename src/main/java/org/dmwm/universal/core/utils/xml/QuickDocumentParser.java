package org.dmwm.universal.core.utils.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class QuickDocumentParser {
	public static Document parseFromString(String xml){
		Document doc = null;
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(new InputSource(new StringReader(xml)));
		doc.getDocumentElement().normalize();
		} catch(ParserConfigurationException | IOException | SAXException e){
			e.printStackTrace();
		}
		return doc;
	}
//	@Deprecated
	public static String getByTag(Element element, String tag){
		return element.getElementsByTagName(tag).item(0).getTextContent();
	}
	
//	public static Function<String, String> getByTagL(Element element, String tag){
//		return (element, tag) -> element.getElementsByTagName(tag).item(0).getTextContent();
//	}
	
}

package org.dmwm.universal.core.utils.xml;

import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.InputSource;

public class JQuickDocumentParser {

	public static Document parseFromString(String xml) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		return builder.build(new InputSource(new StringReader(xml)));
	}
	
	public static String getByTag(Element baseElement, String tag){
		return baseElement.getDescendants(new ElementFilter(tag)).next().getText();
	}
	
	public static void setTagValue(Element baseElement, String tag, String value){
		baseElement.getDescendants(new ElementFilter(tag)).next().setText(new String(value));
	}
	
	public static String doc2string(Document doc){
		return new XMLOutputter().outputString(doc);
	}
	
	public static Element mergeDocs(Element sourceDoc, Element targetEntry){
		return targetEntry.addContent(sourceDoc);
	}
	
}

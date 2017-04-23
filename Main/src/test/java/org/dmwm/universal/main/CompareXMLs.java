package org.dmwm.universal.main;

import java.io.IOException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

public class CompareXMLs extends XMLTestCase{

	private final String required, actual;

	private String [] excludeTags;
	
	public CompareXMLs(String required, String actual, boolean runImmediate, String ... excludeTags) throws IOException, SAXException {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		this.required = required;
		this.actual = actual;
		this.excludeTags = excludeTags;
		if(runImmediate) isEqual();
	}
	
	public void isEqual() throws IOException, SAXException{
		assertXMLEqual(xmlDiff(required, actual, excludeTags), true);
	}
	
	private Diff xmlDiff(String required, String actual, String ... excludeTags) throws IOException, SAXException{
		Diff d = new Diff(required, actual);
		d.overrideDifferenceListener(new IgnoreNamedElementsDifferenceListener(excludeTags));	
		return d;
	}
}

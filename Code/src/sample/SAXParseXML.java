package sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParseXML extends DefaultHandler {
    private Component component;

    private String tagName;

    public void startDocument() throws SAXException {
        this.component = new Component();
    }

    public void endDocument() throws SAXException {
        System.out.println("解析结束");
    }

    public Component getComponent() {
        return this.component;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.tagName = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.tagName = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if (this.tagName != null)
            if (this.tagName.equals("type")) {
                this.component.setType(data);
            } else if (this.tagName.equals("num")) {
                this.component.setNum(data);
            } else if (this.tagName.equals("footprint")) {
                this.component.setFootprint(data);
            } else if (this.tagName.equals("location")) {
                this.component.setLocation(data);
            }
    }
}
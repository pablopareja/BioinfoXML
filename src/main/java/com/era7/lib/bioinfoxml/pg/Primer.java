package com.era7.lib.bioinfoxml.pg;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

public class Primer extends XMLElement {

    public static final String TAG_NAME = "primer";
    public static final String SEQUENCE_TAG_NAME = "sequence";
    public static final String SEQUENCE_COMPLEMENTARY_INVERTED_TAG_NAME = "sequence_complementary_inverted";
    public static final String LENGTH_TAG_NAME = "length";

    public Primer() {
        super(new Element(TAG_NAME));

    }

    public Primer(Element elem) throws XMLElementException {
        super(elem);
        if (!elem.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(elem));
        }
    }

    public Primer(String value) throws Exception {
        super(value);
        if (!root.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(value));
        }
    }

//----------------GETTERS-------------------
    public String getSequenceComplementaryInverted() {
        return getNodeText(SEQUENCE_COMPLEMENTARY_INVERTED_TAG_NAME);
    }

    public String getSequence() {
        return getNodeText(SEQUENCE_TAG_NAME);
    }

    public int getLength() {
        return Integer.parseInt(getNodeText(LENGTH_TAG_NAME));
    }

//----------------SETTERS-------------------
    public void setSequenceComplementaryInverted(String value) {
        setNodeText(SEQUENCE_COMPLEMENTARY_INVERTED_TAG_NAME, value);
    }

    public void setSequence(String value) {
        setNodeText(SEQUENCE_TAG_NAME, value);
    }

    public void setLength(int value) {
        setNodeText(LENGTH_TAG_NAME, String.valueOf(value));
    }
}

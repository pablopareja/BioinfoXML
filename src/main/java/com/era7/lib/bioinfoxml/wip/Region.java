/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.wip;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class Region extends XMLElement {

    public static final String TAG_NAME = "region";

    public static final String ID_TAG_NAME = "id";
    public static final String END_TAG_NAME = "end";
    public static final String BEGIN_TAG_NAME = "begin";
    public static final String SEQUENCE_TAG_NAME = "sequence";
    public static final String TYPE_TAG_NAME = "type";
    public static final String UNIPROT_ID_TAG_NAME = "uniprot_id";

    public Region() {
        super(new Element(TAG_NAME));
    }

    public Region(Element elem) throws XMLElementException {
        super(elem);
        if (!elem.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(elem));
        }
    }

    public Region(String value) throws Exception {
        super(value);
        if (!root.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(value));
        }
    }


    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public String getSequence( ){  return getNodeText(SEQUENCE_TAG_NAME);}
    public String getType( ){  return getNodeText(TYPE_TAG_NAME);}
    public String getUniprotId( ){  return getNodeText(UNIPROT_ID_TAG_NAME);}
    public int getBegin( ){  return Integer.parseInt(getNodeText(BEGIN_TAG_NAME));}
    public int getEnd(){    return Integer.parseInt(getNodeText(END_TAG_NAME));}

    //----------------SETTERS---------------------
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setSequence(String value){  setNodeText(SEQUENCE_TAG_NAME, value);}
    public void setType(String value){  setNodeText(TYPE_TAG_NAME, value);}
    public void setUniprotId(String value){  setNodeText(UNIPROT_ID_TAG_NAME, value);}
    public void setBegin(int value){    setNodeText(BEGIN_TAG_NAME, String.valueOf(value));}
    public void setEnd(int value){    setNodeText(END_TAG_NAME, String.valueOf(value));}


}

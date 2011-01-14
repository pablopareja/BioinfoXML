/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class Codon extends XMLElement{

    public static final String TAG_NAME = "codon";   

    public static final String START_CODON_TYPE = "start";
    public static final String STOP_CODON_TYPE = "stop";

    public static final String TYPE_TAG_NAME = "type";
    public static final String POSITION_TAG_NAME = "position";
    public static final String IS_CANONICAL_TAG_NAME = "is_canonical";
    public static final String SEQUENCE_TAG_NAME = "sequence";

    public Codon(){
        super(new Element(TAG_NAME));
    }
    public Codon(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Codon(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------GETTERS---------------------
    public String getType(){       return getNodeText(TYPE_TAG_NAME);  }
    public int getPosition(){   return Integer.parseInt(getNodeText(POSITION_TAG_NAME));}
    public boolean getIsCanonical(){    return Boolean.valueOf(getNodeText(IS_CANONICAL_TAG_NAME));}
    public String getSequence(){    return getNodeText(SEQUENCE_TAG_NAME);}

    //----------------SETTERS---------------------
    public void setType(String type){    setNodeText(TYPE_TAG_NAME, type);}
    public void setPosition(int pos){   setNodeText(POSITION_TAG_NAME, String.valueOf(pos));}
    public void setIsCanonical(boolean value){  setNodeText(IS_CANONICAL_TAG_NAME, String.valueOf(value));}
    public void setSequence(String value){  setNodeText(SEQUENCE_TAG_NAME, value);}

    

}

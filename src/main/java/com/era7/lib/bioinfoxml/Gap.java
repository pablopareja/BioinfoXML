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
public class Gap extends XMLElement{

    public static final String TAG_NAME = "gap";

    public static final String START_POSITION_TAG_NAME = "start_position";
    public static final String END_POSITION_TAG_NAME = "end_position";

    public Gap(){
        super(new Element(TAG_NAME));
    }
    public Gap(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Gap(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------GETTERS---------------------
    public int getStartPosition( ){  return Integer.parseInt(getNodeText(START_POSITION_TAG_NAME));}
    public int getEndPosition( ){  return Integer.parseInt(getNodeText(END_POSITION_TAG_NAME));}
    //----------------SETTERS---------------------
    public void setStartPosition(int value){  setNodeText(START_POSITION_TAG_NAME, String.valueOf(value));}
    public void setEndPosition(int value){  setNodeText(END_POSITION_TAG_NAME, String.valueOf(value));}

}
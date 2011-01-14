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
public class Frameshift extends XMLElement{

    public static final String TAG_NAME = "frameshift";

    public static final String POSITION_TAG_NAME = "position";
    public static final String READING_FRAME_FROM_TAG_NAME = "reading_frame_from";
    public static final String READING_FRAME_TO_TAG_NAME = "reading_frame_to";

     public Frameshift(){
        super(new Element(TAG_NAME));
    }
    public Frameshift(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Frameshift(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------GETTERS---------------------
    public int getPosition(){  return Integer.parseInt(getNodeText(POSITION_TAG_NAME)); }
    public int getReadingFrameFrom(){  return Integer.parseInt(getNodeText(READING_FRAME_FROM_TAG_NAME)); }
    public int getReadingFrameTo(){  return Integer.parseInt(getNodeText(READING_FRAME_TO_TAG_NAME)); }

    //----------------SETTERS---------------------
    public void setPosition(int value){    setNodeText(POSITION_TAG_NAME,String.valueOf(value));}
    public void setReadingFrameFrom(int value){    setNodeText(READING_FRAME_FROM_TAG_NAME,String.valueOf(value));}
    public void setReadingFrameTo(int value){    setNodeText(READING_FRAME_TO_TAG_NAME,String.valueOf(value));}

}

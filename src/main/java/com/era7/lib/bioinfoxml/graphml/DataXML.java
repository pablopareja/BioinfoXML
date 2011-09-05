/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.graphml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class DataXML extends XMLElement{

    public static final String TAG_NAME = "data";

    public static final String KEY_ATTRIBUTE = "key";

    public DataXML(){
        super(new Element(TAG_NAME));
    }
    public DataXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public DataXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setKey(String value){
        this.root.setAttribute(KEY_ATTRIBUTE, value);
    }    

    //----------------GETTERS-------------------
    public String getKey(){
        return this.root.getAttributeValue(KEY_ATTRIBUTE);
    }

}

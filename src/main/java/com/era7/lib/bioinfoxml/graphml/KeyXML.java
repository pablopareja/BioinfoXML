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
public class KeyXML extends XMLElement{
    
    public static final String EDGE = "edge";
    public static final String NODE = "node";

    public static final String TAG_NAME = "edge";

    public static final String ID_ATTRIBUTE = "id";
    public static final String FOR_ATTRIBUTE = "for";
    public static final String ATTR_NAME_ATTRIBUTE = "attr.name";
    public static final String ATTR_TYPE_ATTRIBUTE = "attr.type";

    public KeyXML(){
        super(new Element(TAG_NAME));
    }
    public KeyXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public KeyXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    public void setFor(String value){
        this.root.setAttribute(FOR_ATTRIBUTE, value);
    }
    public void setAttrName(String value){
        this.root.setAttribute(ATTR_NAME_ATTRIBUTE, value);
    }
    public void setAttrType(String value){
        this.root.setAttribute(ATTR_TYPE_ATTRIBUTE, value);
    }

    //----------------GETTERS-------------------
    public String getId(){
        return this.root.getAttributeValue(ID_ATTRIBUTE);
    }
    public String getFor(){
        return this.root.getAttributeValue(FOR_ATTRIBUTE);
    }
    public String getAttrName(){
        return this.root.getAttributeValue(ATTR_NAME_ATTRIBUTE);
    }
    public String getAttrType(){
        return this.root.getAttributeValue(ATTR_TYPE_ATTRIBUTE);
    }
    

}

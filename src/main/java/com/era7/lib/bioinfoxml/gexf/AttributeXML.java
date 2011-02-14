/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.gexf;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class AttributeXML extends XMLElement{

    public static final String TAG_NAME = "attribute";

    public static final String ID_ATTRIBUTE = "id";
    public static final String TITLE_ATTRIBUTE = "title";
    public static final String TYPE_ATTRIBUTE = "type";

    public AttributeXML(){
        super(new Element(TAG_NAME));
    }
    public AttributeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public AttributeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    public void setTitle(String value){
        this.root.setAttribute(TITLE_ATTRIBUTE, value);
    }
    public void setType(String value){
        this.root.setAttribute(TYPE_ATTRIBUTE, value);
    }
}

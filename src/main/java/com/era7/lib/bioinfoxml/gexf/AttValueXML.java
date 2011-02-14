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
public class AttValueXML extends XMLElement{

    public static final String TAG_NAME = "attvalue";

    public static final String FOR_ATTRIBUTE = "for";
    public static final String VALUE_ATTRIBUTE = "value";

    public AttValueXML(){
        super(new Element(TAG_NAME));
    }
    public AttValueXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public AttValueXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setFor(int value){
        this.root.setAttribute(FOR_ATTRIBUTE, String.valueOf(value));
    }
    public void setValue(String value){
        this.root.setAttribute(VALUE_ATTRIBUTE, value);
    }

}

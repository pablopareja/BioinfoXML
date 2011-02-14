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
public class AttributesXML extends XMLElement{

    public static final String TAG_NAME = "attributes";

    public static final String CLASS_ATTRIBUTE = "class";

    public static final String NODE_CLASS = "node";

    public AttributesXML(){
        super(new Element(TAG_NAME));
    }
    public AttributesXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public AttributesXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setClass(String value){
        this.root.setAttribute(CLASS_ATTRIBUTE, value);
    }

    public void addAttribute(AttributeXML attributeXML){
        this.root.addContent(attributeXML.asJDomElement());
    }

}

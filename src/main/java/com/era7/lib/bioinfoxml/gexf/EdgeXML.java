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
public class EdgeXML extends XMLElement{

    public static final String TAG_NAME = "edge";

    public static final String ID_ATTRIBUTE = "id";
    public static final String SOURCE_ATTRIBUTE = "source";
    public static final String TARGET_ATTRIBUTE = "target";
    public static final String TYPE_ATTRIBUTE = "type";

    public static final String DIRECTED_TYPE = "directed";

    public EdgeXML(){
        super(new Element(TAG_NAME));
    }
    public EdgeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public EdgeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    public void setSource(String value){
        this.root.setAttribute(SOURCE_ATTRIBUTE, value);
    }
    public void setTarget(String value){
        this.root.setAttribute(TARGET_ATTRIBUTE, value);
    }
    public void setType(String value){
        this.root.setAttribute(TYPE_ATTRIBUTE,value);
    }

    public void setAttvalues(AttValuesXML attValuesXML){
        this.root.removeChildren(AttValuesXML.TAG_NAME);
        this.root.addContent(attValuesXML.asJDomElement());
    }

}

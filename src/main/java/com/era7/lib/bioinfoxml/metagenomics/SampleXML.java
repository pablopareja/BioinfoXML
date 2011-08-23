/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.metagenomics;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class SampleXML extends XMLElement{
    
    public static final String TAG_NAME = "sample";   

    public static final String NAME_TAG_NAME = "name";
    
    public SampleXML(){
        super(new Element(TAG_NAME));
    }
    public SampleXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public SampleXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    //----------------GETTERS---------------------
    public String getStampleName(){       return getNodeText(NAME_TAG_NAME);  }

    //----------------SETTERS---------------------
    public void setSampleName(String type){    setNodeText(NAME_TAG_NAME, type);}
    
}

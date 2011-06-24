/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.uniprot;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class InterproXML extends XMLElement{
    
    
    public static final String TAG_NAME = "interpro";
    
    public static final String ID_TAG_NAME = "id";
    public static final String NAME_TAG_NAME = "name";
    
    
    public InterproXML(){
        super(new Element(TAG_NAME));
    }
    public InterproXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public InterproXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    
    //----------------SETTERS-------------------
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setInterproName(String value){   setNodeText(NAME_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public String getInterproName() {    return getNodeText(NAME_TAG_NAME);    }
    
}

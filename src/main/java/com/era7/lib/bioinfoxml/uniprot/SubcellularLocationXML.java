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
public class SubcellularLocationXML extends XMLElement{
    
    
    public static final String TAG_NAME = "subcellular_location";
    
    public static final String NAME_TAG_NAME = "name";
    
    
    public SubcellularLocationXML(){
        super(new Element(TAG_NAME));
    }
    public SubcellularLocationXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public SubcellularLocationXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    
    //----------------SETTERS-------------------
    public void setSubcellularLocationName(String value){   setNodeText(NAME_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getSubcellularLocationName() {    return getNodeText(NAME_TAG_NAME);    }
    
}

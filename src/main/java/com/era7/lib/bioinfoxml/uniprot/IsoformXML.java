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
public class IsoformXML extends XMLElement{
        
    public static final String TAG_NAME = "isoform";
    
    public static final String ID_TAG_NAME = "id";
    public static final String NAME_TAG_NAME = "name";
    public static final String NOTE_TAG_NAME = "note";
    public static final String SEQUENCE_TAG_NAME = "sequence";
    
    
    public IsoformXML(){
        super(new Element(TAG_NAME));
    }
    public IsoformXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public IsoformXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------SETTERS-------------------
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setIsoformName(String value){  setNodeText(NAME_TAG_NAME, value);}
    public void setNote(String value){  setNodeText(NOTE_TAG_NAME, value);}
    public void setSequence(String value){  setNodeText(SEQUENCE_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public String getIsoformName( ){  return getNodeText(NAME_TAG_NAME);}
    public String getNote( ){  return getNodeText(NOTE_TAG_NAME);}
    public String getSequence( ){  return getNodeText(SEQUENCE_TAG_NAME);}
}

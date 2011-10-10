/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.bio4j;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class Bio4jRelationshipIndexXML extends XMLElement{
    
    public static final String TAG_NAME = "relationship_index";
    
    public static final String NAME_TAG_NAME = "name";
    public static final String RELATIONSHIP_NAME_TAG_NAME = "relationship_name";
    public static final String ITEM_TYPE_TAG_NAME = "item_type";
    
    public static final String RELATIONSHIP_INDEX_ITEM_TYPE = "relationship_index";
    
    public Bio4jRelationshipIndexXML(){
        super(new Element(TAG_NAME));
    }
    public Bio4jRelationshipIndexXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Bio4jRelationshipIndexXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    //----------------GETTERS---------------------
    public String getRelationshipName( ){  return getNodeText(RELATIONSHIP_NAME_TAG_NAME);}
    public String getIndexName( ){  return getNodeText(NAME_TAG_NAME);}
    public String getItemType(){    return getNodeText(ITEM_TYPE_TAG_NAME);}
    
    
    //----------------SETTERS-------------------
    public void setRelationshipName(String value){  setNodeText(RELATIONSHIP_NAME_TAG_NAME, value);}
    public void setIndexName(String value){  setNodeText(NAME_TAG_NAME, value);}
    public void setItemType(String value){  setNodeText(ITEM_TYPE_TAG_NAME, value);}
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.bio4j;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class Bio4jNodeXML extends XMLElement{
    
    public static final String TAG_NAME = "node";
    
    public static final String DESCRIPTION_TAG_NAME = "description";
    public static final String NAME_TAG_NAME = "name";
    public static final String ITEM_TYPE_TAG_NAME = "item_type";
    public static final String INCOMING_RELATIONSHIPS_TAG_NAME = "in_rels";
    public static final String OUTGOING_RELATIONSHIPS_TAG_NAME = "out_rels";
    public static final String JAVADOC_URL_TAG_NAME = "javadoc_url";
    
    public static final String NODE_ITEM_TYPE = "node";
    
    public Bio4jNodeXML(){
        super(new Element(TAG_NAME));
    }
    public Bio4jNodeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Bio4jNodeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    //----------------GETTERS---------------------
    public String getDescription( ){  return getNodeText(DESCRIPTION_TAG_NAME);}
    public String getNodeName( ){  return getNodeText(NAME_TAG_NAME);}
    public String getItemType(){    return getNodeText(ITEM_TYPE_TAG_NAME);}
    public String getJavadocUrl(){    return getNodeText(JAVADOC_URL_TAG_NAME);}
    
    public List<Bio4jRelationshipXML> getIncomingRelationships() throws XMLElementException{
        LinkedList<Bio4jRelationshipXML> list = new LinkedList<Bio4jRelationshipXML>();
        Element elem = root.getChild(INCOMING_RELATIONSHIPS_TAG_NAME);
        if(elem != null){
            for (Object e : elem.getChildren(Bio4jRelationshipXML.TAG_NAME)) {
                list.add(new Bio4jRelationshipXML((Element)e));
            }            
        }
        return list;
    }
    public List<Bio4jRelationshipXML> getOutgoingRelationships() throws XMLElementException{
        LinkedList<Bio4jRelationshipXML> list = new LinkedList<Bio4jRelationshipXML>();
        Element elem = root.getChild(OUTGOING_RELATIONSHIPS_TAG_NAME);
        if(elem != null){
            for (Object e : elem.getChildren(Bio4jRelationshipXML.TAG_NAME)) {
                list.add(new Bio4jRelationshipXML((Element)e));
            }            
        }
        return list;
    }
    
    //----------------SETTERS-------------------
    public void setDescription(String value){  setNodeText(DESCRIPTION_TAG_NAME, value);}
    public void setNodeName(String value){  setNodeText(NAME_TAG_NAME, value);}
    public void setItemType(String value){  setNodeText(ITEM_TYPE_TAG_NAME, value);}
    public void setJavadocUrl(String value){    setNodeText(JAVADOC_URL_TAG_NAME, value);}
    
    public void addIncomingRelationship(Bio4jRelationshipXML rel){
        Element elem = initIncomingRelationshipsTag();
        elem.addContent(rel.getRoot());                
    }
    public void addOutgoingRelationship(Bio4jRelationshipXML rel){
        Element elem = initOutgoingRelationshipsTag();
        elem.addContent(rel.getRoot());                
    }
    
    private Element initIncomingRelationshipsTag(){
        Element elem = root.getChild(INCOMING_RELATIONSHIPS_TAG_NAME);
        if(elem == null){
            elem = new Element(INCOMING_RELATIONSHIPS_TAG_NAME);
            root.addContent(elem);
        }
        return elem;
    }
    private Element initOutgoingRelationshipsTag(){
        Element elem = root.getChild(OUTGOING_RELATIONSHIPS_TAG_NAME);
        if(elem == null){
            elem = new Element(OUTGOING_RELATIONSHIPS_TAG_NAME);
            root.addContent(elem);
        }
        return elem;
    }
}

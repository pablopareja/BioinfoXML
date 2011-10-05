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
public class Bio4jRelationshipXML extends XMLElement{
    
    public static final String TAG_NAME = "relationship";
    
    public static final String NAME_TAG_NAME = "name";
    public static final String ITEM_TYPE_TAG_NAME = "item_type";
    public static final String DESCRIPTION_TAG_NAME = "description";
    public static final String START_NODES_TAG_NAME = "start_nodes";
    public static final String END_NODES_TAG_NAME = "end_nodes";
    public static final String JAVADOC_URL_TAG_NAME = "javadoc_url";
    
    public static final String RELATIONSHIP_ITEM_TYPE = "relationship";
    
    public Bio4jRelationshipXML(){
        super(new Element(TAG_NAME));
    }
    public Bio4jRelationshipXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Bio4jRelationshipXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    //----------------GETTERS---------------------
    public String getDescription( ){  return getNodeText(DESCRIPTION_TAG_NAME);}
    public String getItemType(){    return getNodeText(ITEM_TYPE_TAG_NAME);}
    public String getRelationshipName( ){  return getNodeText(NAME_TAG_NAME);}
    public String getJavadocUrl(){    return getNodeText(JAVADOC_URL_TAG_NAME);}
    
    public List<Bio4jNodeXML> getStartNodes() throws XMLElementException{
        LinkedList<Bio4jNodeXML> list = new LinkedList<Bio4jNodeXML>();
        Element elem = root.getChild(START_NODES_TAG_NAME);
        if(elem != null){
            for (Object e : elem.getChildren(Bio4jNodeXML.TAG_NAME)) {
                list.add(new Bio4jNodeXML((Element)e));
            }            
        }
        return list;
    }
    public List<Bio4jNodeXML> getEndNodes() throws XMLElementException{
        LinkedList<Bio4jNodeXML> list = new LinkedList<Bio4jNodeXML>();
        Element elem = root.getChild(END_NODES_TAG_NAME);
        if(elem != null){
            for (Object e : elem.getChildren(Bio4jNodeXML.TAG_NAME)) {
                list.add(new Bio4jNodeXML((Element)e));
            }            
        }
        return list;
    }
    
    //----------------SETTERS-------------------
    public void setDescription(String value){  setNodeText(DESCRIPTION_TAG_NAME, value);}
    public void setRelationshipName(String value){  setNodeText(NAME_TAG_NAME, value);}
    public void setItemType(String value){  setNodeText(ITEM_TYPE_TAG_NAME, value);}
    public void setJavadocUrl(String value){    setNodeText(JAVADOC_URL_TAG_NAME, value);}
    
    public void addStartNode(Bio4jNodeXML node){
        Element elem = initStartNodesTag();
        elem.addContent(node.getRoot());                
    }
    public void addEndNode(Bio4jNodeXML node){
        Element elem = initEndNodesTag();
        elem.addContent(node.getRoot());                
    }
    
    private Element initStartNodesTag(){
        Element elem = root.getChild(START_NODES_TAG_NAME);
        if(elem == null){
            elem = new Element(START_NODES_TAG_NAME);
            root.addContent(elem);
        }
        return elem;
    }
    private Element initEndNodesTag(){
        Element elem = root.getChild(END_NODES_TAG_NAME);
        if(elem == null){
            elem = new Element(END_NODES_TAG_NAME);
            root.addContent(elem);
        }
        return elem;
    }
    
}

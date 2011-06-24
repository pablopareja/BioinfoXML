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
public class CommentXML extends XMLElement{
        
    public static final String TAG_NAME = "comment";
    
    public static final String TYPE_TAG_NAME = "type";
    public static final String TEXT_TAG_NAME = "text";
    
    
    public CommentXML(){
        super(new Element(TAG_NAME));
    }
    public CommentXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public CommentXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------SETTERS-------------------
    public void setType(String value){  setNodeText(TYPE_TAG_NAME, value);}
    public void setCommentText(String value){   setNodeText(TEXT_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getType( ){  return getNodeText(TYPE_TAG_NAME);}
    public String getCommentText() {    return getNodeText(TEXT_TAG_NAME);    }
}

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
public class ArticleXML extends XMLElement{
        
    public static final String TAG_NAME = "article";
    
    public static final String TITLE_TAG_NAME = "title";
    public static final String MEDLINE_TAG_NAME = "medline_id";
    
    
    public ArticleXML(){
        super(new Element(TAG_NAME));
    }
    public ArticleXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public ArticleXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------SETTERS-------------------
    public void setTitle(String value){  setNodeText(TITLE_TAG_NAME, value);}
    public void setMedlineId(String value){   setNodeText(MEDLINE_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getTitle( ){  return getNodeText(TITLE_TAG_NAME);}
    public String getMedlineId() {    return getNodeText(MEDLINE_TAG_NAME);    }
}

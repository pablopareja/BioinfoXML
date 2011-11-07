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
public class FeatureXML extends XMLElement{
        
    public static final String TAG_NAME = "feature";
    
    public static final String TYPE_TAG_NAME = "type";
    public static final String ID_TAG_NAME = "id";
    public static final String DESCRIPTION_TAG_NAME = "description";
    public static final String STATUS_TAG_NAME = "status";
    public static final String EVIDENCE_TAG_NAME = "evidence";
    public static final String BEGIN_TAG_NAME = "begin";
    public static final String END_TAG_NAME = "end";
    public static final String ORIGINAL_TAG_NAME = "original";
    public static final String VARIATION_TAG_NAME = "variation";
    public static final String REF_TAG_NAME = "ref";
    
    
    public FeatureXML(){
        super(new Element(TAG_NAME));
    }
    public FeatureXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public FeatureXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------SETTERS-------------------
    public void setType(String value){  setNodeText(TYPE_TAG_NAME, value);}
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setStatus(String value){  setNodeText(STATUS_TAG_NAME, value);}
    public void setEvidence(String value){  setNodeText(EVIDENCE_TAG_NAME, value);}
    public void setBegin(int value){  setNodeText(BEGIN_TAG_NAME, String.valueOf(value));}
    public void setEnd(int value){  setNodeText(END_TAG_NAME, String.valueOf(value));}
    public void setDescription(String value){   setNodeText(DESCRIPTION_TAG_NAME, value);}
    public void setOriginal(String value){   setNodeText(ORIGINAL_TAG_NAME, value);}
    public void setVariation(String value){   setNodeText(VARIATION_TAG_NAME, value);}
    public void setRef(String value){   setNodeText(REF_TAG_NAME, value);}
    
    //----------------GETTERS---------------------
    public String getType( ){  return getNodeText(TYPE_TAG_NAME);}
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public String getStatus( ){  return getNodeText(STATUS_TAG_NAME);}
    public String getEvidence( ){  return getNodeText(EVIDENCE_TAG_NAME);}
    public int getBegin( ){  return Integer.parseInt(getNodeText(BEGIN_TAG_NAME));}
    public int getEnd( ){  return Integer.parseInt(getNodeText(END_TAG_NAME));}
    public String getDescription() {    return getNodeText(DESCRIPTION_TAG_NAME);    }
    public String getOriginal() {    return getNodeText(ORIGINAL_TAG_NAME);    }
    public String getVariation() {    return getNodeText(VARIATION_TAG_NAME);    }
    public String getRef() {    return getNodeText(REF_TAG_NAME);    }
    
}

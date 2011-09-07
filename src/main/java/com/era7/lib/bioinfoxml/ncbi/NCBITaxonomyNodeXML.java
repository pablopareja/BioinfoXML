/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.ncbi;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class NCBITaxonomyNodeXML extends XMLElement{
    
    public static final String TAG_NAME = "ncbi_taxonomy_node";
    
    public static final String TAX_ID_TAG_NAME = "tax_id";
    public static final String PARENT_TAX_ID_TAG_NAME = "parent_tax_id";
    public static final String SCIENTIFIC_NAME_TAG_NAME = "scientific_name";
    public static final String RANK_TAG_NAME = "rank";
    public static final String EMBL_CODE_TAG_NAME = "embl_code";
    public static final String COMMENTS_TAG_NAME = "comments";
    public static final String ABSOLUTE_FREQUENCY_TAG_NAME = "absolute_frequency";
    public static final String ACCUMULATED_ABSOLUTE_FREQUENCY_TAG_NAME = "accumulated_absolute_frequency";
    
    public NCBITaxonomyNodeXML(){
        super(new Element(TAG_NAME));
    }
    public NCBITaxonomyNodeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public NCBITaxonomyNodeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
        
    //----------------GETTERS---------------------
    public int getTaxId( ){  return Integer.parseInt(getNodeText(TAX_ID_TAG_NAME));}
    public String getParentTaxId( ){  return getNodeText(PARENT_TAX_ID_TAG_NAME);}
    public String getRank(){    return getNodeText(RANK_TAG_NAME);}
    public String getEmblCode(){    return getNodeText(EMBL_CODE_TAG_NAME);}
    public String getComments(){    return getNodeText(COMMENTS_TAG_NAME);}
    public String getScientificName(){    return getNodeText(SCIENTIFIC_NAME_TAG_NAME);}
    public int getAbsoluteFrequency(){  return Integer.parseInt(getNodeText(ABSOLUTE_FREQUENCY_TAG_NAME));}
    public int getAccumulatedAbsoluteFrequency(){   return Integer.parseInt(getNodeText(ACCUMULATED_ABSOLUTE_FREQUENCY_TAG_NAME));}
    
    //----------------SETTERS-------------------
    public void setTaxId(int value){  setNodeText(TAX_ID_TAG_NAME, String.valueOf(value));}
    public void setParentTaxId(String value){  setNodeText(PARENT_TAX_ID_TAG_NAME, value);}
    public void setRank(String value){  setNodeText(RANK_TAG_NAME, value);}
    public void setEmblCode(String value){  setNodeText(EMBL_CODE_TAG_NAME, value);}
    public void setComments(String value){  setNodeText(COMMENTS_TAG_NAME, value);}
    public void setScientificName(String value){  setNodeText(SCIENTIFIC_NAME_TAG_NAME, value);}
    public void setAbsoluteFrequency(int value){  setNodeText(ABSOLUTE_FREQUENCY_TAG_NAME, String.valueOf(value));}
    public void setAccumulatedAbsoluteFrequency(int value){  setNodeText(ACCUMULATED_ABSOLUTE_FREQUENCY_TAG_NAME, String.valueOf(value));}
    
    
}

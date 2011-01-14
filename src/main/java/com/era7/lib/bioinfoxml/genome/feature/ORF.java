/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.genome.feature;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class ORF extends Feature{

    public static final String TAG_NAME = "orf";

    public static final String SYNONYM_TAG_NAME = "synonym";
    public static final String GENE_TAG_NAME = "gene";

    public ORF() throws XMLElementException{
        super(new Element(TAG_NAME));
    }
    public ORF(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public ORF(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //-----------------------GETTERS------------------------
    public String getSynonym(){ return getNodeText(SYNONYM_TAG_NAME);}
    public String getGene(){    return getNodeText(GENE_TAG_NAME);}

    //-----------------------SETTERS------------------------
    public void setSynonym(String value){   setNodeText(SYNONYM_TAG_NAME, value);}
    public void setGene(String value){  setNodeText(GENE_TAG_NAME,value);}

}

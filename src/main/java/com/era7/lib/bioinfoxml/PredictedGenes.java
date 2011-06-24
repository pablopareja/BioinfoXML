/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class PredictedGenes extends XMLElement{

    public static final String TAG_NAME = "predicted_genes";
    
    public static final String DIF_SPAN_TAG_NAME = "difspan";
    public static final String GENE_THRESHOLD_TAG_NAME = "gene_threshold";
    public static final String PREFERENT_ORGANISM = "preferent_organism";


    public PredictedGenes(){
        super(new Element(TAG_NAME));
    }
    public PredictedGenes(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public PredictedGenes(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setDifSpan(int value){  setNodeText(DIF_SPAN_TAG_NAME, String.valueOf(value));}
    public void setGeneThreshold(int value){  setNodeText(GENE_THRESHOLD_TAG_NAME, String.valueOf(value));}
    public void setPreferentOrganism(String value){ setNodeText(PREFERENT_ORGANISM, value);}
    

    //----------------GETTERS---------------------
    public int getDifSpan( ){  return Integer.parseInt(getNodeText(DIF_SPAN_TAG_NAME));}
    public int getGeneThreshold( ){  return Integer.parseInt(getNodeText(GENE_THRESHOLD_TAG_NAME));}
    public String getPreferentOrganism(){   return getNodeText(PREFERENT_ORGANISM);}
    
    
    public List<ContigXML> getContigs() throws XMLElementException{
        List<ContigXML> list = new ArrayList<ContigXML>();
        
        List<Element> contigs = root.getChildren(ContigXML.TAG_NAME);
        for (Element element : contigs) {
            list.add(new ContigXML(element));
        }
        
        return list;
    }
}

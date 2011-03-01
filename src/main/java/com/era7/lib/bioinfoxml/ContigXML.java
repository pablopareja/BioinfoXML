/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class ContigXML extends XMLElement{

    public static final String TAG_NAME = "contig";

    public static final String ID_TAG_NAME = "id";
    public static final String LENGTH_TAG_NAME = "length";
    public static final String BEGIN_TAG_NAME = "begin";
    public static final String END_TAG_NAME = "end";
    public static final String SEQUENCE_TAG_NAME = "sequence";
    public static final String GAPS_PERCENTAGE_TAG_NAME = "gaps_percentage";
    public static final String ORGANISM_TAG_NAME = "organism";
    public static final String ORGANISM_COMPLETE_TAXONOMY_LINEAGE = "organism_complete_taxonomy_lineage";

    public ContigXML(){
        super(new Element(TAG_NAME));
    }
    public ContigXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public ContigXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    public void addPredictedGene(PredictedGene gene){
        root.addContent(gene.asJDomElement());
    }
    public void addPredictedRna(PredictedRna rna){
        root.addContent(rna.asJDomElement());
    }

    public void addGap(Gap gap){
        root.addContent(gap.asJDomElement());
    }

    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public int getLength(){ return Integer.parseInt(getNodeText(LENGTH_TAG_NAME));}
    public int getBegin(){  return Integer.parseInt(getNodeText(BEGIN_TAG_NAME));}
    public int getEnd(){    return Integer.parseInt(getNodeText(END_TAG_NAME));}
    public String getSequence(){    return getNodeText(SEQUENCE_TAG_NAME);}
    public String getOrganism(){    return getNodeText(ORGANISM_TAG_NAME);}
    public String getOrganismCompleteTaxonomyLineage(){ return getNodeText(ORGANISM_COMPLETE_TAXONOMY_LINEAGE);}
    public double getGapsPercentage(){  return Double.parseDouble(getNodeText(GAPS_PERCENTAGE_TAG_NAME));}

    //----------------SETTERS-------------------
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setLength(int value){    setNodeText(LENGTH_TAG_NAME, String.valueOf(value));}
    public void setBegin(int value){    setNodeText(BEGIN_TAG_NAME, String.valueOf(value));}
    public void setEnd(int value){    setNodeText(END_TAG_NAME, String.valueOf(value));}
    public void setSequence(String value){  setNodeText(SEQUENCE_TAG_NAME,value);}
    public void setOrganism(String value){  setNodeText(ORGANISM_TAG_NAME, value);}
    public void setOrganismCompleteTaxonomyLineage(String value){   setNodeText(ORGANISM_COMPLETE_TAXONOMY_LINEAGE, value);}
    public void setGapsPercentage(double value){    setNodeText(GAPS_PERCENTAGE_TAG_NAME, String.valueOf(value));}


}

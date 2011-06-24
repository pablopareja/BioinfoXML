package com.era7.lib.bioinfoxml.embl;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

public class EmblXML extends XMLElement {

    public static final String TAG_NAME = "embl_xml";
    public static final String STRAIN_TAG_NAME = "strain";
    public static final String ID_TAG_NAME = "id";
    public static final String MOL_TYPE_TAG_NAME = "mol_type";
    public static final String DEFINITION_TAG_NAME = "definition";
    public static final String ORGANISM_TAG_NAME = "organism";
    public static final String ORGANISM_COMPLETE_TAXONOMY_LINEAGE_TAG_NAME = "organism_complete_taxonomy_lineage";
    public static final String LOCUS_TAG_PREFIX_TAG_NAME = "locus_tag_prefix";

    public EmblXML() {
        super(new Element(TAG_NAME));

    }

    public EmblXML(Element elem) throws XMLElementException {
        super(elem);
        if (!elem.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(elem));
        }
    }

    public EmblXML(String value) throws Exception {
        super(value);
        if (!root.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(value));
        }
    }

    //----------------GETTERS-------------------
        

    public String getDefinition() {
        return getNodeText(DEFINITION_TAG_NAME);
    }
    
    public String getLocusTagPrefix(){
        return getNodeText(LOCUS_TAG_PREFIX_TAG_NAME);
    }

    public String getOrganismCompleteTaxonomyLineage() {
        return getNodeText(ORGANISM_COMPLETE_TAXONOMY_LINEAGE_TAG_NAME);
    }

    public String getMolType() {
        return getNodeText(MOL_TYPE_TAG_NAME);
    }

    public String getOrganism() {
        return getNodeText(ORGANISM_TAG_NAME);
    }

    public String getStrain() {
        return getNodeText(STRAIN_TAG_NAME);
    }
    
    public String getId(){
        return getNodeText(ID_TAG_NAME);
    }

    //----------------SETTERS-------------------
 
    public void setDefinition(String value) {
        setNodeText(DEFINITION_TAG_NAME, value);
    }
    
    public void setLocusTagPrefix(String value){
        setNodeText(LOCUS_TAG_PREFIX_TAG_NAME, value);
    }
    
    public void setId(String value){
        setNodeText(ID_TAG_NAME, value);
    }

    public void setOrganismCompleteTaxonomyLineage(String value) {
        setNodeText(ORGANISM_COMPLETE_TAXONOMY_LINEAGE_TAG_NAME, value);
    }
    
    public void setMolType(String value) {
        setNodeText(MOL_TYPE_TAG_NAME, value);
    }

    public void setOrganism(String value) {
        setNodeText(ORGANISM_TAG_NAME, value);
    }

    public void setStrain(String value) {
        setNodeText(STRAIN_TAG_NAME, value);
    }
}

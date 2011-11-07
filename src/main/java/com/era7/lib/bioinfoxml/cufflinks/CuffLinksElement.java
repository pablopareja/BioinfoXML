/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.lib.bioinfoxml.cufflinks;

import com.era7.lib.bioinfoxml.uniprot.ProteinXML;
import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class CuffLinksElement extends XMLElement{
        
    public static final String TAG_NAME = "cufflinks_element";
    
    public static final String ID_TAG_NAME = "id";
    public static final String GENE_NAME_TAG_NAME = "gene_name";
    
    
    public CuffLinksElement(){
        super(new Element(TAG_NAME));
    }
    public CuffLinksElement(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public CuffLinksElement(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    
    //----------------SETTERS-------------------
    public void setId(String value) {        setNodeText(ID_TAG_NAME, value);    }
    public void setGeneName(String value) {        setNodeText(GENE_NAME_TAG_NAME, value);    }
    
    //----------------GETTERS---------------------
    public String getId() {        return getNodeText(ID_TAG_NAME);    }
    public String getGeneName() {        return getNodeText(GENE_NAME_TAG_NAME);    }
    
    public void addProtein(ProteinXML proteinXML){
        root.addContent(proteinXML.asJDomElement());
    }
}

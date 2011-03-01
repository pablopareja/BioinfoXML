/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.bioinfoxml.go.GoTermXML;
import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;

/**
 *
 * @author Pablo Pareja Tobes
 */
public class ProteinXML extends XMLElement{

    public static final String TAG_NAME = "protein";

    public static final String ID_TAG_NAME = "id";
    public static final String DB_TAG_NAME = "db";
    public static final String SPLICE_TAG_NAME = "splice";
    public static final String SYMBOL_TAG_NAME = "symbol";
    public static final String TAXON_TAG_NAME = "taxon";
    public static final String QUALIFIER_TAG_NAME = "qualifier";
    public static final String LENGTH_TAG_NAME = "length";

    public static final String PROTEIN_COVERAGE_ABSOLUTE = "protein_coverage_absolute";
    public static final String PROTEIN_COVERAGE_PERCENTAGE = "protein_coverage_percentage";

    public static final String GO_TERMS_TAG_NAME = "go_terms";
    public static final String PROCESS_GO_TERMS_TAG_NAME = "biological_process";
    public static final String FUNCTION_GO_TERMS_TAG_NAME = "molecular_function";
    public static final String COMPONENT_GO_TERMS_TAG_NAME = "cellular_component";



    public ProteinXML(){
        super(new Element(TAG_NAME));
    }
    public ProteinXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public ProteinXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){  setNodeText(ID_TAG_NAME, value);}
    public void setLength(int value){    setNodeText(LENGTH_TAG_NAME, String.valueOf(value));}
    public void setProteinCoverageAbsolute(int value){  setNodeText(PROTEIN_COVERAGE_ABSOLUTE, String.valueOf(value));}
    public void setProteinCoveragePercentage(double value){  setNodeText(PROTEIN_COVERAGE_PERCENTAGE, String.valueOf(value));}
    public void setSplice(String value){    setNodeText(SPLICE_TAG_NAME, value);}
    public void setDb(String value){   setNodeText(DB_TAG_NAME, value);}
    public void setSymbol(String value){ setNodeText(SYMBOL_TAG_NAME, value);}
    public void setTaxon(String value){    setNodeText(TAXON_TAG_NAME, value);}
    public void setQualifier(String value){    setNodeText(QUALIFIER_TAG_NAME, value);}

    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public int getLength(){ return Integer.parseInt(getNodeText(LENGTH_TAG_NAME));}
    public int getProteinCoverageAbsolute(){ return Integer.parseInt(getNodeText(PROTEIN_COVERAGE_ABSOLUTE));}
    public double getProteinCoveragePercentage(){   return Double.parseDouble(getNodeText(PROTEIN_COVERAGE_PERCENTAGE));}
    public String getSplice( ){  return getNodeText(SPLICE_TAG_NAME);}
    public String getDb( ){   return getNodeText(DB_TAG_NAME);}
    public String getSymbol( ){ return getNodeText(SYMBOL_TAG_NAME);}
    public String getTaxon( ){    return getNodeText(TAXON_TAG_NAME);}
    public String getQualifier( ){    return getNodeText(QUALIFIER_TAG_NAME);}

    public List<GoTermXML> getMolecularFunctionGoTerms(){
        Element goTerms = root.getChild(GO_TERMS_TAG_NAME);
        if(goTerms != null){
            Element molFunc = goTerms.getChild(FUNCTION_GO_TERMS_TAG_NAME);
            if(molFunc != null){
                List<Element> gos = molFunc.getChildren(GoTermXML.TAG_NAME);
                ArrayList<GoTermXML> result = new ArrayList<GoTermXML>();
                for (Element elem : gos) {
                    result.add(new GoTermXML(elem));
                }
                return result;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<GoTermXML> getBiologicalProcessGoTerms(){
        Element goTerms = root.getChild(GO_TERMS_TAG_NAME);
        if(goTerms != null){
            Element bioProc = goTerms.getChild(PROCESS_GO_TERMS_TAG_NAME);
            if(bioProc != null){
                List<Element> gos = bioProc.getChildren(GoTermXML.TAG_NAME);
                ArrayList<GoTermXML> result = new ArrayList<GoTermXML>();
                for (Element elem : gos) {
                    result.add(new GoTermXML(elem));
                }
                return result;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public List<GoTermXML> getCellularComponentGoTerms(){
        Element goTerms = root.getChild(GO_TERMS_TAG_NAME);
        if(goTerms != null){
            Element cellComp = goTerms.getChild(COMPONENT_GO_TERMS_TAG_NAME);
            if(cellComp != null){
                List<Element> gos = cellComp.getChildren(GoTermXML.TAG_NAME);
                ArrayList<GoTermXML> result = new ArrayList<GoTermXML>();
                for (Element elem : gos) {
                    result.add(new GoTermXML(elem));
                }
                return result;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }


    public void addGoTerm(GoTermXML term, boolean basedOnAspect){
        initGoTermsTag();
        if(basedOnAspect){
            if(term.getAspect().equals(GoTermXML.ASPECT_COMPONENT)){
                initComponentTag();
                root.getChild(GO_TERMS_TAG_NAME).getChild(COMPONENT_GO_TERMS_TAG_NAME).addContent(term.asJDomElement());
            }else if(term.getAspect().equals(GoTermXML.ASPECT_FUNCTION)){
                initFunctionTag();
                root.getChild(GO_TERMS_TAG_NAME).getChild(FUNCTION_GO_TERMS_TAG_NAME).addContent(term.asJDomElement());
            }else if(term.getAspect().equals(GoTermXML.ASPECT_PROCESS)){
                initProcessTag();
                root.getChild(GO_TERMS_TAG_NAME).getChild(PROCESS_GO_TERMS_TAG_NAME).addContent(term.asJDomElement());
            }
        }else{
            root.getChild(GO_TERMS_TAG_NAME).addContent(term.asJDomElement());
        }
        
    }

    public void clasifyGoTermsByAspect() throws JDOMException{
        initComponentTag();
        initFunctionTag();
        initProcessTag();

        if(doc == null){
            doc = root.getDocument();
        }

        List processGoTerms = XPath.selectNodes(doc, "//protein[id/text()='"+getId()+"']//"+GoTermXML.TAG_NAME+"["+GoTermXML.ASPECT_TAG_NAME+"/text()='"+GoTermXML.ASPECT_PROCESS+"']");
        List functionGoTerms = XPath.selectNodes(doc, "//protein[id/text()='"+getId()+"']//"+GoTermXML.TAG_NAME+"["+GoTermXML.ASPECT_TAG_NAME+"/text()='"+GoTermXML.ASPECT_FUNCTION+"']");
        List componentGoTerms = XPath.selectNodes(doc, "//protein[id/text()='"+getId()+"']//"+GoTermXML.TAG_NAME+"["+GoTermXML.ASPECT_TAG_NAME+"/text()='"+GoTermXML.ASPECT_COMPONENT+"']");

        for(Object processGo : processGoTerms){
            Element tempElem = (Element) processGo;
            tempElem.detach();
            this.addGoTerm(new GoTermXML(tempElem), true);
        }
        for(Object componentGo : componentGoTerms){
            Element tempElem = (Element) componentGo;
            tempElem.detach();
            this.addGoTerm(new GoTermXML(tempElem), true);
        }
        for(Object functionGo : functionGoTerms){
            Element tempElem = (Element) functionGo;
            tempElem.detach();
            this.addGoTerm(new GoTermXML(tempElem), true);
        }

    }

    private void initGoTermsTag(){
        Element goTerms = root.getChild(GO_TERMS_TAG_NAME);
        if(goTerms == null){
            root.addContent(new Element(GO_TERMS_TAG_NAME));
        }
    }
    private void initComponentTag(){
        initGoTermsTag();
        Element temp = root.getChild(GO_TERMS_TAG_NAME).getChild(COMPONENT_GO_TERMS_TAG_NAME);
        if(temp == null){
            root.getChild(GO_TERMS_TAG_NAME).addContent(new Element(COMPONENT_GO_TERMS_TAG_NAME));
        }
    }
    private void initFunctionTag(){
        initGoTermsTag();
        Element temp = root.getChild(GO_TERMS_TAG_NAME).getChild(FUNCTION_GO_TERMS_TAG_NAME);
        if(temp == null){
            root.getChild(GO_TERMS_TAG_NAME).addContent(new Element(FUNCTION_GO_TERMS_TAG_NAME));
        }
    }
    private void initProcessTag(){
        initGoTermsTag();
        Element temp = root.getChild(GO_TERMS_TAG_NAME).getChild(PROCESS_GO_TERMS_TAG_NAME);
        if(temp == null){
            root.getChild(GO_TERMS_TAG_NAME).addContent(new Element(PROCESS_GO_TERMS_TAG_NAME));
        }
    }

}

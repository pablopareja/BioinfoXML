/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.uniprot;

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
    public static final String NAME_TAG_NAME = "name";
    public static final String FULL_NAME_TAG_NAME = "full_name";
    public static final String SHORT_NAME_TAG_NAME = "short_name";
    public static final String SEQUENCE_TAG_NAME = "sequence";    
    public static final String LENGTH_TAG_NAME = "length";
    
    public static final String ORGANISM_TAG_NAME = "organism";
    
    public static final String KEYWORDS_TAG_NAME = "keywords";
    public static final String INTERPROS_TAG_NAME = "interpros";
    public static final String COMMENTS_TAG_NAME = "comments";
    public static final String SUBCELLULAR_LOCATIONS_TAG_NAME = "subcellular_locations";
    
    public static final String PROTEIN_PROTEIN_OUTGOING_INTERACTIONS_TAG_NAME = "protein_protein_outgoing_interactions";
    public static final String PROTEIN_PROTEIN_INCOMING_INTERACTIONS_TAG_NAME = "protein_protein_incoming_interactions";
    public static final String PROTEIN_ISOFORM_OUTGOING_INTERACTIONS_TAG_NAME = "protein_isoform_outgoing_interactions";
    public static final String PROTEIN_ISOFORM_INCOMING_INTERACTIONS_TAG_NAME = "protein_isoform_incoming_interactions";
    
    
    public static final String PROTEIN_COVERAGE_ABSOLUTE = "protein_coverage_absolute";
    public static final String PROTEIN_COVERAGE_PERCENTAGE = "protein_coverage_percentage";
    public static final String NUMBER_OF_ISOTIGS = "number_of_isotigs";

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
    public void setNumberOfIsotigs(int value){  setNodeText(NUMBER_OF_ISOTIGS, String.valueOf(value));}
    public void setProteinName(String value){   setNodeText(NAME_TAG_NAME, value);}
    public void setFullName(String value){  setNodeText(FULL_NAME_TAG_NAME, value);}
    public void setShortName(String value){ setNodeText(SHORT_NAME_TAG_NAME, value);}
    public void setSequence(String value){  setNodeText(SEQUENCE_TAG_NAME,value);}
    public void setOrganism(String value){  setNodeText(ORGANISM_TAG_NAME, value);}

    //----------------GETTERS---------------------
    public String getId( ){  return getNodeText(ID_TAG_NAME);}
    public int getLength(){ return Integer.parseInt(getNodeText(LENGTH_TAG_NAME));}
    public int getProteinCoverageAbsolute(){ return Integer.parseInt(getNodeText(PROTEIN_COVERAGE_ABSOLUTE));}
    public double getProteinCoveragePercentage(){   return Double.parseDouble(getNodeText(PROTEIN_COVERAGE_PERCENTAGE));}
    public int getNumberOfIsotigs(){ return Integer.parseInt(getNodeText(NUMBER_OF_ISOTIGS));}
    public String getProteinName() {    return getNodeText(NAME_TAG_NAME);    }
    public String getFullName(){     return getNodeText(FULL_NAME_TAG_NAME);   }
    public String getShortName(){     return getNodeText(SHORT_NAME_TAG_NAME);   }
    public String getSequence(){    return getNodeText(SEQUENCE_TAG_NAME);}
    public String getOrganism(){    return getNodeText(ORGANISM_TAG_NAME);}

    
    public void addKeyword(KeywordXML keyword){
        initKeywordsTag();
        root.getChild(KEYWORDS_TAG_NAME).addContent(keyword.asJDomElement());
    }
    public void addInterpro(InterproXML interpro){
        initInterprosTag();
        root.getChild(INTERPROS_TAG_NAME).addContent(interpro.asJDomElement());
    }
    public void addComment(CommentXML comment){
        initCommentsTag();
        root.getChild(COMMENTS_TAG_NAME).addContent(comment.asJDomElement());
    }
    public void addProteinProteinOutgoingInteraction(ProteinXML prot){
        initProteinProteinOutgoingInteractionsTag();
        root.getChild(PROTEIN_PROTEIN_OUTGOING_INTERACTIONS_TAG_NAME).addContent(prot.asJDomElement());
    }
    public void addProteinProteinIncomingInteraction(ProteinXML prot){
        initProteinProteinIncomingInteractionsTag();
        root.getChild(PROTEIN_PROTEIN_INCOMING_INTERACTIONS_TAG_NAME).addContent(prot.asJDomElement());
    }
    
    public void addProteinIsoformOutgoingInteraction(IsoformXML iso){
        initProteinIsoformOutgoingInteractionsTag();
        root.getChild(PROTEIN_ISOFORM_OUTGOING_INTERACTIONS_TAG_NAME).addContent(iso.asJDomElement());
    }
    public void addProteinIsoformIncomingInteraction(IsoformXML iso){
        initProteinIsoformIncomingInteractionsTag();
        root.getChild(PROTEIN_ISOFORM_INCOMING_INTERACTIONS_TAG_NAME).addContent(iso.asJDomElement());
    }
    public void addSubcellularLocation(SubcellularLocationXML subCell){
        initSubcellularLocationsTag();
        root.getChild(SUBCELLULAR_LOCATIONS_TAG_NAME).addContent(subCell.asJDomElement());
    }
    
    public List<KeywordXML> getKeywords() throws XMLElementException{
        List<KeywordXML> list = new ArrayList<KeywordXML>();
        Element keywords = root.getChild(KEYWORDS_TAG_NAME);
        
        List<Element> elemList = keywords.getChildren(KeywordXML.TAG_NAME);
        for (Element elem : elemList) {
            list.add(new KeywordXML(elem));
        }       
        
        return list;
    }
    
    
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
    
    private void initKeywordsTag(){
        Element temp = root.getChild(KEYWORDS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(KEYWORDS_TAG_NAME));
        }
    }
    private void initInterprosTag(){
        Element temp = root.getChild(INTERPROS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(INTERPROS_TAG_NAME));
        }
    }
    private void initCommentsTag(){
        Element temp = root.getChild(COMMENTS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(COMMENTS_TAG_NAME));
        }
    }
    private void initProteinProteinOutgoingInteractionsTag(){
        Element temp = root.getChild(PROTEIN_PROTEIN_OUTGOING_INTERACTIONS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(PROTEIN_PROTEIN_OUTGOING_INTERACTIONS_TAG_NAME));
        }
    }
    private void initProteinProteinIncomingInteractionsTag(){
        Element temp = root.getChild(PROTEIN_PROTEIN_INCOMING_INTERACTIONS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(PROTEIN_PROTEIN_INCOMING_INTERACTIONS_TAG_NAME));
        }
    }
    private void initProteinIsoformOutgoingInteractionsTag(){
        Element temp = root.getChild(PROTEIN_ISOFORM_OUTGOING_INTERACTIONS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(PROTEIN_ISOFORM_OUTGOING_INTERACTIONS_TAG_NAME));
        }
    }
    private void initProteinIsoformIncomingInteractionsTag(){
        Element temp = root.getChild(PROTEIN_ISOFORM_INCOMING_INTERACTIONS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(PROTEIN_ISOFORM_INCOMING_INTERACTIONS_TAG_NAME));
        }
    }
    private void initSubcellularLocationsTag(){
        Element temp = root.getChild(SUBCELLULAR_LOCATIONS_TAG_NAME);
        if(temp == null){
            root.addContent(new Element(SUBCELLULAR_LOCATIONS_TAG_NAME));
        }
    }

}

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
public class Iteration extends XMLElement {

    public static final String TAG_NAME = "Iteration";
    public static final String ITERATION_HITS_TAG_NAME = "Iteration_hits";
    public static final String ITERATION_QUERY_DEF_TAG_NAME = "Iteration_query-def";
    public static final String ITERATION_QUERY_LEN_TAG_NAME = "Iteration_query-len";
    public static final String ITERATION_QUERY_ID_TAG_NAME = "Iteration_query-ID";

    public Iteration() {
        super(new Element(TAG_NAME));
    }

    public Iteration(Element elem) throws XMLElementException {
        super(elem);
        if (!elem.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(elem));
        }
    }

    public Iteration(String value) throws Exception {
        super(value);
        if (!root.getName().equals(TAG_NAME)) {
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME, new XMLElement(value));
        }
    }

    //----------------GETTERS---------------------
    public String getQueryDef() {        return getNodeText(ITERATION_QUERY_DEF_TAG_NAME);    }
    public String getQueryLen(){    return getNodeText(ITERATION_QUERY_LEN_TAG_NAME);}
    public String getQueryId(){ return getNodeText(ITERATION_QUERY_ID_TAG_NAME);}

    //----------------SETTERS---------------------
    public void setQueryDef(String value){  setNodeText(ITERATION_QUERY_DEF_TAG_NAME, value);}
    public void setQueryLen(String value){  setNodeText(ITERATION_QUERY_LEN_TAG_NAME, value);}
    public void setQueryId(String value){  setNodeText(ITERATION_QUERY_ID_TAG_NAME, value);}



    public String getUniprotIdFromQueryDef() {
        String text = getNodeText(ITERATION_QUERY_DEF_TAG_NAME);
        if (text != null) {
            return text.split("\\|")[1].trim();
        } else {
            return null;
        }

    }

    public ArrayList<Hit> getIterationHits() throws XMLElementException {
        ArrayList<Hit> array = new ArrayList<Hit>();

        Element itHits = root.getChild(ITERATION_HITS_TAG_NAME);
        if (itHits != null) {
            List<Element> tempList = itHits.getChildren();
            for (Element elem : tempList) {
                array.add(new Hit(elem));
            }
        }

        return array;

    }
}

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
public class PredictedRnas extends XMLElement{

    public static final String TAG_NAME = "predicted_rnas";


    public PredictedRnas(){
        super(new Element(TAG_NAME));
    }
    public PredictedRnas(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public PredictedRnas(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }
    
    public List<ContigXML> getContigs() throws XMLElementException{
        List<ContigXML> list = new ArrayList<ContigXML>();
        
        List<Element> contigs = root.getChildren(ContigXML.TAG_NAME);
        for (Element element : contigs) {
            list.add(new ContigXML(element));
        }
        
        return list;
    }

    
}

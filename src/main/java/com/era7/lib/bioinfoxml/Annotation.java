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
public class Annotation extends XMLElement{

    public static final String TAG_NAME = "annotation";


    public Annotation(){
        super(new Element(TAG_NAME));
    }
    public Annotation(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Annotation(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    public void setPredictedGenes(PredictedGenes value){
        root.removeChildren(PredictedGenes.TAG_NAME);
        root.addContent(value.asJDomElement());
    }

    public void setPredictedRnas(PredictedRnas value){
        root.removeChildren(PredictedRnas.TAG_NAME);
        root.addContent(value.asJDomElement());
    }


}

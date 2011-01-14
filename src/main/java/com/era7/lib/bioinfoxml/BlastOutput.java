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
public class BlastOutput extends XMLElement{

    public static final String TAG_NAME = "BlastOutput";

    public static final String BLAST_OUTPUT_ITERATIONS_TAG_NAME = "BlastOutput_iterations";

    public BlastOutput(){
        super(new Element(TAG_NAME));
    }
    public BlastOutput(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public BlastOutput(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    

    //----------------GETTERS---------------------
    public ArrayList<Iteration> getBlastOutputIterations( ) throws XMLElementException{
        ArrayList<Iteration> array = new ArrayList<Iteration>();
        List<Element> tempList = root.getChild(BLAST_OUTPUT_ITERATIONS_TAG_NAME).getChildren();
        for(Element elem : tempList){
            array.add(new Iteration(elem));
        }
        return array;

    }

}

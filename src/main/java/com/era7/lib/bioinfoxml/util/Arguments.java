/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.util;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class Arguments extends XMLElement{

    public static final String TAG_NAME = "arguments";

    public Arguments(){
        super(new Element(TAG_NAME));
    }
    public Arguments(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Arguments(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    public void addArgument(Argument arg){
        addChild(arg);
    }

    //----------------GETTERS---------------------
    public int getSize(){   return root.getChildren(Argument.TAG_NAME).size();}

    //----------------SETTERS---------------------
}


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
public class Execution extends XMLElement{

    public static final String TAG_NAME = "execution";

    public static final String CLASS_FULL_NAME_TAG_NAME = "class_full_name";

    public Execution(){
        super(new Element(TAG_NAME));
    }
    public Execution(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Execution(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    

    //----------------GETTERS---------------------
    public String getClassFullName(){   return getNodeText(CLASS_FULL_NAME_TAG_NAME);}

    public Arguments getArguments() throws XMLElementException{
        Arguments args = null;
        Element elem = root.getChild(Arguments.TAG_NAME);
        if(elem != null){
            args = new Arguments(elem);
        }
        return args;
    }


    //----------------SETTERS---------------------
    public void setClassFullName(String value){ setNodeText(CLASS_FULL_NAME_TAG_NAME, value);}
    
    public void setArguments(Arguments args){
        root.removeChildren(Argument.TAG_NAME);
        addChild(args);
    }
}


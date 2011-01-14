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
public class XMLWrapperClass extends XMLElement{

    public static final String TAG_NAME = "XMLWrapperClass";

    public static final String NAME_TAG_NAME = "name";
    public static final String PACKAGE_TAG_NAME = "package";
    public static final String VARS_TAG_NAME = "vars";
    public static final String TAG_NAME_TAG_NAME = "tag_name";

    public XMLWrapperClass(){
        super(new Element(TAG_NAME));
    }
    public XMLWrapperClass(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public XMLWrapperClass(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------GETTERS---------------------
    public String getClassName(){       return getNodeText(NAME_TAG_NAME);  }
    public String getTagName(){       return getNodeText(TAG_NAME_TAG_NAME);  }
    public String getPackage(){       return getNodeText(PACKAGE_TAG_NAME);  }
    public Element getVars(){   return root.getChild(VARS_TAG_NAME);}

    //----------------SETTERS---------------------
    public void setClassName(String s){    setNodeText(NAME_TAG_NAME, s);}
    public void setTagName(String s){   setNodeText(TAG_NAME_TAG_NAME, s);}
    public void setPackage(String s){    setNodeText(PACKAGE_TAG_NAME, s);}

}

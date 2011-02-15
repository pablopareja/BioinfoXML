/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.gexf.viz;

import com.era7.lib.era7xmlapi.model.NameSpace;
import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;


/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class VizPositionXML extends XMLElement{

    public static final String TAG_NAME = "position";

    public static final String VIZ_NAMESPACE = "viz";

    public static final String X_ATTRIBUTE = "x";
    public static final String Y_ATTRIBUTE = "y";
    public static final String Z_ATTRIBUTE = "z";

    public VizPositionXML(){
        super(new Element(TAG_NAME));
        this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
    }
    public VizPositionXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }else{
            this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
        }
    }
    public VizPositionXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }else{
            this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
        }
    }

    //----------------SETTERS-------------------
    public void setX(int value){
        this.root.setAttribute(X_ATTRIBUTE, String.valueOf(value));
    }
    public void setY(int value){
        this.root.setAttribute(Y_ATTRIBUTE, String.valueOf(value));
    }
    public void setZ(int value){
        this.root.setAttribute(Z_ATTRIBUTE, String.valueOf(value));
    }

}

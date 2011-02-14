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
public class VizColorXML extends XMLElement{

    public static final String TAG_NAME = "color";

    public static final String VIZ_NAMESPACE = "viz";

    public static final String R_ATTRIBUTE = "r";
    public static final String G_ATTRIBUTE = "g";
    public static final String B_ATTRIBUTE = "b";
    public static final String A_ATTRIBUTE = "a";

    public VizColorXML(){
        super(new Element(TAG_NAME));
        this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
    }
    public VizColorXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }else{
            this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
        }
    }
    public VizColorXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }else{
            this.setNameSpace(new NameSpace(VIZ_NAMESPACE, VIZ_NAMESPACE));
        }
    }

    //----------------SETTERS-------------------
    public void setR(int value){
        this.root.setAttribute(R_ATTRIBUTE, String.valueOf(value));
    }
    public void setG(int value){
        this.root.setAttribute(G_ATTRIBUTE, String.valueOf(value));
    }
    public void setB(int value){
        this.root.setAttribute(B_ATTRIBUTE, String.valueOf(value));
    }
    public void setA(int value){
        this.root.setAttribute(A_ATTRIBUTE, String.valueOf(value));
    }

}

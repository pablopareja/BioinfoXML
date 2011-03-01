/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.gexf;

import com.era7.lib.bioinfoxml.gexf.viz.VizColorXML;
import com.era7.lib.bioinfoxml.gexf.viz.VizPositionXML;
import com.era7.lib.bioinfoxml.gexf.viz.VizSizeXML;
import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class NodeXML extends XMLElement{

    public static final String TAG_NAME = "node";

    public static final String ID_ATTRIBUTE = "id";
    public static final String LABEL_ATTRIBUTE = "label";
    public static final String START_ATTRIBUTE = "start";
    public static final String END_ATTRIBUTE = "end";


    public NodeXML(){
        super(new Element(TAG_NAME));
    }
    public NodeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public NodeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    public void setStart(String value){
        this.root.setAttribute(START_ATTRIBUTE, value);
    }
    public void setEnd(String value){
        this.root.setAttribute(END_ATTRIBUTE, value);
    }
    public void setLabel(String value){
        this.root.setAttribute(LABEL_ATTRIBUTE,value);
    }
    public void setColor(VizColorXML vizColor){
        this.root.removeChildren(VizColorXML.TAG_NAME);
        this.root.addContent(vizColor.asJDomElement());
    }
    public void setSize(VizSizeXML vizSize){
        this.root.removeChildren(VizSizeXML.TAG_NAME);
        this.root.addContent(vizSize.asJDomElement());
    }
    public void setPosition(VizPositionXML vizPosition){
        this.root.removeChildren(VizPositionXML.TAG_NAME);
        this.root.addContent(vizPosition.asJDomElement());
    }

    public void setAttvalues(AttValuesXML attValuesXML){
        this.root.removeChildren(AttValuesXML.TAG_NAME);
        this.root.addContent(attValuesXML.asJDomElement());
    }
    public void setSpells(SpellsXML spellsXML){
        this.root.removeChildren(SpellsXML.TAG_NAME);
        this.root.addContent(spellsXML.asJDomElement());
    }

    //----------------GETTERS-------------------

    public String getLabel(){
        return this.root.getAttributeValue(LABEL_ATTRIBUTE);
    }


}

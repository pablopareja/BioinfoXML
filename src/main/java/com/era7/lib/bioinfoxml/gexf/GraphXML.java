/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.gexf;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class GraphXML extends XMLElement{

    public static final String TAG_NAME = "graph";

    public static final String DEFAULT_EDGE_TYPE_ATTRIBUTE = "defaultedgetype";


    public static final String DIRECTED_EDGE_TYPE = "directed";

    public GraphXML(){
        super(new Element(TAG_NAME));
    }
    public GraphXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public GraphXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setDefaultEdgeType(String value){
        this.root.setAttribute(DEFAULT_EDGE_TYPE_ATTRIBUTE, value);
    }
    public void setNodes(NodesXML value){
        this.root.removeChildren(NodesXML.TAG_NAME);
        this.root.addContent(value.getRoot());
    }
    public void setEdges(EdgesXML value){
        this.root.removeChildren(EdgesXML.TAG_NAME);
        this.root.addContent(value.getRoot());
    }

    public void addAttributes(AttributesXML attributesXML){
        this.root.addContent(attributesXML.asJDomElement());
    }

}

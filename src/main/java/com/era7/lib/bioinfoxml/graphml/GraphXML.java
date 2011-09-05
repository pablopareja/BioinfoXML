/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.graphml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class GraphXML extends XMLElement{

    public static final String TAG_NAME = "graph";

    public static final String EDGE_DEFAULT_ATTRIBUTE = "edgedefault";
    public static final String ID_ATTRIBUTE = "id";

    public static final String DIRECTED_EDGE_TYPE = "directed";
    public static final String UNDIRECTED_EDGE_TYPE = "undirected";


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
        this.root.setAttribute(EDGE_DEFAULT_ATTRIBUTE, value);
    }
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    
    
    public void addNode(NodeXML node){
        addChild(node);
    }
    public void addEdge(EdgeXML edge){
        addChild(edge);
    }
    
}

/*
 * Copyright (C) 2010-2012  "Oh no sequences!"
 *
 * This is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.era7.lib.bioinfoxml.graphml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class EdgeXML extends XMLElement{

    public static final String TAG_NAME = "edge";

    public static final String ID_ATTRIBUTE = "id";
    public static final String SOURCE_ATTRIBUTE = "source";
    public static final String TARGET_ATTRIBUTE = "target";

    public EdgeXML(){
        super(new Element(TAG_NAME));
    }
    public EdgeXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public EdgeXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setId(String value){
        this.root.setAttribute(ID_ATTRIBUTE, value);
    }
    public void setSource(String value){
        this.root.setAttribute(SOURCE_ATTRIBUTE, value);
    }
    public void setTarget(String value){
        this.root.setAttribute(TARGET_ATTRIBUTE, value);
    }
    
    

    //----------------GETTERS-------------------
    public String getId(){
        return this.root.getAttributeValue(ID_ATTRIBUTE);
    }
    public String getSource(){
        return this.root.getAttributeValue(SOURCE_ATTRIBUTE);
    }
    public String getTarget(){
        return this.root.getAttributeValue(TARGET_ATTRIBUTE);
    }
    
    
    public void addData(DataXML data){
        addChild(data);
    }
    
}

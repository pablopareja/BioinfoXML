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

package com.era7.lib.bioinfoxml.gexf;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;


/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class AttValueXML extends XMLElement{

    public static final String TAG_NAME = "attvalue";

    public static final String FOR_ATTRIBUTE = "for";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String START_ATTRIBUTE = "start";
    public static final String END_ATTRIBUTE = "end";

    public AttValueXML(){
        super(new Element(TAG_NAME));
    }
    public AttValueXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public AttValueXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setFor(int value){
        this.root.setAttribute(FOR_ATTRIBUTE, String.valueOf(value));
    }
    public void setValue(String value){
        this.root.setAttribute(VALUE_ATTRIBUTE, value);
    }
    public void setStart(String value){
        this.root.setAttribute(START_ATTRIBUTE, value);
    }
    public void setEnd(String value){
        this.root.setAttribute(END_ATTRIBUTE, value);
    }

}

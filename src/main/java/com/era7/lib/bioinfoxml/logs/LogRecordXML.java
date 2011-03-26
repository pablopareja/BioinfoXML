/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.logs;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class LogRecordXML extends XMLElement{
    
    public static final String TAG_NAME = "log_record";

    public static final String SOURCE_TAG_NAME = "source";
    public static final String DATE_TAG_NAME = "date";
    public static final String DESCRIPTION_TAG_NAME = "description";
    public static final String SOURCE_IP_TAG_NAME = "source_ip";

    public LogRecordXML(){
        super(new Element(TAG_NAME));
    }
    public LogRecordXML(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public LogRecordXML(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }


    public void setSource(String value){  setNodeText(SOURCE_TAG_NAME, value);}
    public void setDescription(String value){  setNodeText(DESCRIPTION_TAG_NAME, value);}
    public void setSourceIP(String value){  setNodeText(SOURCE_IP_TAG_NAME,value);}
    public void setDate(String value){ setNodeText(DATE_TAG_NAME,value);}

    public String getSource(){     return getNodeText(SOURCE_TAG_NAME);   }
    public String getDescription(){     return getNodeText(DESCRIPTION_TAG_NAME);   }
    public String getSourceIP(){     return getNodeText(SOURCE_IP_TAG_NAME);   }
    public String getDate(){    return getNodeText(DATE_TAG_NAME);   }


}

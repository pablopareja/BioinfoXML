/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class Hit extends XMLElement{

    public static final String TAG_NAME = "Hit";

    public static final String HIT_HSPS_TAG_NAME = "Hit_hsps";
    public static final String HIT_DEF_TAG_NAME =  "Hit_def";
    public static final String HIT_LEN_TAG_NAME = "Hit_len";
    public static final String HIT_ID_TAG_NAME = "Hit_id";
    public static final String UNIPROT_ID_TAG_NAME = "uniprot_id";

    public Hit(){
        super(new Element(TAG_NAME));
    }
    public Hit(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Hit(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------GETTERS---------------------
    public ArrayList<Hsp> getHitHsps( ) throws XMLElementException{
        ArrayList<Hsp> array = new ArrayList<Hsp>();
        List<Element> tempList = root.getChild(HIT_HSPS_TAG_NAME).getChildren();
        for(Element elem : tempList){
            array.add(new Hsp(elem));
        }
        return array;

    }

    public String getHitDef(){  return getNodeText(HIT_DEF_TAG_NAME); }
    public int getHitLen(){  return Integer.parseInt(getNodeText(HIT_LEN_TAG_NAME)); }
    public String getHitId(){   return getNodeText(HIT_ID_TAG_NAME);}
    public String getUniprotID(){   return getNodeText(UNIPROT_ID_TAG_NAME);}
    public String getScaffoldIDFromHitDef(){    return getHitDef().split(" ")[0];}

    //----------------SETTERS---------------------
    public void setHitId(String value){ setNodeText(HIT_ID_TAG_NAME, value);}
    public void setHitDef(String value){    setNodeText(HIT_DEF_TAG_NAME,value);}
    public void setHitLef(int value){   setNodeText(HIT_LEN_TAG_NAME, String.valueOf(value));}
    public void setUniprotID(String value){ setNodeText(UNIPROT_ID_TAG_NAME, value);}
}

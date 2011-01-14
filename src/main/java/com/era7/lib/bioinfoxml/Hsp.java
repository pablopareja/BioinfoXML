/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import org.jdom.Element;

/**
 *
 * @author Pablo Pareja Tobes
 */
public class Hsp extends XMLElement{

    public static final String TAG_NAME = "Hsp";

    public static final String NUM_TAG_NAME = "Hsp_num";
    public static final String EVALUE_TAG_NAME = "Hsp_evalue";
    public static final String QUERY_FROM_TAG_NAME = "Hsp_query-from";
    public static final String QUERY_TO_TAG_NAME = "Hsp_query-to";
    public static final String QUERY_FRAME_TAG_NAME = "Hsp_query-frame";
    public static final String HIT_FROM_TAG_NAME = "Hsp_hit-from";
    public static final String HIT_TO_TAG_NAME = "Hsp_hit-to";
    public static final String HIT_FRAME_TAG_NAME = "Hsp_hit-frame";
    public static final String IDENTITY_TAG_NAME = "Hsp_identity";

    
    public Hsp(){
        super(new Element(TAG_NAME));
    }
    public Hsp(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public Hsp(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    

    //----------------SETTERS-------------------
    public void setNum(String value){  setNodeText(NUM_TAG_NAME, value);}
    public void setEvalue(String value){    setNodeText(EVALUE_TAG_NAME, value);}
    public void setQueryFrom(int value){   setNodeText(QUERY_FROM_TAG_NAME, String.valueOf(value));}
    public void setQueryTo(int value){ setNodeText(QUERY_TO_TAG_NAME, String.valueOf(value));}
    public void setQueryFrame(int value){   setNodeText(QUERY_FRAME_TAG_NAME, String.valueOf(value));}
    public void setHitFrom(int value){    setNodeText(HIT_FROM_TAG_NAME, String.valueOf(value));}
    public void setHitTo(int value){    setNodeText(HIT_TO_TAG_NAME, String.valueOf(value));}
    public void setHitFrame(int value){    setNodeText(HIT_FRAME_TAG_NAME, String.valueOf(value));}
    public void setIdentity(String value){    setNodeText(IDENTITY_TAG_NAME, value);}


    //----------------GETTERS---------------------
    public String getNum( ){  return getNodeText(NUM_TAG_NAME);}
    public String getEvalue( ){  return getNodeText(EVALUE_TAG_NAME);}
    public double getEvalueDoubleFormat(){
        String[] array = getEvalue().split("e");
        if(array.length < 2){
            //System.out.println("evalue = " + getEvalue());
            return Double.valueOf(array[0]);
        }else{
            return Double.valueOf(array[0]) * Math.pow(10.0, Double.valueOf(array[1]));
        }
    }
    public int getQueryFrom( ){  return Integer.parseInt(getNodeText(QUERY_FROM_TAG_NAME));}
    public int getQueryTo( ){  return Integer.parseInt(getNodeText(QUERY_TO_TAG_NAME));}
    public int getQueryFrame(){ return Integer.parseInt(getNodeText(QUERY_FRAME_TAG_NAME));}
    public int getHitFrom( ){  return Integer.parseInt(getNodeText(HIT_FROM_TAG_NAME));}
    public int getHitTo( ){  return Integer.parseInt(getNodeText(HIT_TO_TAG_NAME));}
    public int getHitFrame( ){  return Integer.parseInt(getNodeText(HIT_FRAME_TAG_NAME));}
    public String getIdentity( ){  return getNodeText(IDENTITY_TAG_NAME);}
    public boolean getOrientation(){    return getHitFrame() > 0;}

    

}

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
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class BlastOutputParam extends XMLElement{

    public static final String TAG_NAME = "BlastOutput_param";

    public static final String PARAMETERS_TAG_NAME = "Parameters";

    public static final String MATRIX_TAG_NAME = "Parameters_matrix";
    public static final String EXPECT_TAG_NAME = "Parameters_expect";
    public static final String GAP_OPEN_TAG_NAME = "Parameters_gap-open";
    public static final String GAP_EXTEND_TAG_NAME = "Parameters_gap-extend";
    public static final String FILTER_TAG_NAME = "Parameters_filter";    

    public BlastOutputParam(){
        super(new Element(TAG_NAME));
    }
    public BlastOutputParam(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public BlastOutputParam(String value) throws Exception{
        super(value);
        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }

    //----------------SETTERS-------------------
    public void setMatrix(String value){
        initParametersTag();
        setNodeText(MATRIX_TAG_NAME, value);
    }
    public void setExpect(String value){
        initParametersTag();
        setNodeText(EXPECT_TAG_NAME, value);
    }
    public void setGapOpen(String value){
        initParametersTag();
        setNodeText(GAP_OPEN_TAG_NAME, value);
    }
    public void setGapExtend(String value){
        initParametersTag();
        setNodeText(GAP_EXTEND_TAG_NAME, value);
    }
    public void setFilter(String value){
        initParametersTag();
        setNodeText(FILTER_TAG_NAME, value);
    }


    //----------------GETTERS---------------------
    public String getMatrix(){       return getNodeText(MATRIX_TAG_NAME);  }
    public String getExpect(){  return getNodeText(EXPECT_TAG_NAME);  }
    public String getGapOpen(){  return getNodeText(GAP_OPEN_TAG_NAME);  }
    public String getGapExtend(){  return getNodeText(GAP_EXTEND_TAG_NAME);  }
    public String getFilter(){  return getNodeText(FILTER_TAG_NAME);  }


    public BlastOutputParam getBlastOutputParam() throws XMLElementException{
        Element elem = root.getChild(BlastOutputParam.TAG_NAME);
        if(elem == null){
            return null;
        }else{
            return new BlastOutputParam(elem);
        }
    }

    private void initParametersTag(){
        Element paramsTagName = root.getChild(PARAMETERS_TAG_NAME);
        if(paramsTagName == null){
            paramsTagName = new Element(PARAMETERS_TAG_NAME);
        }
    }

}

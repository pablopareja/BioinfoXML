/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.util;

import com.era7.lib.era7xmlapi.model.XMLElement;
import com.era7.lib.era7xmlapi.model.XMLElementException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class ScheduledExecutions extends XMLElement{

    public static final String TAG_NAME = "scheduled_executions";

    public ScheduledExecutions(){
        super(new Element(TAG_NAME));
    }
    public ScheduledExecutions(Element elem) throws XMLElementException{
        super(elem);
        if(!elem.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(elem));
        }
    }
    public ScheduledExecutions(String value) throws Exception{
        super(value);

        if(!root.getName().equals(TAG_NAME)){
            throw new XMLElementException(XMLElementException.WRONG_TAG_NAME,new XMLElement(value));
        }
    }


    public void addExecution(Execution exec){
        addChild(exec);
    }

    //----------------GETTERS---------------------
    public ArrayList<Execution> getExecutions() throws XMLElementException{
        ArrayList<Execution> array = new ArrayList<Execution>();
        List<Element> list = root.getChildren(Execution.TAG_NAME);
        for(Element elem : list){
            Execution temp = new Execution(elem);
            array.add(temp);
        }
        return array;
    }

    //----------------SETTERS---------------------
}


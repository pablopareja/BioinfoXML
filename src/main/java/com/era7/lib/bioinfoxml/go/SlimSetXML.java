/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.lib.bioinfoxml.go;

import com.era7.lib.era7xmlapi.model.XMLElement;
import org.jdom.Element;

/**
 *
 * @author ppareja
 */
public class SlimSetXML extends XMLElement{

    public static final String TAG_NAME = "slim_set";

    public static final String NAME_TAG_NAME = "name";

    public SlimSetXML() {
        super(new Element(TAG_NAME));
    }

    public SlimSetXML(String value) throws Exception {
        super(value);
    }

    public SlimSetXML(Element element) {
        super(element);
    }


    public void addGoTerm(GoTermXML term){
        root.addContent(term.getRoot());
    }


    //----------------SETTERS-------------------
    public void setSlimSetName(String value) {    setNodeText(NAME_TAG_NAME, value);  }

    //----------------GETTERS---------------------
    public String getGoSlimName() {   return getNodeText(NAME_TAG_NAME);   }
    

}

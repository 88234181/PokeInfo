package me.june.pokeinfo;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by j8823_000 on 8/16/2016.
 */
public class XMLParser {

    public XMLParser(){
        //
    }

    /**convert xml file to DOM structure
     *
     * @param context context of the activity since this is outside of activity
     * @return Document
     */
    public Document getDomElement(Context context){
        Document doc = null;
        String file = "pokedex.xml";
        try{

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            InputStream raw = context.getAssets().open(file);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(raw);
        } catch (ParserConfigurationException e){
            Log.e("Error: ", e.getMessage());
            e.printStackTrace();
            return null;
        } catch (SAXException e){
            Log.e("Error: ", e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e){
            Log.e("Error: ", e.getMessage());
            e.printStackTrace();
            return null;
        }

        return doc;
    }


    /**get each xml child element value by passing element node name
     *
     * @param element
     * @return
     */
    public final String getElementValue(Node element){
        Node child;

        if(element != null){
            if(element.hasChildNodes()){
                for(child = element.getFirstChild(); child != null; child = child.getNextSibling()){
                    return child.getNodeValue();
                }
            }
        }
        return "";
    }

    public String getValue(Element item, String str){
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }
}

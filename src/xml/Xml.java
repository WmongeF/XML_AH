/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Walter Monge
 */
public class Xml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("concesionario.xml");
            
            Document document = builder.build(xml);
            Element root = document.getRootElement();
            
            List<Element> list= root.getChildren("coches");
            
            for (int i=0; i< list.size(); i++){
            Element coche = list.get(i);
            List<Element> valores_coche = coche.getChildren();
            
            for (int j=0; j < valores_coche.size(); j++){
            
                Element campo = valores_coche.get(j);
                
                String matricula = campo.getChildTextTrim("matricula");
                String marca = campo.getChildTextTrim("marca");
                String precio = campo.getChildTextTrim("precio");
                
                System.out.println(matricula + "t/" + marca + "t/" + precio);
            }
            }
            
            
        } catch (JDOMException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

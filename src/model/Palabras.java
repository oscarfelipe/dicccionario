/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * List of Words and phrases
 * @author oscar
 */
public class Palabras {
    
    public ObservableList getPalabras(){
        ObservableList<Palabra> palabras = FXCollections.<Palabra>observableArrayList(
                new Palabra("heldigvis", "héldivis", "afortunadamente", "Copenhague", 10, 1, " =)", 1),
                new Palabra("allerede", "élerred", "ya", "Kolding", 10, 1, " vi er allerede her", 1),
                new Palabra("stadigvæk", "stedivék", "constantemente, sin cesar, siempre, seguir", "Kolding", 10, 1, " =)", 1)
                );
        
        return palabras;
    }
    
//    public ObservableList getPalabras2(){
//      final ObservableList<Palabra2> palabras = FXCollections.<Palabra2>observableArrayList(
//                new Palabra2("heldigvis", "afortunadamente", 10, 1, " =)"),
//                new Palabra2("allerede", "ya", 10, 1, " vi er allerede her"),
//                new Palabra2("stadigvæk", "constantemente, sin cesar, siempre, seguir", 10, 1, " =)")
//                );
//        
//        return palabras;
//    }
}

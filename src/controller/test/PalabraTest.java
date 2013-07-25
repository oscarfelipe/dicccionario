/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.test;

import model.Palabra;

/**
 *
 * @author oscar
 */
public class PalabraTest {
    
    public static void main(String[] args) {
        Palabra palabra1 = new Palabra("heldigvis", "jheldivis", "afortunadamente", "CBSI 2 modul", 10, 1, " =)", 1);
        
        System.out.println("title: " + palabra1.getTitle());
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;

/**
 *
 * @author oscar
 */
public class Palabra {
    //Palabra represents a word or phrase in the dictionary
    
    public final SimpleStringProperty title, pronunciation, definition,source,example;
    public long language, grade_of_knowledge, priority;

    public Palabra(String title, String pronunciation, String definition, String source, long grade_of_knowledge, long priority, String example, long language) {
        this.title = new SimpleStringProperty(title);
        this.pronunciation = new SimpleStringProperty(pronunciation);
        this.definition = new SimpleStringProperty(definition);
        this.source = new SimpleStringProperty(source);
        this.grade_of_knowledge = grade_of_knowledge;
        this.priority = priority;
        this.example = new SimpleStringProperty(example);
        this.language = language;
    }
    
    public static Palabra read(ISqlJetCursor cursor) throws SqlJetException{
        
        return new Palabra(cursor.getString("title"), cursor.getString("pronunciation"),cursor.getString("definition"),
                cursor.getString("source"),cursor.getInteger("grade_of_knowledge"), cursor.getInteger("priority"),
                cursor.getString("example"),cursor.getInteger("language"));
    }
}

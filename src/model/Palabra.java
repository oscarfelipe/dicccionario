/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
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
    public final SimpleIntegerProperty language, grade_of_knowledge, priority;

    public Palabra(String title, String pronunciation, String definition, String source, int grade_of_knowledge, int priority, String example, int language) {
        
        this.title = new SimpleStringProperty(title);
        this.pronunciation = new SimpleStringProperty(pronunciation);
        this.definition = new SimpleStringProperty(definition);
        this.source = new SimpleStringProperty(source);
        this.grade_of_knowledge = new SimpleIntegerProperty(grade_of_knowledge);
        this.priority = new SimpleIntegerProperty(priority);
        this.example = new SimpleStringProperty(example);
        this.language = new SimpleIntegerProperty(language);
    }
    
    public static Palabra read(ISqlJetCursor cursor) throws SqlJetException{
        
        return new Palabra(cursor.getString("title"), cursor.getString("pronunciation"),cursor.getString("definition"),
                cursor.getString("source"),(int)cursor.getInteger("grade_of_knowledge"), (int)cursor.getInteger("priority"),
                cursor.getString("example"),(int)cursor.getInteger("language"));
    }

    public String getTitle() {
        return title.getValueSafe();
    }

    public String getPronunciation() {
        return pronunciation.getValueSafe();
    }

    public String getDefinition() {
        return definition.getValueSafe();
    }

    public String getSource() {
        return source.getValueSafe();
    }

    public String getExample() {
        return example.getValueSafe();
    }

    public Integer getLanguage() {
        return language.get();
    }

    public Integer getGrade_of_knowledge() {
        return grade_of_knowledge.get();
    }

    public Integer getPriority() {
        return priority.get();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;

/**
 *
 * @author oscar
 */
public class Palabra3 {
    public  String title, pronunciation, definition, source, example;
    public  long language, grade_of_knowledge, priority;

    public Palabra3(String title, String pronunciation, String definition, String source, long grade_of_knowledge, long priority, String example, long language) {

        this.title = title;
        this.pronunciation = pronunciation;
        this.definition = definition;
        this.source = source;
        this.grade_of_knowledge = grade_of_knowledge;
        this.priority = priority;
        this.example = example;
        this.language = language;
    }

    public static Palabra3 read(ISqlJetCursor cursor) throws SqlJetException {
        
        return new Palabra3(cursor.getString("title"), cursor.getString("pronunciation"), cursor.getString("definition"),
                cursor.getString("source"), (int) cursor.getInteger("grade_of_knowledge"), (int) cursor.getInteger("priority"),
                cursor.getString("example"), (int) cursor.getInteger("language"));
    }

    public String getTitle() {
        return title;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getDefinition() {
        return definition;
    }

    public String getSource() {
        return source;
    }

    public String getExample() {
        return example;
    }

    public long getLanguage() {
        return language;
    }

    public long getGrade_of_knowledge() {
        return grade_of_knowledge;
    }

    public long getPriority() {
        return priority;
    }    
}

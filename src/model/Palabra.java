/*
 * A Bean representing to representing Words
 * Palabra in spanish means word in english
 */
package model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;

/**
 *
 * @author oscar
 */
public class Palabra {
    
    
    private SimpleStringProperty title, pronunciation, definition, source, example;
    private SimpleLongProperty language, grade_of_knowledge, priority;

    public Palabra(String title, String pronunciation, String definition, String source, long grade_of_knowledge, long priority, String example, long language) {

        this.title = new SimpleStringProperty(title);
        this.pronunciation = new SimpleStringProperty(pronunciation);
        this.definition = new SimpleStringProperty(definition);
        this.source = new SimpleStringProperty(source);
        this.grade_of_knowledge = new SimpleLongProperty(grade_of_knowledge);
        this.priority = new SimpleLongProperty(priority);
        this.example = new SimpleStringProperty(example);
        this.language = new SimpleLongProperty(language);
    }

    public static Palabra read(ISqlJetCursor cursor) throws SqlJetException {

        return new Palabra(cursor.getString("title"), cursor.getString("pronunciation"), cursor.getString("definition"),
                cursor.getString("source"), cursor.getInteger("grade_of_knowledge"), cursor.getInteger("priority"),
                cursor.getString("example"), cursor.getInteger("fk_language_id"));
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

    public long getLanguage() {
        return language.get();
    }

    public long getGrade_of_knowledge() {
        return grade_of_knowledge.get();
    }

    public long getPriority() {
        return priority.get();
    }
    
}

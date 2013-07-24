/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author oscar
 */
public class Palabra2 {
    
    private final SimpleStringProperty title, definition,example;
    private final SimpleLongProperty grade_of_knowledge, priority;

    public Palabra2(String title, String definition, Long grade_of_knowledge, Long priority, String example) {
        this.title = new SimpleStringProperty(title);
        this.definition = new SimpleStringProperty(definition);
        this.grade_of_knowledge = new SimpleLongProperty(grade_of_knowledge);
        this.priority = new SimpleLongProperty(priority);
        this.example = new SimpleStringProperty(example);
       
    }
    
    public String getTitle() {
        return title.get();
    }

    public String getDefinition() {
        return definition.get();
    }

    public String getExample() {
        return example.get();
    }

    public Long getGrade_of_knowledge() {
        return grade_of_knowledge.get();
    }

    public Long getPriority() {
        return priority.get();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Palabra;
import model.Palabra2;
import model.Palabras;
import org.tmatesoft.sqljet.core.SqlJetException;


/**
 *
 * @author oscar
 */
public class DiccionarioController implements Initializable {
    
    
    @FXML TextField title_txt_field;
    @FXML TextField pronunciation_txt_field;
    @FXML TextArea definition_txt_area;
    @FXML TextField source_txt_field;
    @FXML ChoiceBox grade_of_knowledge_chbox;
    @FXML ChoiceBox priority_chbox;
    @FXML TextArea example_txt_area;
    @FXML Button save_button;
    
    @FXML TableView table;
    @FXML TableColumn word_column;
    @FXML TableColumn definition_column;
    @FXML TableColumn knowledge_column;
    @FXML TableColumn priority_column;
    @FXML TableColumn example_column;
    @FXML Label message_lbl;
    static Task copyWorker;
    
    
    private final ObservableList<Palabra> palabras;

    public DiccionarioController() {
        this.palabras = FXCollections.<Palabra>observableArrayList(
            new Palabra("heldigvis","jheldivis", "afortunadamente", "CBSI 2 modul",10, 1, " =)",1),
            new Palabra("allerede", "elerred","ya","CBSI 2 modul", 10, 1, " vi er allerede her",1),
            new Palabra("stadigvæk","stedivek", "constantemente, sin cesar, siempre, seguir","CBSI 2 modul", 10, 1, " =)",1)
            );
    }
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
       Palabra palabra = new Palabra(title_txt_field.getText(),pronunciation_txt_field.getText(), 
               definition_txt_area.getText(), source_txt_field.getText(), 
               10, 10, example_txt_area.getText(), 1);
        try {         
           copyWorker = createWorker(palabra);
           message_lbl.textProperty().bind(copyWorker.messageProperty());
           
           new Thread(copyWorker).start();
        } catch (SqlJetException ex) {
            Logger.getLogger(DiccionarioController.class.getName()).log(Level.SEVERE, null, ex);
            message_lbl.setText("Error when saving word...");
        }   
    }
    
    public Task createWorker(final Palabra palabra) throws SqlJetException{
        return new Task(){
            @Override
            protected Object call() throws Exception {
                DB.addPalabra(palabra);
                updateMessage("Word Saved");
                DB.close();
                return true;
            }        
        };
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DB.open();
            DB.close();
        } catch (SqlJetException ex) {
            Logger.getLogger(DiccionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //columns binding
        word_column.setCellValueFactory(
                new PropertyValueFactory<Palabra2,String>("title"));
        definition_column.setCellValueFactory(
                new PropertyValueFactory<Palabra2,String>("definition"));
        knowledge_column.setCellValueFactory(
                new PropertyValueFactory<Palabra2,Long>("grade_of_knowledge"));
        priority_column.setCellValueFactory(
                new PropertyValueFactory<Palabra2,Long>("priority"));
        example_column.setCellValueFactory(
                new PropertyValueFactory<Palabra2,String>("example"));
        table.setItems(palabras);
        
        
    }    
}

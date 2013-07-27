/*
 *  Hola!
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;


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
    private List<Palabra> palabras =  new ArrayList<>();
    ObservableList<Palabra> observablePalabras = FXCollections.observableArrayList(palabras);//wrap the list

    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
       //Create a word
       Palabra palabra = new Palabra(title_txt_field.getText(),pronunciation_txt_field.getText(), 
               definition_txt_area.getText(), source_txt_field.getText(), 
               10, 10, example_txt_area.getText(), 1);
        //Test to save word...
    
        
        System.out.println("Button Pressed "+ "Title :"+  palabra.getTitle());
        try {         
           copyWorker = DBController.createWorkerToSave(palabra);
           message_lbl.textProperty().bind(copyWorker.messageProperty());
           observablePalabras.add(palabra);//add word to the observable list
           new Thread(copyWorker).start();
        } catch (SqlJetException ex) {
            Logger.getLogger(DiccionarioController.class.getName()).log(Level.SEVERE, null, ex);
            message_lbl.setText("Error when saving word...");
        }

        cleanFields();
    }
    private void cleanFields(){
        title_txt_field.clear();
        pronunciation_txt_field.clear();
        definition_txt_area.clear();
        source_txt_field.clear();
        example_txt_area.clear();
    }
    
    @FXML
    private void handleTestButtonAction(ActionEvent event) {
        
        
    }
    private void load(){


        try{
            DBController.open();
            DBController.beginReadTransaction();
            ISqlJetCursor cursor = DBController.getAllWords();
            while(!cursor.eof()){

                Palabra palabra = Palabra.read(cursor);
                if(palabra != null){
                    //her I have to add the words
                    observablePalabras.add(palabra);
                    cursor.next();
                }
            }
        }catch (SqlJetException ex){
            ex.printStackTrace();
            return;
        }finally{
            try{
                try{
                    DBController.commitTransaction();
                }finally{
                    DBController.close();
                }
            }catch (SqlJetException ex){
                ex.printStackTrace();

            }

        }

    }
    private void bindColumns() {
        //columns binding
        word_column.setCellValueFactory(
                new PropertyValueFactory<Palabra,String>("title"));
        definition_column.setCellValueFactory(
                new PropertyValueFactory<Palabra,String>("definition"));
        knowledge_column.setCellValueFactory(
                new PropertyValueFactory<Palabra,Long>("grade_of_knowledge"));
        priority_column.setCellValueFactory(
                new PropertyValueFactory<Palabra,Long>("priority"));
        example_column.setCellValueFactory(
                new PropertyValueFactory<Palabra,String>("example"));

    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
            DBController.open();//create or open the data base
           // DBController.close();
        } catch (SqlJetException ex) {
            Logger.getLogger(DiccionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        load(); //load from database

        bindColumns(); //connect columns on TableView with word values
        table.setItems(observablePalabras); // put the items on the table

        
    }

    
}

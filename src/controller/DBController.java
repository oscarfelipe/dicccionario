
package controller;

import java.io.File;
import javafx.concurrent.Task;
import model.Palabra;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.ISqlJetTransaction;
import org.tmatesoft.sqljet.core.table.SqlJetDb;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;

/**
 *
 * @author oscar
 * A class to manage the Data Base
 */
public class DBController {
    private static final String FILE_NAME = "test2.db";
    
    private static SqlJetDb db;
    
    
    public static SqlJetDb open()throws SqlJetException{
        db = SqlJetDb.open(new File(FILE_NAME), true);
        if(db.getSchema().getTable("language") == null){
            db.runWriteTransaction(new ISqlJetTransaction() {

                @Override
                public Object run(SqlJetDb sjd) throws SqlJetException {
                    db.createTable("CREATE TABLE language("
                            + "language_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                            + "language TEXT);");
                    return null;
                }
            });
        }
        if(db.getSchema().getTable("palabra") == null){
            db.runWriteTransaction(new ISqlJetTransaction() {

                @Override
                public Object run(SqlJetDb db) throws SqlJetException {
                    db.createTable("CREATE TABLE palabra (\n" +
                    "palabra_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
                    "title TEXT,\n" +
                    "pronunciation TEXT,\n" +
                    "definition TEXT,\n" +
                    "source TEXT,\n" +
                    "grade_of_knowledge INTEGER,\n" +
                    "priority INTEGER,\n" +
                    "example TEXT,\n" +
                    "fk_language_id INTEGER,\n" +
                    "FOREIGN KEY(fk_language_id)  REFERENCES language (language_id)\n" +
                    ");");
                    return null;
                }
            });
        }
    
    return db;
    }
    
    public static void close() throws SqlJetException {
        db.close();
        db = null;
        
    }
    
    public static void beginReadTransaction() throws SqlJetException {
		db.beginTransaction(SqlJetTransactionMode.READ_ONLY);		
    }
    
    public static void startWriteTransaction() throws SqlJetException {
            db.beginTransaction(SqlJetTransactionMode.WRITE); 
    }
	
    public static void commitTransaction() throws SqlJetException {
            db.commit();
    }	
    //add a word and return the index of the item sucessfully added.
    public static long addPalabra(final Palabra palabra) throws SqlJetException{
        
        return (Long) db.runWriteTransaction(new ISqlJetTransaction() {

            @Override
            public Object run(SqlJetDb db) throws SqlJetException {
                return db.getTable("palabra").insert(palabra.getTitle(),palabra.getPronunciation(),
                        palabra.getDefinition(),palabra.getSource(),palabra.getGrade_of_knowledge(),
                        palabra.getPriority(),palabra.getExample(), palabra.getLanguage());
            }
        });
    }
   public static ISqlJetCursor getAllWords() throws SqlJetException {
       return db.getTable("payments").order("palabra_id");
   } 
    //Tasks related with GUI 
    /*Create a task for a thread running in the background.
     *This task add a new word on the database
     */
    public static Task createWorkerToSave(final Palabra palabra) throws SqlJetException {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                DBController.open();
                DBController.startWriteTransaction();
                try {
                    DBController.addPalabra(palabra);
                    
                } finally {
                    DBController.commitTransaction();
                }
                updateMessage("Word Saved");
                return true;
            }
        }; 
    }
    
}

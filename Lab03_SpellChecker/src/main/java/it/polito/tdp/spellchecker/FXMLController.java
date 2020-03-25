/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuButton;

public class FXMLController {
	
	@FXML
	private TextArea txtIn;
	
    @FXML
    private ChoiceBox<String> choiceBox;
  
	@FXML
	private TextArea txtOut;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
        
    @FXML
    private Button btnCheck;

    @FXML
    private Label lblTime;
    
    @FXML
    private Label lblErrors;

    @FXML
    private Button btnClear;

    @FXML
    void doClearText(ActionEvent event) {
    	txtIn.clear();
    	txtOut.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long startTime = System.nanoTime();
    	Dictionary d = new Dictionary();
    	d.LoadDictionary(choiceBox.getSelectionModel().getSelectedItem());
    	// mancano i controlli sull'input che non sia vuoto
    	List<String> wrong = new LinkedList<String>( d.spellCheckTest(txtIn.getText().toLowerCase().split(" ")));
    	lblErrors.setText("The text contains " + wrong.size() + " error[s]!");
    	for (String w : wrong) {
    		txtOut.appendText(w + "\n");
    	}
    	lblTime.setText( "Spell check completed in " + String.valueOf( (double)(System.nanoTime() - startTime) * 0.000000001 ) + " seconds" );
    }

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("English", "Italian");
        //populate the Choicebox;  
        choiceBox.setItems(list);
    }
}




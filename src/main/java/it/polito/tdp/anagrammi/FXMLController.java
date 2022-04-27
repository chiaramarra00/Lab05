package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtInput;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	String input = txtInput.getText();
    	List<String> anagrammi = model.calcolaAnagramma(input);
    	for (String anagramma : anagrammi) {
    		if (model.isCorrect(anagramma)) 
    			txtCorretti.appendText(anagramma+"\n");
    		else
    			txtErrati.appendText(anagramma+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    

    public void setModel(Model model) {
		this.model = model;
	}

}

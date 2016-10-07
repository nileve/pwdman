package com.padjus.pwdman;

/**
 * pwdman
 *
 * @author Evelin Padjus
 * @version 07/10/16
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
	@FXML private Text buttonpressed;

	@FXML protected void handleEnterButtonAction(ActionEvent event) {
		buttonpressed.setText("Enter button pressed");
	}

}


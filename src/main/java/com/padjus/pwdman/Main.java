package com.padjus.pwdman;

/**
 * pwdman
 *
 * @author Evelin Padjus
 * @version 07/10/16
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main (String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("pwdmanMainView" +
															 ".fxml"));

		Scene scene = new Scene(root, 300, 275);

		stage.setTitle("pwdman - Password Manager v1.0");
		stage.setScene(scene);
		stage.show();
	}

}

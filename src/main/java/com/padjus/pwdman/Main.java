/*
 *     Copyright (C) 2016 Evelin Padjus pwdman
 *
 *     pwdman is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
	public void start (Stage stage) throws Exception {

		Parent root = FXMLLoader
				.load(getClass().getResource("pwdmanMainView" + ".fxml"));

		Scene scene = new Scene(root, 400, 275);

		stage.setTitle("pwdman - Password Manager v1.0");
		stage.setScene(scene);
		stage.show();
	}

}

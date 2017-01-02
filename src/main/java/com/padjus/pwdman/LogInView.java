/*
 *     pwdman Copyright (C) 2017 Evelin Padjus
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LogInView extends Application {

    public static void main (String[] args) {

        launch(args);
    }

    @Override
    // start() method is the main entry point for all JavaFX applications
    public void start (Stage stage) throws Exception {

        stage.setTitle("pwdman - Password Manager v1.0");

        // creates a GridPane object and assigns it to the variable named grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // create userName object
        Label userName = new Label("Insert Your db name:");
        // add created object to the grid
        grid.add(userName, 1, 1);

        TextField dbUserName = new TextField();
        grid.add(dbUserName, 1, 2);

        Label dbPwd = new Label("Insert password for Your db:");
        grid.add(dbPwd, 1, 3);

        PasswordField pwdField = new PasswordField();
        grid.add(pwdField, 1, 4);

        // show the grid lines
        //grid.setGridLinesVisible(true);

        // create button for the new db
        Button createBtn = new Button("Create new db");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn1.getChildren().add(createBtn);
        grid.add(hbBtn1, 0, 6);

        // create button for the existing db connection
        Button openBtn = new Button("Open existing db");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(openBtn);
        grid.add(hbBtn2, 2, 6);

        Scene scene = new Scene(grid, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}



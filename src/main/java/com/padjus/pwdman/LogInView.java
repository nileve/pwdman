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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is for the application starting window, builds user interface
 * and handles button actions.
 *
 * pwdman
 *
 * @author Evelin Padjus
 * @version 07/10/16
 */

public class LogInView {
    
    Stage loginStage = new Stage();
    
    LogInView () {
        
        setupScene();
        
    }
    
    private void setupScene () {
        
        loginStage.setTitle("pwdman - Password Manager v1.0 -> LOGIN VIEW");
        
        // creates a GridPane object and assigns it to the variable named grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // TO DO: separate method for grid elements
        // create userName object
        Label userName = new Label("Insert Your db name:");
        // add created object to the grid
        TextField dbUserName = new TextField();
        Label dbPwd = new Label("Insert password for Your db:");
        PasswordField pwdField = new PasswordField();
        
        // show the grid lines
        //grid.setGridLinesVisible(true);
        
        // create button for the new db
        Button createBtn = new Button("Create new db");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn1.getChildren().add(createBtn);
        
        // add txt control for displaying the message when the button is
        // being pressed
        final Text createBtnAction = new Text();
        
        createBtn.setOnAction(event -> {
            createBtnAction.setText("Left button pressed");
            createBtnAction.setId("createBtnAction");
        });
        
        // create button for the existing db connection
        Button openBtn = new Button("Open existing db");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(openBtn);
        
        final Text openBtnAction = new Text();
        
        openBtn.setOnAction(event -> {
            new MainView();
            loginStage.close();
        });
        
        grid.add(userName, 1, 1);
        grid.add(dbUserName, 1, 2);
        grid.add(dbPwd, 1, 3);
        grid.add(pwdField, 1, 4);
        grid.add(hbBtn1, 0, 6);
        grid.add(createBtnAction, 1, 7);
        grid.add(hbBtn2, 2, 6);
        grid.add(openBtnAction, 1, 8);
        
        Scene scene = new Scene(grid, 600, 400);
        loginStage.setScene(scene);
        scene.getStylesheets()
             .add(getClass().getResource("/pwdman.css").toExternalForm());
        loginStage.show();
        
    }
    
}
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInView extends Application {

    public static void main (String[] args) {

        launch(args);
    }

    @Override
    // start() method is the main entry point for all JavaFX applications
    public void start (Stage loginStage) throws Exception {

        loginStage.setTitle("pwdman - Password Manager v1.0 -> LOGIN VIEW");

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

        // add txt control for displaying the message when the button is
        // being pressed
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 7);
        // setOnAction() method is used to register an event handler that
        // sets the actiontarget object to "Left button pressed"
        // when the button is being pressed
        createBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent e) {

                actiontarget.setText("Left button pressed");
                // Create an ID for each text node by using the setID()
                // method of the Node class
                actiontarget.setId("actiontarget");
            }
        });

        // create button for the existing db connection
        Button openBtn = new Button("Open existing db");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(openBtn);
        grid.add(hbBtn2, 2, 6);

        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 1, 8);

        openBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent e) {

                Stage mainStage = new Stage();
                mainStage.setTitle(
                        "pwdman - Password Manager v1.0 -> MAIN VIEW");

                // create BorderPane in new window
                BorderPane border = new BorderPane();

                // create menubar
                MenuBar menuBar = new MenuBar();
                menuBar.prefWidthProperty().bind(mainStage.widthProperty());
                border.setTop(menuBar);
                // File menu
                Menu fileMenu = new Menu("File");
                MenuItem newMenuItem = new MenuItem("New db");
                MenuItem openMenuItem = new MenuItem("Open ...");
                MenuItem impMenuItem = new MenuItem("Import db");
                MenuItem expMenuItem = new MenuItem("Export db");
                MenuItem exitMenuItem = new MenuItem("Exit");
                // exit program, if exit menuitem is pressed
                exitMenuItem.setOnAction(actionEvent -> Platform.exit());
                fileMenu.getItems()
                        .addAll(newMenuItem, openMenuItem, impMenuItem,
                                expMenuItem, exitMenuItem);
                // Edit menu
                Menu editMenu = new Menu("Edit");
                MenuItem edit1MenuItem = new MenuItem("Edit1");
                MenuItem edit2MenuItem = new MenuItem("Edit2");
                MenuItem edit3MenuItem = new MenuItem("Edit3");
                editMenu.getItems()
                        .addAll(edit1MenuItem, edit2MenuItem, edit3MenuItem);
                // Help menu
                Menu helpMenu = new Menu("HELP");
                MenuItem helpMenuItem = new MenuItem("Help");
                MenuItem aboutMenuItem = new MenuItem("About");
                helpMenu.getItems().addAll(helpMenuItem, aboutMenuItem);

                menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

                // Left region
                TreeItem<String> rootItem = new TreeItem<String> ("DB name");
                rootItem.setExpanded(true);
                for (int i = 1; i < 6; i++) {
                    TreeItem<String> item = new TreeItem<String> ("Message" + i);
                    rootItem.getChildren().add(item);
                }
                TreeView<String> tree = new TreeView<String> (rootItem);
                StackPane root = new StackPane();
                // add tree items to the tree
                root.getChildren().add(tree);

                border.setLeft(tree);

                // Center region
                Text text1 = new Text("PWDMAN PWDMAN PWDMAN PWDMAN");
                text1.setId("test-txt");

                border.setCenter(text1);

                // Bottom region
                Text text = new Text("PWDMAN PWDMAN PWDMAN PWDMAN");
                text.setId("test-txt");

                border.setBottom(text);

                //create scene with set width, height
                Scene scene = new Scene(border, 800, 600);
                //set scene to stage
                mainStage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("/pwdman.css")
                                                     .toExternalForm());
                // show the mainStage, close loginStage
                mainStage.show();
                loginStage.close();
            }
        });

        Scene scene = new Scene(grid, 600, 400);
        loginStage.setScene(scene);
        // load css file
        scene.getStylesheets()
             .add(getClass().getResource("/pwdman.css").toExternalForm());
        loginStage.show();

    }

}
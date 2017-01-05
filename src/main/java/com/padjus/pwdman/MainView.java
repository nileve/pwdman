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

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * pwdman
 *
 * @author Evelin Padjus
 * @version 1.0
 */
public class MainView {

    Stage mainStage = new Stage();

    MainView () {

        setupScene2();

    }

    private void setupScene2 () {

        mainStage.setTitle("pwdman - Password Manager v1.0 -> MAIN VIEW");
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
                .addAll(newMenuItem, openMenuItem, impMenuItem, expMenuItem,
                        exitMenuItem);
        // Edit menu
        Menu editMenu = new Menu("Edit");
        MenuItem edit1MenuItem = new MenuItem("Edit1");
        MenuItem edit2MenuItem = new MenuItem("Edit2");
        MenuItem edit3MenuItem = new MenuItem("Edit3");
        editMenu.getItems().addAll(edit1MenuItem, edit2MenuItem, edit3MenuItem);
        // Help menu
        Menu helpMenu = new Menu("HELP");
        MenuItem helpMenuItem = new MenuItem("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        helpMenu.getItems().addAll(helpMenuItem, aboutMenuItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Left region
        TreeItem<String> rootItem = new TreeItem<String>("DB name");
        rootItem.setExpanded(true);
        for (int i = 1;
             i < 6;
             i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String>(rootItem);
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
        scene.getStylesheets()
             .add(getClass().getResource("/pwdman.css").toExternalForm());
        // show the mainStage, close loginStage
        mainStage.show();
        // loginStage.close();
    }

}

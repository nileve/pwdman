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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is second window for the application (the main view), that is
 * opened from the first window button.
 *
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
        
        // TO DO: separate class for menubar, method for each menu and
        // menuitem actionEvents
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(mainStage.widthProperty());
        
        border.setTop(menuBar);
        
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("Create new DB");
        MenuItem openMenuItem = new MenuItem("Open other DB");
        FileChooser openFileExplorer = new FileChooser();
        MenuItem impMenuItem = new MenuItem("Import from CSV");
        MenuItem expMenuItem = new MenuItem("Export to CSV");
        MenuItem exitMenuItem = new MenuItem("Exit");
        
        openMenuItem.setOnAction(event -> {
            Desktop desktop = Desktop.getDesktop();
            File dbFile = openFileExplorer.showOpenDialog(mainStage);
            if (dbFile != null) {
                try {
                    desktop.open(dbFile);
                } catch (IOException ex) {
                    Logger.getLogger(
                            MainView.class.getName()).log(
                            Level.SEVERE, null, ex
                    );
                }
            }
        });
        
        exitMenuItem.setOnAction(event -> Platform.exit());
        
        fileMenu.getItems()
                .addAll(newMenuItem, openMenuItem, impMenuItem, expMenuItem,
                        exitMenuItem);
        
        Menu editMenu = new Menu("Edit");
        MenuItem edit1MenuItem = new MenuItem("Edit1");
        MenuItem edit2MenuItem = new MenuItem("Edit2");
        MenuItem edit3MenuItem = new MenuItem("Edit3");
        editMenu.getItems().addAll(edit1MenuItem, edit2MenuItem, edit3MenuItem);
        
        Menu helpMenu = new Menu("HELP");
        MenuItem helpMenuItem = new MenuItem("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        
        aboutMenuItem.setOnAction(event -> {
            Desktop www = Desktop.getDesktop();
            try {
                www.browse(new URI("https://github.com/nileve/pwdman"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
        
        helpMenu.getItems().addAll(helpMenuItem, aboutMenuItem);
        
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        
        // Left region
        TreeItem<String> rootDb = new TreeItem<>("MyDatabase");
        rootDb.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> rootGroup = new TreeItem<>(
                    "Grouped " + "Account" + i);
            rootDb.getChildren().add(rootGroup);
            rootGroup.setExpanded(true);
            for (int j = 1; j < 6; j++) {
                TreeItem<String> rootAccount = new TreeItem<>("Account" + j);
                rootGroup.getChildren().add(rootAccount);
            }
        }
        
        TreeView tree = new TreeView(rootDb);
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        
        border.setLeft(tree);
        
        // Center region
        TableView groupAccounts = new TableView();
        groupAccounts.setEditable(true);
        
        TableColumn accountNameCol = new TableColumn("Account name");
        TableColumn userNameCol = new TableColumn("User name");
        TableColumn pwdCol = new TableColumn("Password");
        TableColumn urlCol = new TableColumn("URL");
        TableColumn notesCol = new TableColumn("Notes");
        
        groupAccounts.getColumns()
                     .addAll(accountNameCol, userNameCol, pwdCol, urlCol,
                             notesCol);
        
        border.setCenter(groupAccounts);
        
        // Bottom region
        Text text = new Text("PWDMAN PWDMAN PWDMAN PWDMAN");
        text.setId("test-txt");
        
        border.setBottom(text);
        
        Scene scene = new Scene(border, 1000, 600);
        //set scene to stage
        mainStage.setScene(scene);
        scene.getStylesheets()
             .add(getClass().getResource("/pwdman.css").toExternalForm());
        mainStage.show();
        
    }
    
}

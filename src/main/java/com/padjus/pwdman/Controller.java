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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {

	@FXML private Text buttonPressed;

	@FXML
	protected void handleEnterButtonAction (ActionEvent event) {

		buttonPressed.setText("Enter button pressed");
	}

}


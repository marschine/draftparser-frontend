/*
 * Copyright 2009 IT Mill Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.marrrschine;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {
	private Window window;

	@Override
	public void init() {
		window = new Window("My Vaadin Application");
		setMainWindow(window);

		final Table table = new Table("The Brightest Stars");
		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Mag", Float.class, null);

		// Add a row the hard way
		Object newItemId = table.addItem();
		Item row1 = table.getItem(newItemId);
		row1.getItemProperty("Name").setValue("Sirius");
		row1.getItemProperty("Mag").setValue(-1.46f);

		// Add a few other rows using shorthand addItem()
		table.addItem(new Object[] { "Canopus", -0.72f }, 2);
		table.addItem(new Object[] { "Arcturus", -0.04f }, 3);
		table.addItem(new Object[] { "Alpha Centauri", -0.01f }, 4);

		// Show 5 rows
		table.setPageLength(5);
		window.addComponent(table);
	}
}
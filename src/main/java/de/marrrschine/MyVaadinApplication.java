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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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
		// Handle the events with an anonymous class
		final Button button = new Button("Click It!", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				ServiceConsumer serviceConsumer = new ServiceConsumer();
				// JSONArray jsonArray = serviceConsumer.consumeServiceGet();
			}
		});
		window.addComponent(button);

		ServiceConsumer serviceConsumer = new ServiceConsumer();
		final Table table = new Table("Available Prospects");
		table.addContainerProperty("Firstname", String.class, null);
		table.addContainerProperty("Lastname", String.class, null);
		JSONArray jsonArray;
		try {
			jsonArray = serviceConsumer.consumeServiceGet();
			int i = 0;
			for (Object object : jsonArray) {
				i++;
				JSONObject jsonObj = (JSONObject) object;
				// System.out.println(object.get("firstname"));
				String firstname = (String) jsonObj.get("firstname");
				String lastname = (String) jsonObj.get("lastname");
				// String lastname = (String) object.get("lastname");
				table.addItem(new Object[] { firstname, lastname }, i);
				table.setPageLength(i);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.addComponent(table);
	}

	// @Override
	// public void callbackEvent(JSONArray jsonArray) {
	// final Table table = new Table("Available Prospects");
	// table.addContainerProperty("Firstname", String.class, null);
	// table.addContainerProperty("Lastname", String.class, null);
	// int i = 0;
	// for (Object object : jsonArray) {
	// i++;
	// JSONObject json = (JSONObject) object;
	// table.addItem(new Object[] { json.get("firstname"), json.get("lastname") }, i);
	// }
	// table.setPageLength(i);
	// window.addComponent(table);
	//
	// }
}

// private ServiceConsumer serviceConsumer = new ServiceConsumer();
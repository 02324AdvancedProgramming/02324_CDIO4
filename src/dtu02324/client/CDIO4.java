package dtu02324.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.user.client.ui.RootPanel;

import dtu02324.client.login.Login;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CDIO4 implements EntryPoint {
	/** This is the entry point method. */
	public void onModuleLoad() {
		ParagraphElement user_p = (ParagraphElement) Document.get().getElementById("user_p");
		
		Login login = new Login(user_p);
		RootPanel.get().add(login);
		
	}

}

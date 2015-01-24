package dtu02324.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import dtu02324.client.login.Login;
import dtu02324.client.menu.Menu;
import dtu02324.shared.Login_bundle;
import dtu02324.shared.OprDTO;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CDIO4 implements EntryPoint {
	private OprDTO opr;

	/** This is the entry point method. */
	public void onModuleLoad() {
//		login();
		menu(10, "");
	}
	
	private void login(){
		final ParagraphElement user_p = (ParagraphElement) Document.get().getElementById("user_p");
		Callback<Login_bundle, String> login_callback = new Callback<Login_bundle, String>() {

			@Override
			public void onSuccess(Login_bundle bundle) {
				opr = bundle.getOpr();
				user_p.setInnerText(opr.getName());
				RootPanel.get().clear();
				menu(bundle.getOpr().getId(), bundle.getToken());
			}
			
			@Override
			public void onFailure(String reason) {
				Label error_lbl = new Label("Error");
				error_lbl.setStyleName("error_header");
				Label reason_lbl = new Label("bad mojo");
				reason_lbl.setStyleName("error_contents");
				RootPanel.get().add(error_lbl);
				RootPanel.get().add(reason_lbl);
			}
		};
		
		Login login = new Login(login_callback);
		RootPanel.get().add(login);
	}

	private void menu(int id, String token){
		Menu.createMenu(id, token, new dtu02324.shared.support.Callback<Menu>(){

			@Override
			public void onDone(Menu menu) {
				if(menu != null){
					RootPanel.get().add(menu);	
				} else {
					Label error_lbl = new Label("Error");
					error_lbl.setStyleName("error_header");
					Label reason_lbl = new Label("TEST...!"/*e.getMessage()*/);
					reason_lbl.setStyleName("error_contents");
					RootPanel.get().add(error_lbl);
					RootPanel.get().add(reason_lbl);
				}
			}

			@Override
			public void onError(Throwable t) {
				Label error_lbl = new Label("Error");
				error_lbl.setStyleName("error_header");
				Label reason_lbl = new Label(t.getMessage());
				reason_lbl.setStyleName("error_contents");
				RootPanel.get().add(error_lbl);
				RootPanel.get().add(reason_lbl);
			}
			
		});
		
		
		
//		Menu menu;
//		try {
//			menu = Menu.createMenu();
//			RootPanel.get().add(menu);			
//		} catch (Exception e) {
//			Label error_lbl = new Label("Error");
//			error_lbl.setStyleName("error_header");
//			Label reason_lbl = new Label("TEST...!"/*e.getMessage()*/);
//			reason_lbl.setStyleName("error_contents");
//			RootPanel.get().add(error_lbl);
//			RootPanel.get().add(reason_lbl);
//		}
	}
}

package dtu02324.client.login;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import dtu02324.shared.Login_bundle;

public class Login extends Composite implements HasText {
	interface LoginUiBinder extends UiBinder<Widget, Login> { }
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	@UiField TextBox id_box, password_box;
	@UiField Button button;
	private LoginServiceAsync loginservice = GWT.create(LoginService.class);
	private Callback<Login_bundle, String> callback;

	public Login(Callback<Login_bundle, String> callback) {
		initWidget(uiBinder.createAndBindUi(this));
		this.callback = callback;
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		String _id = id_box.getText();
		String password = password_box.getText();
		try{
			int id = Integer.parseInt(_id);

			loginservice.login(id, password, new AsyncCallback<Login_bundle>() {

				@Override
				public void onSuccess(Login_bundle result) {
					callback.onSuccess(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					callback.onFailure(caught.getMessage());
				}
			});
		}catch(NumberFormatException ex){
			login_failed();
		}
	}

	private void login_failed(){

	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}

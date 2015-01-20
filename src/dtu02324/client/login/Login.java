package dtu02324.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import dtu02324.shared.OprDTO;

public class Login extends Composite implements HasText {
	interface LoginUiBinder extends UiBinder<Widget, Login> { }
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	private final String BTN_TXT = "Login";

	@UiField TextBox id_box, password_box;
	@UiField Button button;
	@UiField VerticalPanel cont;
	private LoginServiceAsync loginservice = GWT.create(LoginService.class);
	private ParagraphElement user_p;

	public Login(ParagraphElement user_p) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(BTN_TXT);
		this.user_p = user_p;
		
		FlexTable flex = new FlexTable();
		flex.setBorderWidth(2);
		Label id_lbl = new Label();
		id_lbl.setText("User ID:");
		flex.setWidget(0, 0, id_lbl);
		TextBox id_box = new TextBox();
		flex.setWidget(1, 0, id_box);
		Label password_lbl = new Label();
		id_lbl.setText("Password:");
		flex.setWidget(2, 0, password_lbl);
		TextBox password_box = new TextBox();
		flex.setWidget(3, 0, password_box);
		
		cont.add(flex);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		String _id = id_box.getText();
		String password = password_box.getText();
		try{
			int id = Integer.parseInt(_id);

			loginservice.login(id, password, new AsyncCallback<OprDTO>() {

				@Override
				public void onSuccess(OprDTO result) {
					user_p.setInnerText(result.getName());
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub

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

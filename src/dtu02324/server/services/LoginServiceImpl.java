package dtu02324.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dtu02324.client.login.LoginService;
import dtu02324.server.dal.OprDAO;
import dtu02324.shared.Login_bundle;
import dtu02324.shared.OprDTO;
import dtu02324.shared.support.PasswordHandler;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	@Override
	public Login_bundle login(int id, String password) throws IllegalArgumentException {
		if(!PasswordHandler.validatePassword(password)) return null;
		OprDTO opr = OprDAO.getInstance().getOpr(id);
		String token = "";
		//Token should be stored somewhere with an expiration time
		Login_bundle b = new Login_bundle(token);
		b.setOpr(opr);
		return b;
	}

}

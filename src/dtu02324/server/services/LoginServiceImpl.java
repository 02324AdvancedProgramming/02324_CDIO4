package dtu02324.server.services;

import dtu02324.client.login.LoginService;
import dtu02324.server.dal.OprDAO;
import dtu02324.shared.OprDTO;
import dtu02324.shared.support.PasswordHandler;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	@Override
	public OprDTO login(int id, String password) throws IllegalArgumentException {
		if(!PasswordHandler.validatePassword(password)) return null;
		OprDTO opr = OprDAO.getInstance().getOpr(id);
		System.out.println(opr);
		return opr;
	}

}

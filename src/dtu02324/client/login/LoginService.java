package dtu02324.client.login;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dtu02324.shared.OprDTO;


@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	public OprDTO login(int id, String password) throws IllegalArgumentException;
}

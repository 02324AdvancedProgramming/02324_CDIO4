package dtu02324.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dtu02324.shared.OprDTO;

public interface LoginServiceAsync {
	public void login(int id, String password, AsyncCallback<OprDTO> callback) throws IllegalArgumentException;
}
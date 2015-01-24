package dtu02324.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dtu02324.shared.Login_bundle;

public interface LoginServiceAsync {
	public void login(int id, String password, AsyncCallback<Login_bundle> callback) throws IllegalArgumentException;
}
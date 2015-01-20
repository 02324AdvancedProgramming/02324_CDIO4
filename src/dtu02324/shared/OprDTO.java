package dtu02324.shared;

import java.io.Serializable;

import dtu02324.shared.support.PasswordHandler;


public class OprDTO implements Serializable{
	private static final long serialVersionUID = 3683043097497677022L;
	private String name;
	private String cpr;
	private String password;
	private int id = -1; //Optional - will be set by server (OprDAO)
	
	public OprDTO(){} //Only for use as bean
	
	public OprDTO(String name, String cpr) {
		this(name, cpr, PasswordHandler.generatePassword());
	}
	
	public OprDTO(String name, String cpr, String password) {
		if(!PasswordHandler.validatePassword(password)){
			throw new IllegalArgumentException("Illegal password");
		}
		this.name = name;
		this.cpr = cpr;
		this.password = password;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getCpr() { return cpr; }
 	public void setPassword(String password) { this.password = password; }
	public String getPassword() { return password; }

	@Override
	public String toString() {
		return "OprDTO [name=" + name + ", cpr=" + cpr + ", password="
				+ password + ", id=" + id + "]";
	}
	
	
}

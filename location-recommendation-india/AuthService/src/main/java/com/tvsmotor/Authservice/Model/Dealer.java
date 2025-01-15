package com.tvsmotor.Authservice.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DealerLoginCredentials")
public class Dealer {


	@Id
	private String _id;
	private String username;
    private String password;
    private String stateId;
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dealer(String username, String password, String stateId) {
		super();
		this._id=_id;
		this.username = username;
		this.password = password;
		this.stateId = stateId;
	}
	  public String get_id() {
			return _id;
		}
		public void set_id(String _id) {
			this._id = _id;
		}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	@Override
	public String toString() {
		return "Dealer [username=" + username + ", password=" + password + ", stateId=" + stateId + "]";
	}

    // Getters and Setters
    
    
}

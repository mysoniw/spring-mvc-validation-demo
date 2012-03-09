package com.github.kolorobot.web.form;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.github.kolorobot.web.validation.UniqueUsername;


/**
 * Make use of group sequence 
 */
@UniqueUsername(message = "{validation.profile.uniqueUsername}", groups = AccountForm2.Unique.class)
public class AccountForm2 implements CredentialsAware {
	
	public interface Unique {}
	
	/**
	 * <code>@UniqueUsername</code> annotation executes database query to verify existence of given username.
	 * In case when default fields fail during validation, this validation will not be triggered.
	 */
	@GroupSequence(value = { Default.class, Unique.class })
	public interface Complete {}
	
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private String username;

	public AccountForm2() {}
	
	public AccountForm2(String name, String address, String username) {
		this.name = name;
		this.address = address;
		this.username = username;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public String getConfirmedPassword() {
		return null;
	}
	@Override
	public String getPassword() {
		return null;
	}
}

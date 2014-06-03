package com.clinkworks.mechwarrior.datatype;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import com.clinkworks.mechwarrior.authentication.AuthenticationToken;


@NamedQueries({
	@NamedQuery(
		name="API_KEY_GET", query=
				"SELECT user.smurfyApiKey FROM " +
						"UserDetails user WHERE " + 
					"user.emailAddress = :emailAddress " +
						"AND " +
					"user.password = :password")
})
@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String emailAddress;
	
	private String smurfyApiKey;
	
	private String password;
	
	@Transient
	private AuthenticationToken authenticationToken;
	
	public int getId() {
		return id;
	}
	
	public AuthenticationToken getAuthenticationToken(){
		return authenticationToken;
	}
	
	public void setAuthenticationToken(AuthenticationToken authenticationToken){
		this.authenticationToken = authenticationToken;
	}
	
	public boolean isSmurfyAuthenticated(){
		return getAuthenticationToken() == null ? null : authenticationToken.isSmurfyAuthenticated();
	}
	
	public boolean isClinkworksAuthenticated(){
		return getAuthenticationToken() == null ? null : authenticationToken.isClinkworksAuthenticated();

	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSmurfyApiKey() {
		return smurfyApiKey;
	}

	public void setSmurfyApiKey(String smurfyApiKey) {
		this.smurfyApiKey = smurfyApiKey;
	}

	@Transient
	public void setPassword(String password) {
		if(password == null){
			this.password = null;
			return;
		}
		byte[] passwordPreHash;
		try {
			passwordPreHash = password.getBytes("UTF-8");
			this.password = MessageDigest.getInstance("MD5").digest(passwordPreHash).toString();
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getPassword(){
		return password;
	}


}

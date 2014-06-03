package com.clinkworks.mechwarrior.data;

import javax.persistence.EntityManager;

import com.clinkworks.mechwarrior.datatype.UserDetails;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class UserData {

	private final Provider<EntityManager> entityManagerProvider;
	
	@Inject
	public UserData(Provider<EntityManager> entityManagerProvider){
		this.entityManagerProvider = entityManagerProvider;
	}
	
	public String getApiKeyForEmailAddressAndPassword(String emailAddress, String password) {
		return getEntityManger().
				createNamedQuery("API_KEY_GET").
				setParameter("emailAddress", emailAddress).
				setParameter("password", password).
				getSingleResult().toString();
	}
	
	public EntityManager getEntityManger(){
		return entityManagerProvider.get();
	}

	public void saveUser(UserDetails userDetails) {
		getEntityManger().persist(userDetails);
		getEntityManger().flush();
	}
	
	public void getUserDetails(int userId){
		
	}

}

package com.clinkworks.mechwarrior.modules;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
 
public class SmurfyClientModule extends AbstractModule{
	

	@Override
	protected void configure() {
	}

	@Provides
	@Singleton
	public Client smurfyClient(){
		return createClient();
	}
	
	private static Client createClient() {
	    try {
			return Client.create(configureClient());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static ClientConfig configureClient() throws NoSuchAlgorithmException, KeyManagementException {
		
		TrustManager[ ] certs = new TrustManager[ ] {
	            new X509TrustManager() {
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
				}
	    };
		
	    SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, certs, new SecureRandom());
    
	    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
	    
	    ClientConfig config = new DefaultClientConfig();
	    
	    config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(
    		new HostnameVerifier() {
    			@Override
    			public boolean verify(String hostname, SSLSession session) {
    				return true;
    			}
    		}, sslContext
	    ));
	    
	    return config;
	}
}

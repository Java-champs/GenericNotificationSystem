/**
 * 
 */
package com.skc.core.rest.client;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author sitakant
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class AbstractRestConnector implements RestConnector {
	
	@Autowired
	private RestTemplate template;

	/* (non-Javadoc)
	 * @see com.skc.core.rest.client.RestConnector#get(java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, Object> get(String url, String... otherArgs) {
		ResponseEntity<Map> response = template.getForEntity(url, Map.class);
		assert response.getStatusCode().is2xxSuccessful();
		return response.getBody();
	}

	/* (non-Javadoc)
	 * @see com.skc.core.rest.client.RestConnector#post(java.lang.String, java.io.Serializable, java.lang.String[])
	 */
	@Override
	public <T extends Serializable> Map<String, Object> post(String url, T t, Map<String,String> appHeaders) {
		
		HttpHeaders headers = new HttpHeaders();
		
		for (Entry<String, String> header: appHeaders.entrySet()) {
			headers.set(header.getKey(), header.getValue());
		}
		
		HttpEntity<T> entity = new HttpEntity<T>(t, headers);
		
		ResponseEntity<Map> response = template.exchange(url, HttpMethod.POST, entity, Map.class);
		assert response.getStatusCode().is2xxSuccessful();
		assert response.getStatusCode().ordinal() == 201;
		return response.getBody();
	}

	/* (non-Javadoc)
	 * @see com.skc.core.rest.client.RestConnector#put(java.lang.String, java.io.Serializable, java.lang.String[])
	 */
	@Override
	public <T extends Serializable> Map<String, Object> put(String url, T t, Map<String,String> appHeaders) {

		HttpHeaders headers = new HttpHeaders();
		
		for (Entry<String, String> header: appHeaders.entrySet()) {
			headers.set(header.getKey(), header.getValue());
		}
		
		HttpEntity<T> entity = new HttpEntity<T>(t, headers);
		
		ResponseEntity<Map> response = template.exchange(url, HttpMethod.PUT, entity, Map.class);
		assert response.getStatusCode().is2xxSuccessful();
		return response.getBody();
	}

	/* (non-Javadoc)
	 * @see com.skc.core.rest.client.RestConnector#delete(java.lang.String, java.lang.String[])
	 */
	@Override
	public void delete(String url, String... otherArgs) {
		template.delete(url);
	}

}

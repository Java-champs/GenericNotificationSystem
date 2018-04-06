/**
 * 
 */
package com.skc.core.rest.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component("restConnector")
public class RestConnectorImpl extends AbstractRestConnector{
	
   @Override
   	public <T extends Serializable> Map<String, Object> post(String url, T t, Map<String, String> appHeaders) {
   		return super.post(url, t, appHeaders);
   	}
   
   @Override
	public void delete(String url, String... otherArgs) {
		super.delete(url, otherArgs);
	}
   
   @Override
	public Map<String, Object> get(String url, String... otherArgs) {
		return super.get(url, otherArgs);
	}
   
   @Override
	public <T extends Serializable> Map<String, Object> put(String url, T t, Map<String, String> appHeaders) {
		return super.put(url, t, appHeaders);
	}
}

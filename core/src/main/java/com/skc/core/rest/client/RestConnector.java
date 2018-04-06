/**
 * 
 */
package com.skc.core.rest.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.lang.Nullable;

/**
 * @author sitakant
 *
 */
public interface RestConnector {
	/**
	 * This method will do a get call for the relevent endpoint
	 * */
	Map<String,Object> get(String url,@Nullable String... otherArgs);
	
	/**
	 * This method will post the data into endpoint
	 * */
	<T extends Serializable> Map<String,Object> post(String url, @Nullable T t, Map<String,String> headers);
	
	/**
	 * This method will do a put call with the relevent data to endpoint
	 * */
	<T extends Serializable> Map<String,Object> put(String url,@Nullable T t,Map<String,String> headers);
	
	/**
	 * This method will do a delete call to the endpoint
	 * */
	void delete(String url,@Nullable String... otherArgs);
}

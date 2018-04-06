/**
 * 
 */
package com.skc.core.message.model;

import java.io.Serializable;

/**
 * This is the core model for the Notification System
 * 
 * @author sitakant
 *
 */
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageText;
	private String messageTo;
	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}
	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	/**
	 * @return the messageTo
	 */
	public String getMessageTo() {
		return messageTo;
	}
	/**
	 * @param messageTo the messageTo to set
	 */
	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}
	
	
}

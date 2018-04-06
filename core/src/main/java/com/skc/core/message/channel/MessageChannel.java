/**
 * 
 */
package com.skc.core.message.channel;

import com.skc.core.message.model.Message;

/**
 * @author sitakant
 *
 */
public interface MessageChannel {
	
	/**
	 * This method will have privilege to decide the channel and send it to the appropirate channel
	 * */
	void doSend(Message message);
}

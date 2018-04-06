/**
 * 
 */
package com.skc.message.slack.channel;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.skc.core.message.channel.MessageChannel;
import com.skc.core.message.model.Message;
import com.skc.core.rest.client.RestConnector;

/**
 * @author sitakant
 *
 */
@Service("slackChannel")
public class SlackMessageChannel implements MessageChannel {

	@Value("${slack.channel.url:https://slack.com/api}")
	private String slackChannelUrl;
	
	@Value("${slack.channel.user.token:abc}")
	private String slackUserToken;
	
	@Value("${slack.common.bot.icon.url:http://icons.iconarchive.com/icons/pauloruberto/custom-round-yosemite/512/FileBot-icon.png}")
	protected String iconUrl;

	@Value("${slack.common.channel:general}")
	protected String slackChannel;
	
	@Autowired
	private RestConnector connector;
	
	protected static final String MESSAGE_URL="/chat.postMessage";
	
	/* (non-Javadoc)
	 * @see com.skc.core.message.channel.MessageChannel#doSend(com.skc.core.message.model.Message, java.lang.String)
	 */
	@Async
	@Override
	public void doSend(Message message) {
		String url = prepareUrl();
		url+="&text="+message.getMessageText();
		System.out.println("URL \t" + url);
		System.out.println("2.Current Thread ==> "+Thread.currentThread().getName());
		connector.post(url, null, new HashMap<String, String>());
		System.out.println("2.Current Thread ==> "+Thread.currentThread().getName());
	}

	private String prepareUrl() {
		return slackChannelUrl+MESSAGE_URL+"?token="+slackUserToken+"&channel="+slackChannel+"&username=GENERIC_BOT"+
				"&icon_url="+iconUrl;
	}

}

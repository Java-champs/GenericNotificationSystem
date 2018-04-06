/**
 * 
 */
package app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skc.core.message.channel.MessageChannel;
import com.skc.core.message.model.Message;

import app.anno.DummyApp;

/**
 * @author sitakant
 *
 */
@RestController
@RequestMapping("/notofications")
public class MyEndpoint {
	
	@Autowired
	private MessageChannel channel;
	
	@Autowired
	DummyApp dummy;
	
	
	@PostMapping
	public Map<String,String> sendMessage(@RequestBody Map<String,String> request){
		System.out.println("1.Current Thread ==> "+Thread.currentThread().getName());
		System.out.println("Instance created "+dummy.getName());
		Map<String,String> maps = new HashMap<>();
		maps.put("status", "success");
		Message message = new Message();
		message.setMessageText(request.get("text"));
		message.setMessageTo(request.get("to"));
		channel.doSend(message);
		return maps;
	}
	
}

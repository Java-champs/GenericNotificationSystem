/**
 * 
 */
package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.skc.message.slack.boot.EnableSlackNotification;

/**
 * @author sitakant
 *
 */
@SpringBootApplication
@EnableSlackNotification
@EnableWebMvc
@ComponentScan({"com.skc.message.slack.channel","app","app.anno"})
public class MyChannelApplication {

	public static void main(String... args) {
		SpringApplication.run(MyChannelApplication.class, args);
	}
	
}

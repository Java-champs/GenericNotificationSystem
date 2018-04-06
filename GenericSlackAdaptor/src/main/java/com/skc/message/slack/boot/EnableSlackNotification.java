/**
 * 
 */
package com.skc.message.slack.boot;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;


/**
 * @author sitakant
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Import(SlackCommonConfiguration.class)
public @interface EnableSlackNotification {
	
}

package org.springblade.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfig
 *
 * @author rajeevkumarsingh
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		// Enables a simple in-memory broker
		registry.enableSimpleBroker("/topic");

		// Use this for enabling a Full featured broker like RabbitMQ
		/*registry.enableStompBrokerRelay("/topic")
			.setRelayHost("localhost")
			.setRelayPort(61613)
			.setClientLogin("guest")
			.setClientPasscode("guest");*/
	}
}

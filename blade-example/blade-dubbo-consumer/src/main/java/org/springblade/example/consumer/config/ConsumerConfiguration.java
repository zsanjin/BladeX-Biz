package org.springblade.example.consumer.config;

import org.springblade.core.secure.registry.SecureRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConsumerConfiguration
 *
 * @author Chill
 */
@Configuration
public class ConsumerConfiguration {

	@Bean
	public SecureRegistry secureRegistry() {
		SecureRegistry secureRegistry = new SecureRegistry();
		secureRegistry.excludePathPatterns("/blog/**");
		return secureRegistry;
	}


}

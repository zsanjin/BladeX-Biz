package org.springblade.example.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springblade.common.constant.CommonConstant;
import org.springblade.core.cloud.feign.EnableBladeFeign;
import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * DubboConsumerApplication
 *
 * @author Chill
 */
@EnableDubbo
@EnableBladeFeign
@SpringCloudApplication
public class DubboConsumerApplication {

	public static void main(String[] args) {
		BladeApplication.run(CommonConstant.APPLICATION_DUBBO_CONSUMER_NAME, DubboConsumerApplication.class, args);
	}

}

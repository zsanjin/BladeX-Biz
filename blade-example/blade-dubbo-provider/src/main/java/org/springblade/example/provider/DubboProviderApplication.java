package org.springblade.example.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springblade.common.constant.CommonConstant;
import org.springblade.core.cloud.feign.EnableBladeFeign;
import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * DubboProviderApplication
 *
 * @author Chill
 */
@EnableDubbo
@EnableBladeFeign
@SpringCloudApplication
public class DubboProviderApplication {

	public static void main(String[] args) {
		BladeApplication.run(CommonConstant.APPLICATION_DUBBO_PROVIDER_NAME, DubboProviderApplication.class, args);
	}

}

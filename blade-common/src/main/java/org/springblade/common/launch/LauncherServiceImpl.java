/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.common.launch;

import org.springblade.common.constant.CommonConstant;
import org.springblade.core.auto.service.AutoService;
import org.springblade.core.launch.constant.AppConstant;
import org.springblade.core.launch.service.LauncherService;
import org.springblade.core.launch.utils.PropsUtil;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * 启动参数拓展
 *
 * @author smallchil
 */
@AutoService(LauncherService.class)
public class LauncherServiceImpl implements LauncherService {

	@Override
	public void launcher(SpringApplicationBuilder builder, String appName, String profile, boolean isLocalDev) {
		Properties props = System.getProperties();
		// 通用注册
		PropsUtil.setProperty(props, "spring.cloud.nacos.discovery.server-addr", CommonConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "spring.cloud.nacos.config.server-addr", CommonConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "spring.cloud.sentinel.transport.dashboard", CommonConstant.sentinelAddr(profile));
		// dubbo注册
		PropsUtil.setProperty(props, "dubbo.application.name", appName);
		PropsUtil.setProperty(props, "dubbo.application.qos.enable", "false");
		PropsUtil.setProperty(props, "dubbo.protocol.name", "dubbo");
		PropsUtil.setProperty(props, "dubbo.registry.address", "nacos://" + CommonConstant.nacosAddr(profile));
		PropsUtil.setProperty(props, "dubbo.version", AppConstant.APPLICATION_VERSION);
		PropsUtil.setProperty(props, "dubbo.scan.base-packages", AppConstant.BASE_PACKAGES);
	}

}

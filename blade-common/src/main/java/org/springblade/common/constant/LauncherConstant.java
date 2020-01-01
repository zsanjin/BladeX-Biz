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
package org.springblade.common.constant;

import org.springblade.core.launch.constant.AppConstant;

import static org.springblade.core.launch.constant.AppConstant.APPLICATION_NAME_PREFIX;

/**
 * 通用常量
 *
 * @author Chill
 */
public interface LauncherConstant {

	/**
	 * nacos namespace id
	 */
	String NACOS_NAMESPACE = "f447a694-519a-4255-95f9-bcbb5a5d6369";

	/**
	 * nacos dev 地址
	 */
	String NACOS_DEV_ADDR = "192.168.101.21:8848";

	/**
	 * nacos prod 地址
	 */
	String NACOS_PROD_ADDR = "172.30.0.48:8848";

	/**
	 * nacos test 地址
	 */
	String NACOS_TEST_ADDR = "172.30.0.48:8848";

	/**
	 * sentinel dev 地址
	 */
	String SENTINEL_DEV_ADDR = "127.0.0.1:8858";

	/**
	 * sentinel prod 地址
	 */
	String SENTINEL_PROD_ADDR = "172.30.0.58:8858";

	/**
	 * sentinel test 地址
	 */
	String SENTINEL_TEST_ADDR = "172.30.0.58:8858";

	/**
	 * dbuuo提供者
	 */
	String APPLICATION_DUBBO_PROVIDER_NAME = APPLICATION_NAME_PREFIX + "dubbo-provider";

	/**
	 * dbuuo消费者
	 */
	String APPLICATION_DUBBO_CONSUMER_NAME = APPLICATION_NAME_PREFIX + "dubbo-consumer";

	/**
	 * seata订单
	 */
	String APPLICATION_SEATA_ORDER_NAME = APPLICATION_NAME_PREFIX + "seata-order";

	/**
	 * seata库存
	 */
	String APPLICATION_SEATA_STORAGE_NAME = APPLICATION_NAME_PREFIX + "seata-storage";

	/**
	 * easypoi
	 */
	String APPLICATION_EASYPOI_NAME = APPLICATION_NAME_PREFIX + "easypoi";

	/**
	 * 动态获取nacos地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String nacosAddr(String profile) {
		switch (profile) {
			case (AppConstant.PROD_CODE):
				return NACOS_PROD_ADDR;
			case (AppConstant.TEST_CODE):
				return NACOS_TEST_ADDR;
			default:
				return NACOS_DEV_ADDR;
		}
	}

	/**
	 * 动态获取sentinel地址
	 *
	 * @param profile 环境变量
	 * @return addr
	 */
	static String sentinelAddr(String profile) {
		switch (profile) {
			case (AppConstant.PROD_CODE):
				return SENTINEL_PROD_ADDR;
			case (AppConstant.TEST_CODE):
				return SENTINEL_TEST_ADDR;
			default:
				return SENTINEL_DEV_ADDR;
		}
	}

}

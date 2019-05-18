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
package org.springblade.gateway.endpoint;

import lombok.AllArgsConstructor;
import org.springblade.gateway.dynamic.model.GatewayPredicate;
import org.springblade.gateway.dynamic.model.GatewayRoute;
import org.springblade.gateway.dynamic.service.DynamicRouteService;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由端点
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("/route")
public class RouteEndpoint {

	private DynamicRouteService dynamicRouteService;
	private RouteDefinitionLocator routeDefinitionLocator;

	@GetMapping("/list")
	public Flux<RouteDefinition> list() {
		return routeDefinitionLocator.getRouteDefinitions();
	}

	@PostMapping("/save")
	public String save(@RequestBody GatewayRoute gatewayRoute) {
		RouteDefinition definition = assembleRouteDefinition(gatewayRoute);
		return this.dynamicRouteService.save(definition);
	}

	@PostMapping("/update")
	public String update(@RequestBody GatewayRoute gatewayRoute) {
		RouteDefinition definition = assembleRouteDefinition(gatewayRoute);
		return this.dynamicRouteService.update(definition);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		return this.dynamicRouteService.delete(id);
	}

	private RouteDefinition assembleRouteDefinition(GatewayRoute gatewayRoute) {
		RouteDefinition definition = new RouteDefinition();
		List<PredicateDefinition> pdList = new ArrayList<>();
		definition.setId(gatewayRoute.getId());
		List<GatewayPredicate> gatewayPredicateDefinitionList = gatewayRoute.getPredicates();
		for (GatewayPredicate gpDefinition : gatewayPredicateDefinitionList) {
			PredicateDefinition predicate = new PredicateDefinition();
			predicate.setArgs(gpDefinition.getArgs());
			predicate.setName(gpDefinition.getName());
			pdList.add(predicate);
		}
		definition.setPredicates(pdList);
		URI uri = UriComponentsBuilder.fromHttpUrl(gatewayRoute.getUri()).build().toUri();
		definition.setUri(uri);
		return definition;
	}

}

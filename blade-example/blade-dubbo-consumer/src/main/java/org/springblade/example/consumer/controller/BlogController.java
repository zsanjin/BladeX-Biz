package org.springblade.example.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springblade.core.tool.api.R;
import org.springblade.example.provider.entity.Blog;
import org.springblade.example.provider.rpc.IBlogRpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Blog控制器
 *
 * @author Chill
 */
@RestController
@RequestMapping("blog")
public class BlogController {

	@Reference(
		version = "${blade.service.version}",
		mock = "org.springblade.example.consumer.rpc.BlogMock",
		//stub = "org.springblade.example.consumer.rpc.BlogStub",
		check = false
	)
	private IBlogRpc rpc;

	@GetMapping("detail/{id}")
	public R<Blog> detail(@PathVariable Integer id) {
		Blog detail = rpc.detail(id);
		return R.data(detail);
	}

}

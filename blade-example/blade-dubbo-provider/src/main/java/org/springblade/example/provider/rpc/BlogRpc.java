package org.springblade.example.provider.rpc;

import org.apache.dubbo.config.annotation.Service;
import org.springblade.example.provider.entity.Blog;

/**
 * BlogRpc实现类
 *
 * @author Chill
 */
@Service(
	version = "${blade.service.version}"
)
public class BlogRpc implements IBlogRpc {
	@Override
	public Blog detail(Integer id) {
		Blog blog = new Blog();
		blog.setId(id);
		blog.setTitle("博客标题");
		blog.setContent("博客内容");
		return blog;
	}
}

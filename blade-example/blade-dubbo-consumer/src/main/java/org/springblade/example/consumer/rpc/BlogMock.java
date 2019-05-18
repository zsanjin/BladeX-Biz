package org.springblade.example.consumer.rpc;


import org.springblade.example.provider.entity.Blog;
import org.springblade.example.provider.rpc.IBlogRpc;

/**
 * 降级容错
 *
 * @author Chill
 */
public class BlogMock implements IBlogRpc {
	@Override
	public Blog detail(Integer id) {
		return null;
	}
}

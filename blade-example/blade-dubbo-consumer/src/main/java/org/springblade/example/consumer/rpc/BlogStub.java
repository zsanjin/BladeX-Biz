package org.springblade.example.consumer.rpc;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.example.provider.entity.Blog;
import org.springblade.example.provider.rpc.IBlogRpc;

/**
 * 本地存根
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class BlogStub implements IBlogRpc {

	private IBlogRpc rpc;

	@Override
	public Blog detail(Integer id) {
		try {
			return rpc.detail(id);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		}
	}
}

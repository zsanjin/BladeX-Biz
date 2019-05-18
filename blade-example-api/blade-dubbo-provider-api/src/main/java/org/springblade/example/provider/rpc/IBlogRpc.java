package org.springblade.example.provider.rpc;

import org.springblade.example.provider.entity.Blog;

/**
 * RPC接口类
 *
 * @author Chill
 */
public interface IBlogRpc {

	/**
	 * Blog详情
	 *
	 * @param id 主键
	 * @return
	 */
	Blog detail(Integer id);
}

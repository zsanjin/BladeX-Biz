package org.springblade.example.provider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Blog实体类
 *
 * @author Chill
 */
@Data
public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;

}

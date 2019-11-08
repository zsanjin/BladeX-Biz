package org.springblade.example.poi.test.entity.onettomany.hasname;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * 需求梳理表
 *
 * @author Walt
 */
@Data
public class DemandEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 需求部门名称
	 */
	@Excel(name = "部门", needMerge = true, width = 20)
	private String deptName = "";

	/**
	 * 编码
	 */
	@Excel(name = "供需编码", needMerge = true, width = 20)
	private String code;

	/**
	 * 名称
	 */
	@Excel(name = "供需名称", needMerge = true, width = 20)
	private String name;

	/**
	 * 类别
	 */
	@Excel(name = "类别(数据字典)", needMerge = true, dict = "category")
	private Integer category;

	/**
	 * 年平均办件量
	 */
	@Excel(name = "年办件量", needMerge = true)
	private Long handleTotal;
	@ExcelCollection(name = "需求材料表")
	private List<SupMaterialEntity> supMaterialList2 = Lists.newArrayList();
	/**
	 * 需求材料表
	 */
	@ExcelCollection(name = "需求材料表")
	private List<SupMaterialEntity> supMaterialList = Lists.newArrayList();

}

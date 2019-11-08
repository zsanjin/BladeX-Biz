package org.springblade.example.poi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class CmsActivityUserTO {
	@Getter
	@Setter
	private String uuid;
	@Getter
	@Setter
	private String company_uuid;
	@Getter
	@Setter
	private String unit_uuid;
	@Getter
	@Setter
	private String city_uuid;
	@Getter
	@Setter
	private String department_uuid;
	@Getter
	@Setter
	private String area_uuid;
	@Getter
	@Setter
	@Excel(name = "公司", width = 20, isImportField = "true")
	private String company;
	@Getter
	@Setter
	@Excel(name = "单位", isImportField = "true")
	private String unit;
	@Getter
	@Setter
	@Excel(name = "部门", isImportField = "true", isWrap = false)
	private String department;
	@Getter
	@Setter
	@Excel(name = "城市", isImportField = "true")
	private String city;
	@Getter
	@Setter
	@Excel(name = "园区", isImportField = "true")
	private String area;
	@Getter
	@Setter
	@Excel(name = "姓名", isImportField = "true")
	private String name;

	@Getter
	@Setter
	@Excel(name = "工号", width = 15, isImportField = "true")
	private String job_num;
	@Getter
	@Setter
	@Excel(name = "手机号", width = 13, isImportField = "true")
	private String phone;
	@Getter
	@Setter
	@Excel(name = "状态", isImportField = "true")
	private String dimission;

	private Integer is_dimission;

	public Integer getIs_dimission() {
		if ("在职".equals(dimission)) {
			is_dimission = 0;
		} else {
			is_dimission = 1;
		}
		return is_dimission;
	}

}

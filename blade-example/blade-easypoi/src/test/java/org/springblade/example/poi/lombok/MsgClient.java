package org.springblade.example.poi.lombok;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;


/**
 * @author JueYue
 * 2014-09-22 16:03:32
 * @version V1.0
 * @Title: Entity
 * @Description: 通讯录
 */
@Data
public class MsgClient implements java.io.Serializable {
	// 电话号码(主键)
	@Excel(name = "电话号码")
	private String clientPhone = null;
	// 客户姓名
	@Excel(name = "姓名")
	private String clientName = null;
	// 备注
	@Excel(name = "备注")
	private String remark = null;
	// 生日
	@Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20)
	private Date birthday = null;
}

package org.springblade.example.poi.test.entity;

import cn.afterturn.easypoi.handler.inter.IExcelModel;

/**
 * Excel导入校验类
 *
 * @author JueYue
 * 2015年2月24日 下午2:21:07
 */
public class ExcelVerifyEntityOfMode extends ExcelVerifyEntity implements IExcelModel {

	private String errorMsg;

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}

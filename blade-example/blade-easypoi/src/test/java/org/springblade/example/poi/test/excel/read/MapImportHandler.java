package org.springblade.example.poi.test.excel.read;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.afterturn.easypoi.util.PoiPublicUtil;

import java.util.Map;

public class MapImportHandler extends ExcelDataHandlerDefaultImpl<Map<String, Object>> {

	@Override
	public void setMapValue(Map<String, Object> map, String originKey, Object value) {
		if (value instanceof Double) {
			map.put(getRealKey(originKey), PoiPublicUtil.doubleToString((Double) value));
		} else {
			map.put(getRealKey(originKey), value != null ? value.toString() : null);
		}
	}

	private String getRealKey(String originKey) {
		if (originKey.equals("交易账户")) {
			return "accountNo";
		}
		if (originKey.equals("姓名")) {
			return "name";
		}
		if (originKey.equals("客户类型")) {
			return "type";
		}
		return originKey;
	}
}

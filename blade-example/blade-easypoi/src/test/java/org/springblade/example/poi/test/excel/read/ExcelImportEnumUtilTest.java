package org.springblade.example.poi.test.excel.read;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.springblade.example.poi.test.en.EnumDataEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public class ExcelImportEnumUtilTest {

	///ExcelExportMsgClient 测试是这个到处的数据

	@Test
	public void test() {
		try {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			long start = new Date().getTime();
			List<EnumDataEntity> list = ExcelImportUtil.importExcel(
				new FileInputStream(
					new File(FileUtilTest.getWebRootPath("import/EnumDataEntity.xlsx"))),
				EnumDataEntity.class, params);

			Assert.assertEquals(6, list.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

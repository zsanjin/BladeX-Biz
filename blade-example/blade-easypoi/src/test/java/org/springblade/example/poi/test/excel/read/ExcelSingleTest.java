package org.springblade.example.poi.test.excel.read;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * Created by JueYue on 2017/7/11.
 */
public class ExcelSingleTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(ExcelSingleTest.class);

	@Test
	public void test() {
		try {
			ImportParams params = new ImportParams();
			params.setKeyMark("：");
			params.setReadSingleCell(true);
			params.setTitleRows(7);
			params.setLastOfInvalidRow(9);
			ExcelImportResult<Map> result = ExcelImportUtil.importExcelMore(
				new File("D:\\home\\logs\\excel\\dianshua_120181020172748.xlsx"),
				Map.class, params);
			for (int i = 0; i < result.getList().size(); i++) {
				System.out.println(result.getList().get(i));
			}
			Assert.assertTrue(result.getList().size() == 10);
			System.out.println(result.getMap());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}

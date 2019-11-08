package org.springblade.example.poi.test.excel.read;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.handler.inter.IReadHandler;
import org.springblade.example.poi.test.entity.MsgClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by jueyue on 19-6-23.
 */
@Slf4j
public class ExcelImportConcurrentTest {

	@Test
	public void test() {
		try {
			Date start = new Date();
			log.debug("start");
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			params.setConcurrentTask(true);
			params.setCritical(500);
			List<MsgClient> result = ExcelImportUtil.importExcel(
				new File(FileUtilTest.getWebRootPath("import/BigDataExport.xlsx")),
				MsgClient.class, params);
			log.debug("end,time is {}", ((new Date().getTime() - start.getTime()) / 1000));
			Assert.assertTrue(result.size() == 200000);
		} catch (Exception e) {
		}
	}

	@Test
	public void testSax() {
		try {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			long start = new Date().getTime();
			log.debug("start");
			List<MsgClient> result = new ArrayList<>();
			ExcelImportUtil.importExcelBySax(
				new FileInputStream(
					new File(FileUtilTest.getWebRootPath("import/BigDataExport.xlsx"))),
				MsgClient.class, params, new IReadHandler<MsgClient>() {
					@Override
					public void handler(MsgClient o) {
						result.add(o);
					}

					@Override
					public void doAfterAll() {
						System.out.println("全部执行完毕了--------------------------------");
						log.debug("end,time is {}", ((new Date().getTime() - start) / 1000));
					}
				});
			Assert.assertTrue(result.size() == 200000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

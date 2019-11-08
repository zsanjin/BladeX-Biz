package org.springblade.example.poi.csv;

import cn.afterturn.easypoi.csv.CsvExportUtil;
import cn.afterturn.easypoi.csv.entity.CsvExportParams;
import org.springblade.example.poi.test.entity.MsgClient;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvExportUtilTest {

	@Test
	public void exportCsv() throws IOException {
		List<MsgClient> list = new ArrayList<MsgClient>();
		Date start = new Date();
		CsvExportParams params = new CsvExportParams();
		for (int i = 0; i < 500; i++) {
			MsgClient client = new MsgClient();
			client.setBirthday(new Date());
			client.setClientName("小明" + i);
			client.setClientPhone("18797" + i);
			client.setCreateBy("JueYue");
			client.setId("1" + i);
			client.setRemark("测试" + i);
			list.add(client);
		}

		File savefile = new File("D:/home/excel/");
		if (!savefile.exists()) {
			savefile.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream("D:/home/excel/ExcelExportBigData.bigDataExport.csv");
		CsvExportUtil.exportCsv(params, MsgClient.class, null, fos);
		System.out.println("导出完成" + (new Date().getTime() - start.getTime()));
	}


	@Test
	public void exportCsvGBK() throws IOException {
		List<MsgClient> list = new ArrayList<MsgClient>();
		Date start = new Date();
		CsvExportParams params = new CsvExportParams();
		params.setEncoding(CsvExportParams.GBK);
		for (int i = 0; i < 50; i++) {
			MsgClient client = new MsgClient();
			client.setBirthday(new Date());
			client.setClientName("小明" + i);
			client.setClientPhone("18797" + i);
			client.setCreateBy("JueYue");
			client.setId("1" + i);
			client.setRemark("测试" + i);
			list.add(client);
		}

		File savefile = new File("D:/home/excel/");
		if (!savefile.exists()) {
			savefile.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream("D:/home/excel/ExcelExportBigData.bigDataExport_GBK.csv");
		CsvExportUtil.exportCsv(params, MsgClient.class, null, fos);
		System.out.println("导出完成" + (new Date().getTime() - start.getTime()));
	}

}

/**
 * Copyright 2013-2015 JueYue (qrb.jueyue@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.example.poi.test.pdf;

import cn.afterturn.easypoi.pdf.PdfExportUtil;
import cn.afterturn.easypoi.pdf.entity.PdfExportParams;
import org.junit.Before;
import org.junit.Test;
import org.springblade.example.poi.test.entity.StudentEntityImage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pdf 图片的导出
 * @author JueYue
 *   2016年1月8日 下午4:00:19
 */
public class PdfImageTest {

	List<StudentEntityImage> studentList = new ArrayList<StudentEntityImage>();

	@Before
	public void addStudent() {
		StudentEntityImage StudentEntityImage = new StudentEntityImage();
		StudentEntityImage.setId("11231");
		StudentEntityImage.setName("撒旦法司法局");
		StudentEntityImage.setBirthday(new Date());
		StudentEntityImage.setSex(1);
		StudentEntityImage.setImage("cn/afterturn/easypoi/test/pdf/image/test.png");
		studentList.add(StudentEntityImage);
		studentList.add(StudentEntityImage);
	}

	@Test
	public void imageTest() {
		PdfExportParams params = new PdfExportParams("学生信息");
		try {
			File file = new File("D:/home/excel//PdfImageTest.pdf");
			file.createNewFile();
			PdfExportUtil.exportPdf(params, StudentEntityImage.class, studentList,
				new FileOutputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

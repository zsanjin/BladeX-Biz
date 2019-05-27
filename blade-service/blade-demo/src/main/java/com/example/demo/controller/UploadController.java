package com.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springblade.core.minio.MinioTemplate;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * UploadController
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("/notice/upload")
@Api(value = "对象存储接口", tags = "oss上传测试")
public class UploadController {

	private MinioTemplate minioTemplate;

	/**
	 * minio上传demo
	 *
	 * @param file 上传文件
	 * @return String
	 */
	@SneakyThrows
	@PostMapping("put-minio-object")
	public R<String> putMinioObject(@RequestParam MultipartFile file) {
		minioTemplate.putFile(file);
		String link = minioTemplate.fileLink(Objects.requireNonNull(file.getOriginalFilename()));
		return R.data(link);
	}

}

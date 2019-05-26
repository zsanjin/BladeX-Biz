package org.springblade.demo.controller;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springblade.core.minio.MinioTemplate;
import org.springblade.core.qiniu.QiniuTemplate;
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
public class UploadController {

	private MinioTemplate minioTemplate;

	private QiniuTemplate qiniuTemplate;

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

	/**
	 * qiniu上传demo
	 *
	 * @param file    上传文件
	 * @param fileKey 上传文件key
	 * @return String
	 */
	@SneakyThrows
	@PostMapping("put-qiniu-object")
	public R<String> putQiniuObject(@RequestParam MultipartFile file, @RequestParam String fileKey) {
		qiniuTemplate.putFile(fileKey,file);
		String link = qiniuTemplate.fileLink(fileKey);
		return R.data(link);
	}

}

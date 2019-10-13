package com.wyh.springbootweb.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@PostMapping("fileUpolad")
	public Map<String, Object> fileUpload(MultipartFile file) throws Exception {
		String filePath = System.getProperty("user.dir") + File.separator + "file";
		String fileName = file.getOriginalFilename();
		String fileFull = filePath + File.separator + fileName;
		System.out.println("上传文件到-" + fileFull);
		file.transferTo(new File(fileFull));
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("msg", "OK");
				put("dir", fileFull);
			}
		};
	}

}

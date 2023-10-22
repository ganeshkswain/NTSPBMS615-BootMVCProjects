package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeekerData;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOperationController {
	@Autowired
	private IJobSeekerMgmtService service;
	@Autowired
	private Environment env;
	@Autowired
	private ServletContext sc;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showJSRegistrationForm(@ModelAttribute("js") JobSeekerData jsData) {
		return "jobseeker_register";

	}

	@PostMapping("/register")
	public String registerJSByUploadingFiles(@ModelAttribute("js") JobSeekerData jsData, Map<String, Object> map)
			throws Exception {

		// get upload folder location from proerties file
		String storeLocation = env.getRequiredProperty("upload.store");
		// if that not available then create it
		File file = new File(storeLocation);
		if (!file.exists())
			file.mkdir();

		// get inputStreams represent in the upload file content
		MultipartFile resumeFile = jsData.getResume();
		MultipartFile photoFile = jsData.getPhoto();
		InputStream isResume = resumeFile.getInputStream();
		InputStream isPhoto = photoFile.getInputStream();

		// get the names of the uploaded file
		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();

		// create out streams representing empty destination file
		OutputStream osResume = new FileOutputStream(file.getAbsolutePath() + "\\" + resumeFileName);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath() + "\\" + photoFileName);

		// perform file copy operations
		IOUtils.copy(isResume, osResume);
		IOUtils.copy(isPhoto, osPhoto);

		// close Stream
		isResume.close();
		osResume.close();
		isPhoto.close();
		osPhoto.close();

		// Prepare entity class object from model class object
		JobSeekerInfo jsinfo = new JobSeekerInfo();
		jsinfo.setJsName(jsData.getJsName());
		jsinfo.setJsAddrs(jsData.getJsAddrs());
		jsinfo.setPhotoPath(file.getAbsolutePath() + "\\" + resumeFileName);
		jsinfo.setResumePath(file.getAbsolutePath() + "\\" + photoFileName);

		// use service
		String msg = service.registerJobSeeker(jsinfo);

		// keep the uploaded file name and location in model attribute
		map.put("resultMsg", msg);
		map.put("resumeFile", resumeFileName);
		map.put("photoFile", photoFileName);

		// return LVN
		return "show_result";

	}

	@GetMapping("/list_js")
	public String showReport(Map<String, Object> map) {
		// use service
		List<JobSeekerInfo> list = service.fetchAllJobSeekers();
		map.put("jsList", list);
		return "show_report";
	}

	@GetMapping("/download")
	public String fileDownload(HttpServletResponse res, @RequestParam("jsId") Integer id,
			@RequestParam("type") String type) throws Exception {
		// get path of the file to be downloaded
		String filePath = null;
		if (type.equalsIgnoreCase("resume"))
			filePath = service.fetchResumePathByJsId(id);
		else
			filePath = service.fetchPhotoPathByJsId(id);
		System.out.println(filePath);
		// create File object representing file to be downloaded
		File file = new File(filePath);
		// get the length of the file and make it as the response content of the length
		res.setContentLengthLong(file.length());
		// get MIME type of the file and make it as the response content type
		String mimeType = sc.getMimeType(filePath);
		mimeType = mimeType == null ? "application/octet-stream" : mimeType;
		res.setContentType(mimeType);
		// Create input stream pointing to the file
		InputStream is = new FileInputStream(file);
		// create output stream pointing to response object
		OutputStream os = res.getOutputStream();
		// Instruct the browser to give the file content as downloadable file
		res.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		// write file content to response obj
		IOUtils.copy(is, os);
		// close the stream
		is.close();
		os.close();
		return null;
	}

}

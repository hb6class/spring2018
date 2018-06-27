package com.bit.myapp07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpDownController {
	String fpath="C:\\spring\\spring2018\\upload\\";

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public void upload(@RequestParam("sabun") int sabun
			,@RequestParam("upfile") MultipartFile upfile
			,Model model) {
		System.out.println(sabun);
		String origin = upfile.getOriginalFilename();
		File file= new File(fpath+origin);
		try {
			upfile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("filename", origin);
	}
	
	@RequestMapping("/download/{filename}")
	public void download(@PathVariable String filename,HttpServletResponse res) {
		File file=new File(fpath+filename);
		try {
			FileCopyUtils.copy(new FileInputStream(file), res.getOutputStream());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}















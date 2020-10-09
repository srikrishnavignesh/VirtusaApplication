package com.virtusa.neuralhack.bc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.neuralhack.bc.model.VideoInfo;
import com.virtusa.neuralhack.bc.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService service;
	
	@RequestMapping("/video")
	public ModelAndView uploadFile() {
		return new ModelAndView("upload");
	}
	
	@PostMapping("/video")
	@ResponseBody
	public  HashMap<String,String> addVideo(@RequestParam("file") MultipartFile vfile){
		
		return service.addVideo(vfile, vfile.getOriginalFilename());
		
		
	}
	
	@GetMapping("/videos")
	@ResponseBody
	public HashMap<String,Object> getAllVideos(){
		
		return service.getAllVideos();
	}
	
	@GetMapping("/video/{videoId}")
	@ResponseBody
	public ResponseEntity<InputStreamResource> getVideo(@PathVariable("videoId") long id){
		return service.getVideo(id);
	}
	
}

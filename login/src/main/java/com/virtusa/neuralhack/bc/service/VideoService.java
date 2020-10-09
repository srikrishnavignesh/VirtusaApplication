package com.virtusa.neuralhack.bc.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.virtusa.neuralhack.bc.dao.VideoDao;
import com.virtusa.neuralhack.bc.model.Video;
import com.virtusa.neuralhack.bc.model.VideoInfo;
import com.virtusa.neuralhack.bc.model.VideoResponse;

@Service
public class VideoService {

	@Value("${app.upload.dir}")
	public String mainDir;
	
	@Autowired
	private VideoDao videoAccess;
	
	public HashMap<String,String> addVideo(MultipartFile vfile,String desc) {
		
		HashMap<String,String> res=new HashMap<String,String>();
		
		try {
			
			Video v=new Video();
			v.setDesc(desc);
			Path copyLocation=Paths.get(mainDir+File.separator+StringUtils.cleanPath(vfile.getOriginalFilename()));
			v.setUrl(copyLocation.toString());
			Files.copy(vfile.getInputStream(),copyLocation,StandardCopyOption.REPLACE_EXISTING);
			videoAccess.save(v);
			
			res.put(VideoInfo.STATUS, VideoInfo.UPLOAD_SUCCESS);
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			res.put(VideoInfo.STATUS, VideoInfo.UPLOAD_FAILURE);
			res.put(VideoInfo.ERROR, e.getMessage());
		}
		return res;
	}

	public HashMap<String,Object> getAllVideos() {
		
		HashMap<String,Object> res=new HashMap<String,Object>();
		
		try {
				List<Object> list=videoAccess.findAllVideoNames();
				res.put(VideoInfo.VIDEOS, list);
				res.put(VideoInfo.STATUS, VideoInfo.LIST_SUCCESS);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			res.put(VideoInfo.STATUS,VideoInfo.LIST_FAILURE);
			res.put(VideoInfo.ERROR, e.getMessage());
		}
		return res;
	}

	public ResponseEntity<InputStreamResource> getVideo(long id) {
	try {
		
		Video vfile=videoAccess.findById(id).get();
		if(vfile!=null) {
					File file = new File(vfile.getUrl());
					String mimeType = URLConnection.guessContentTypeFromName(file.getName());
					InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
					return ResponseEntity.ok()
						   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
						   .contentType(MediaType.parseMediaType(mimeType))
						   .contentLength(file.length()) 
						   .body(resource);
			}
		}
		catch(Exception e) {
		
		}
		return ResponseEntity.badRequest().build();
	}
}

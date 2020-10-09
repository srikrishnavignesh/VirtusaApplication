package com.virtusa.neuralhack.bc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {

	@Id
	@GeneratedValue
	long videoId;
	
	String description;
	
	String videoUrl;
	
	public Video() {
		
	}
	
	public long getVideoId() {
		return videoId;
	}

	
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public String getDesc() {
		return description;
	}


	public void setDesc(String desc) {
		this.description = desc;
	}

	
	public String getUrl() {
		return videoUrl;
	}

	
	public void setUrl(String url) {
		this.videoUrl = url;
	}
	
	
}

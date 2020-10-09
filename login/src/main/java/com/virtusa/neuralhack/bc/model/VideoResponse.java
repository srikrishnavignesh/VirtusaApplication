package com.virtusa.neuralhack.bc.model;

public class VideoResponse {

	String description;
	
	long videoId;

	public VideoResponse() {
		
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public long getId() {
		return videoId;
	}

	
	public void setId(long id) {
		this.videoId = id;
	}
	
	
}

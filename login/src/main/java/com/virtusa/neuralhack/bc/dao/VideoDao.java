package com.virtusa.neuralhack.bc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.Video;
import com.virtusa.neuralhack.bc.model.VideoResponse;

@Repository
public interface VideoDao extends JpaRepository<Video,Long>{
	
	@Query(value="select video_id,description from video",nativeQuery=true)
	public List<Object> findAllVideoNames();

}

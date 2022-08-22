package org.sap.service;

import org.sap.mapper.ReviewMapper;
import org.sap.model.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewServiceImpl implements ReviewService{
	@Autowired
	ReviewMapper rm;
	
	public void write(ReviewVo rvo) {
		
	}
}

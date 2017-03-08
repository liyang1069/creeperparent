package com.creeperImpl.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.projectapi.teardowall.entity.DonateInfo;

//@CreeperMapper
@Mapper
public interface DonateInfoMapper {
	
	List<DonateInfo> getAllDonateInfos();
	
	void insert(DonateInfo donateInfoMapper);
	
}

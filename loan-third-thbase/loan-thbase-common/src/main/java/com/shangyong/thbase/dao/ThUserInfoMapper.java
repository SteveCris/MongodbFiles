package com.shangyong.thbase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangyong.thbase.entity.ThUserInfo;
import com.shangyong.thcore.vo.BaseUserInfoVo;

public interface ThUserInfoMapper {
	int deleteByPrimaryKey(String userInfoId);

	int insert(ThUserInfo record);

	int insertSelective(ThUserInfo record);

	ThUserInfo selectByPrimaryKey(String userInfoId);

	int updateByPrimaryKeySelective(ThUserInfo record);

	int updateByPrimaryKey(ThUserInfo record);

	int insertOrIgnore(ThUserInfo record);

	List<BaseUserInfoVo> listBaseUserInfoVo(@Param("identityNoPrefix") String identityNoPrefix,
			@Param("mobilePrefix") String mobilePrefix);
	
	BaseUserInfoVo getBaseUserInfoVo(@Param("identityNo") String identityNo);
}
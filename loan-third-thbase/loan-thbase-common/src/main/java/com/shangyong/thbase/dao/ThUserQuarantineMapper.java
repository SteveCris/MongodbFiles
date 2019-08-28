package com.shangyong.thbase.dao;

import com.shangyong.thbase.entity.ThUserQuarantine;
import org.apache.ibatis.annotations.Param;

public interface ThUserQuarantineMapper {
    int deleteByPrimaryKey(String userQuarantineId);

    int insert(ThUserQuarantine record);

    int insertSelective(ThUserQuarantine record);

    ThUserQuarantine selectByPrimaryKey(String userQuarantineId);

    int updateByPrimaryKeySelective(ThUserQuarantine record);

    int updateByPrimaryKey(ThUserQuarantine record);

    /**
     * 根据appid和md5查找隔离用户
     * @param appid
     * @param phoneIdNumberMd5
     * @return
     */
    ThUserQuarantine selectByAppidAndphoneIdNumberMd5(@Param("appid") String appid, @Param("phoneIdNumberMd5") String phoneIdNumberMd5);

	int insertOrIgnore(ThUserQuarantine thUserQuarantine);

	ThUserQuarantine getBaseUserInfoVoByIdentityNo(@Param("appid") String appid, @Param("identityNo") String identityNo);

}
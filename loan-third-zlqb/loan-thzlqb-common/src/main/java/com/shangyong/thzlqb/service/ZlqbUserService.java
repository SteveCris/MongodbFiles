package com.shangyong.thzlqb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shangyong.thzlqb.bo.CoreAuditUserInfoBo;
import com.shangyong.thzlqb.dto.UserInfoDto;
import com.shangyong.thzlqb.entity.ZlqbBandCardInfo;
import com.shangyong.thzlqb.entity.ZlqbLinkman;
import com.shangyong.thzlqb.entity.ZlqbUserDevice;
import com.shangyong.thzlqb.entity.ZlqbUserInfo;

import java.util.List;

/**
 * 用户相关服务
 * 
 * @author caijunjun
 * @date 2019年7月19日
 */
public interface ZlqbUserService {

	/**
	 * 
	 * 获取审核用户信息
	 * 
	 * @param orderNo
	 * @return
	 */
	CoreAuditUserInfoBo getCoreAuditUserInfoBo(String orderNo);

	/**
	 * 处理校验请求
	 * 
	 * @param request
	 * @return
	 */
	JsonNode processCheckUser(ObjectNode request);

	/*
	 * @param userinfo
	 *插入DB记录
	 */
	void insertDto(ZlqbUserInfo userinfo);

	/**
	 * 插入联系人信息
	 * @param linkmanList
	 */
	void saveBatchLinkMan(List<ZlqbLinkman> linkmanList);

    ZlqbUserInfo selectOne(String orderNo);

    void saveUserBandCardDto(ZlqbBandCardInfo info);

    String  getBankCardByIdCard(String idCard);

	Long selectCount(byte isRefresh);

    List<ZlqbUserInfo> selectAllPageInfoByLimit(byte status, int startNum, int pageSize);

	boolean refreshUserInfoFromMongoDB(UserInfoDto userInfoDto);

    void insertDeviceDto(ZlqbUserDevice zlqbUserDevice);
}

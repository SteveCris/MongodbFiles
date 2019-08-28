package com.shangyong.thbase.controller;

import com.shangyong.thbase.contants.CoreContants;
import com.shangyong.thbase.enums.CoreResult;
import com.shangyong.thbase.enums.CoreResultEnum;
import com.shangyong.thbase.service.BaseUserService;
import com.shangyong.thcore.dto.CheckUserInfoDto;
import com.shangyong.thcore.vo.BaseUserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(tags = "cjj-蔡俊俊-用户相关接口")
@RestController
@RequestMapping("/baseUser" + CoreContants.PATH_APPID)
public class BaseUserController {

	@Autowired
	private BaseUserService baseUserService;

	@ApiOperation(value = "校验并返回用户相关信息")
	@ResponseBody
	@RequestMapping(value = "/check/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CoreResult<BaseUserInfoVo> checkAndSearch(@PathVariable("appid") String appid,
			@RequestBody CheckUserInfoDto checkUserInfoDto) {
		checkUserInfoDto.setAppid(appid);
		if (checkUserInfoDto.getType() == 0) {
			return CoreResultEnum.SUCCESS.with(baseUserService.checkAndGetUserInfo(checkUserInfoDto));
		} else if (checkUserInfoDto.getType() == 1) {
			return CoreResultEnum.SUCCESS
					.with(baseUserService.checkAndGetUserInfo(appid, checkUserInfoDto.getIdentityNo()));
		} else {
			return CoreResultEnum.FAILURE.with();
		}

	}

}

package com.shangyong.thzlqb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shangyong.thcore.vo.OrderLoanVo;
import com.shangyong.thzlqb.enums.CoreResult;
import com.shangyong.thzlqb.enums.CoreResultEnum;
import com.shangyong.thzlqb.listener.service.SelfConsumerService;
import com.shangyong.thzlqb.service.ZlqbOrderStatusService;
import com.shangyong.thzlqb.zlqb.utils.ZlqbUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "cjj-蔡俊俊-助力钱包 任务接口")
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ZlqbOrderStatusService zlqbOrderStatusService;

	@Autowired
	private SelfConsumerService selfConsumerService;

	@ApiOperation(value = "手动推送订单状态信息")
	@ResponseBody
	@RequestMapping(value = "/orderStatus/push", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CoreResult<Void> pushOrderStatus(@RequestParam("token") String token, //
			@RequestParam("orderNo") String orderNo) {

		if (!ZlqbUtil.checkToken(token)) {
			return CoreResultEnum.AUTH_ERROR.with();
		}

		if (zlqbOrderStatusService.pushOrder(orderNo)) {
			return CoreResultEnum.SUCCESS.with();
		} else {
			return CoreResultEnum.FAILURE.with();
		}
	}

	@ApiOperation(value = "手动推送中间订单状态信息")
	@ResponseBody
	@RequestMapping(value = "/orderStatus/pushMiddle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CoreResult<Void> pushMiddleOrder(@RequestParam("token") String token, //
			@RequestParam("orderNo") String orderNo, @RequestBody OrderLoanVo orderLoanVo) {

		if (!ZlqbUtil.checkToken(token)) {
			return CoreResultEnum.AUTH_ERROR.with();
		}

		if (zlqbOrderStatusService.pushMiddleOrder(orderNo, orderLoanVo)) {
			return CoreResultEnum.SUCCESS.with();
		} else {
			return CoreResultEnum.FAILURE.with();
		}
	}

	@ApiOperation(value = "手动推送取消绑卡记录")
	@ResponseBody
	@RequestMapping(value = "/cancelBankAndOrderStatus/push", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CoreResult<Void> cancelBankAndOrderStatus(@RequestParam("token") String token, //
			@RequestParam("orderNo") String orderNo, @RequestParam("bankCardNo") String bankCardNo) {

		if (!ZlqbUtil.checkToken(token)) {
			return CoreResultEnum.AUTH_ERROR.with();
		}

		if (zlqbOrderStatusService.concelBankInfoAndPushOrder(orderNo, bankCardNo)) {
			return CoreResultEnum.SUCCESS.with();
		} else {
			return CoreResultEnum.FAILURE.with();
		}
	}

	@ApiOperation(value = "手动刷客户的公司信息字段")
	@ResponseBody
	@RequestMapping(value = "/refreshCustomer/push", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CoreResult<Void> refreshCustomerPush(@RequestParam("token") String token, //
			@RequestParam("state") String state) {

		if (!ZlqbUtil.checkToken(token)) {
			return CoreResultEnum.AUTH_ERROR.with();
		}
		selfConsumerService.refreshCustomeInfoFromMongoDB(state);
		return CoreResultEnum.SUCCESS.with();
	}

}

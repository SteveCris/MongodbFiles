package com.shangyong.thorder.service;

import com.shangyong.thcore.vo.OrderRepaymentPlanVo;
import com.shangyong.thcore.vo.OrderRepaymentVo;
import com.shangyong.thcore.vo.RepaymentShowVo;

/**
 * 订单还款服务
 * 
 * @author caijunjun
 * @date 2019年3月22日
 */
public interface OrderRepaymentService {

	/**
	 * 试算接口
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	OrderRepaymentPlanVo pilotcalculation(String appid, String orderId);

	/**
	 * 获取订单还款计划
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	OrderRepaymentPlanVo getOrderRepaymentPlanVo(String appid, String orderId);

	/**
	 * 还款成功获取还款计划
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	OrderRepaymentPlanVo getActualOrderRepaymentPlanVo(String appid, String orderId);

	/**
	 * 获取还款总填充对象
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	OrderRepaymentVo getOrderRepaymentVo(String appid, String orderId);

	/**
	 * 一键还款
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	boolean oneKeyRepayment(String appid, String orderId);

	/**
	 * 微信还款
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	RepaymentShowVo weChatRepayment(String appid, String orderId);

	/**
	 * 快捷还款
	 * 
	 * @param appid
	 * @param orderId
	 * @return
	 */
	RepaymentShowVo quickRepayment(String appid, String orderId);

}

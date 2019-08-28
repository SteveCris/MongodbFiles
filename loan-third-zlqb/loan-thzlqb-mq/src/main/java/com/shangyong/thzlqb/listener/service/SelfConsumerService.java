package com.shangyong.thzlqb.listener.service;

import com.shangyong.thzlqb.event.PushEvent;

/**
 * 私有消费者，主要消费 自有系统消息
 * 
 * @author caijunjun
 * @date 2019年7月19日
 */
public interface SelfConsumerService {

	/**
	 * 处理 推单有时限
	 * 
	 * @param pushEvent
	 * @return
	 */
	boolean processPushTime(PushEvent pushEvent);

	/**
	 * 处理 订单相关数据落库
	 * 
	 * @param pushEvent
	 * @return
	 */
	boolean processPushFall(PushEvent pushEvent);

	/**
	 * 处理 订单推送审核
	 * 
	 * @param pushEvent
	 * @return
	 */
	boolean processPushAudit(PushEvent pushEvent);


	boolean refreshCustomeInfoFromMongoDB(String status);

}

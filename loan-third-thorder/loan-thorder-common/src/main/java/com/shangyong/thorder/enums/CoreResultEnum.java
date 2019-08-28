package com.shangyong.thorder.enums;

public enum CoreResultEnum {
	SUCCESS("200", "处理成功"), //
	FAILURE("500", "处理失败"), //
	ERROR("99999", "系统异常"), //

	COMMON_FAILURE("1000", "通用处理失败"), //
	CLICK_REPEAT("1001", "请不要重复点击"), //
	PARAM_ERROR("1002", "参数校验异常"), //
	PARAM_MISSING_ERROR("1003", "参数缺少"), //
	NULL_ERROR("1004", "空异常"), //
	AUTH_ERROR("1005", "没有权限"), //
	RISK_CLICK("1006", "风险操作"), //

	STATUS_ERROR("2000", "状态异常"), //
	NO_ORDER("2001", "订单不存在"), //
	REMOTE_ERROR("2002", "远程调用异常"), //
	NON_SUPPORT_BANK("2003", "不支持的银行"), //
	MOBILE_ERROR("2004", "手机号格式不正确"), //
	REPAYMENT_ERROR("2005", "已经存在借贷信息，无法取消"),//
	CANCEL_ERROR("2006", "订单已经完结，无法取消"),//
	NOT_SUPPORT_CREDIT_TYPE_ERROR("2007", "不支持的银行卡类别"),//
	NOT_EXIST_BIND("2008", "不存在绑卡信息，需要进行绑卡操作"),//

	; // 加注释，防止格式化格式

	private CoreResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 错误描述
	 */
	private String message;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public <T> CoreResult<T> with(T body) {
		return new CoreResult<>(this, body);
	}

	public <T> CoreResult<T> with() {
		return with((T) null);
	}
}

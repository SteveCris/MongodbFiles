package com.shangyong.thzlqb.sign;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

import com.shangyong.loan.ext.util.JacksonUtil;

public class AuditSignUtil {

	private static String merchantKey = "SHANGYONGRISK";

	@SuppressWarnings("unchecked")
	public static boolean checkSign(Object obj, String sign) {
		String s = createSign(JacksonUtil.build().parse(obj, SortedMap.class), merchantKey);
		return sign.equalsIgnoreCase(s);
	}

	private static String createSign(Map<String, String> param, String merchantKey) {
		if (param == null) {
			throw new IllegalArgumentException("数据不能为空");
		}
		if (param.isEmpty()) {
			return null;
		}
		if (merchantKey == null) {
			throw new IllegalArgumentException("安全校验码数据不能为空");
		}
		Map<String, String> sortedMap = new TreeMap<>(param);
		if (sortedMap.containsKey("sign")) {
			sortedMap.remove("sign");
		}
		StringBuilder stringToSign = new StringBuilder();
		if (sortedMap.size() > 0) {
			for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
				if (entry.getValue() != null && !"".equals(entry.getValue().trim())) {
					stringToSign.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				}
			}
			stringToSign.deleteCharAt(stringToSign.length() - 1);
		}
		stringToSign.append(merchantKey);
		return DigestUtils.md5Hex(stringToSign.toString());
	}
}

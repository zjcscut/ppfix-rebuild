package com.ppfix.web.common;

public interface CST {
	// json页面
	static final String JSON_MSG = "msg";

	// 统一成功返回
	static final String SUCCESS = "1";
	static final String SUCCESS_INFO = "操作成功";

	// 统一没登录
	static final String NOT_LOGIN = "-1";
	static final String NOT_LOGIN_INFO = "未登录";

	// 统一加签错误
	static final String SIGN_ERROR = "-2";
	static final String SIGN_ERROR_INFO = "签名错误";

	// 统一SP错误
	static final String SP_ERROR = "-3";
	static final String SP_ERROR_INFO = "SP错误";

	// 統一用户不存在错误码
	static String USER_NOT_EXITS = "-4";
	static String USER_NOT_EXITS_INFO = "用户不存�?";

	// 统一系统出错
	static String SYSTEM_ERROR = "-5";
	static String SYSTEM_ERROR_INFO = "网络繁忙";

	// 登录返回
	static final int LOGIN_SUCCESS = 1;
	static final int NO_USER = -1;
	static final int PASSWORD_ERROR = -2;

}

package com.ppfix.web.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ppfix.web.common.CST;
import com.ppfix.web.util.JsonUtils;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
	private final Logger log = Logger.getLogger(this.getClass());

	private static String TOKEN = "?";
	private static String AND = "&";
	private static String EQUAL = "=";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object o, Exception e) {
		Map<String, String> paramMap = httpServletRequest.getParameterMap();
		StringBuffer sb = new StringBuffer(httpServletRequest.getRequestURI())
				.append(TOKEN);
		try {
			if (paramMap != null && paramMap.size() != 0) {
				for (Map.Entry entry : paramMap.entrySet()) {
					sb.append(entry.getKey()).append(EQUAL)
							.append(((String[]) entry.getValue())[0])
							.append(AND);
				}
			}
		} catch (Throwable t) {
			log.error(
					"http param parse error: "
							+ JsonUtils.toJson(httpServletRequest
									.getParameterMap()), t);
		}
		log.error(sb.toString(), e);
		ModelAndView modelAndView = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", CST.SYSTEM_ERROR);
		map.put("info", CST.SYSTEM_ERROR_INFO);
		modelAndView.addObject(CST.JSON_MSG, JsonUtils.toJson(map));
		return modelAndView;
	}
}

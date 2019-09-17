package com.ffcs.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ffcs.controller.GoodsController;
/**
 * 
* @ClassName: SqlFilter 
* @Description: TODO(��ֹSQLע�� ���˿ͻ��������������ַ�) 
* @author ����� 
* @date 2019��8��30�� ����2:42:22 
*
 */
public class SqlFilter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<������sql������>>>>>>>>>>>>>>>>>>>>");
		@SuppressWarnings("unchecked")
		Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                value = clearXss(value);
            }
        }
        logger.info("<<<<<<<<<<<<<<<<<<<�뿪��sql������>>>>>>>>>>>>>>>>>>>>");
        return true;
	}
	/**
	 * 
	* @Title: clearXss 
	* @Description: TODO(���˺�ת�������е� �����ַ�) 
	* @param @param value
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws
	 */
	private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
                "\"\"");
        value = value.replace("script", "");
        return value;
    }



}

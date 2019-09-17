package com.ffcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.bean.Order;
import com.ffcs.bean.orderDetail;
import com.ffcs.service.IOrderDetailService;
import com.ffcs.service.IOrderService;

/**
 * 
* @ClassName: OrderDetailController 
* @Description: TODO(������ϸ ��) 
* @author ����� 
* @date 2019��8��31�� ����2:18:21 
*
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
	@Autowired
	IOrderDetailService iOrderDetailService;
	@Autowired
	IOrderService iOrderService;
	/**
	 * 
	* @Title: orderDetailList 
	* @Description: TODO(��ȡ ������ϸ�б�) 
	* @param @param request
	* @param @param response
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("orderDetailList")
	public Map<String,Object> orderDetailList(){
		final Logger logger = LoggerFactory.getLogger(OrderDetailController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		try{
			List<Order> osderList = iOrderService.selectAll();
			orderDetailMap.put("status", "0");
			orderDetailMap.put("dataList",osderList);
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			orderDetailMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return orderDetailMap;
     }
}

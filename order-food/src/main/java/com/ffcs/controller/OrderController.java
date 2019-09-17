package com.ffcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.bean.Goods;
import com.ffcs.bean.Order;
import com.ffcs.bean.OrderCountByDay;
import com.ffcs.service.IOrderDetailService;
import com.ffcs.service.IOrderService;
import com.ffcs.util.MySessionContext;

/**
 * 
* @ClassName: OrderController 
* @Description: TODO(����) 
* @author ����� 
* @date 2019��8��29�� ����9:02:48 
*
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	IOrderService iOrderService;
	@Autowired
	IOrderDetailService iOrderDetailService;
	/**
	 * 
	* @Title: order 
	* @Description: TODO(֧�� �����ɶ���) 
	* @param @param request
	* @param @param response
	* @param @param session
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("payMent")
	public Map<String,Object> order(@RequestBody Goods goods,HttpServletRequest request){
		final Logger logger = LoggerFactory.getLogger(OrderController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> payMap = new HashMap<String, Object>();
		try{
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if("sessionId".equals(cookie.getName())){
					String sessionID = cookie.getValue();
					//��session�л�ȡ��ǰ �ĵ�½�˺�
					String userName = (String) MySessionContext.getInstance().getSession(sessionID).getAttribute("userName");
					//���浱ǰ �¶������˺�
					goods.setIntrodece(userName);
				}
			}
			Order insertGood = iOrderService.insertGood(goods);
			payMap.put("status", "0");
			payMap.put("data", insertGood);
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			payMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return payMap;
     }
	/**
	 * 
	* @Title: orderList 
	* @Description: TODO(��ȡ �����б�) 
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("orderList")
	public Map<String,Object> orderList(HttpServletRequest request,HttpServletResponse response){
		final Logger logger = LoggerFactory.getLogger(OrderController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> payMap = new HashMap<String, Object>();
		List<Order> osderList=null;
		Order od =new Order();
		od.setMoney("3");
		try{
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if("sessionId".equals(cookie.getName())){
					String sessionID = cookie.getValue();
					//��session�л�ȡ��ǰ �ĵ�½�˺�
					String userName = (String) MySessionContext.getInstance().getSession(sessionID).getAttribute("userName");
					 osderList = iOrderService.selectAll(userName);
				}
			}
			payMap.put("status", "0");
			payMap.put("dataList",osderList);
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			payMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return payMap;
     }
	/**
	 * 
	* @Title: delOrder 
	* @Description: TODO(�˶���) 
	* @param @param request
	* @param @param response
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("delOrder")
	public Map<String,Object> delOrder(Order order){
		final Logger logger = LoggerFactory.getLogger(OrderController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> delMap = new HashMap<String, Object>();
		try{
			iOrderService.delete(order.getOrderId());
			iOrderDetailService.delete(order.getOrderId());
			delMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			delMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return delMap;
     }
	/**
	 * 
	* @Title: selectOrdeByDay 
	* @Description: TODO(��ѯÿ�� ���������� �ܽ��) 
	* @param @param order
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("selectOrdeByDay")
	public Map<String,Object> selectOrdeByDay(){
		final Logger logger = LoggerFactory.getLogger(OrderController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		try{
			List<OrderCountByDay> selectOrderByDay = iOrderService.selectOrderByDay();
			orderMap.put("data",selectOrderByDay);
			orderMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			orderMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return orderMap;
     }
}

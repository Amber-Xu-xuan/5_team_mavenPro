package com.ffcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.bean.Goods;
import com.ffcs.bean.goodsListByPage;
import com.ffcs.bean.orderDetailByGood;
import com.ffcs.service.IGoodsService;

/**
 * 
* @ClassName: GoodsController 
* @Description: TODO(商品类 处理商品相关功能 比如商品列表等) 
* @author 黄青才
* @date 2019年8月26日 下午5:12:14 
*
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	 IGoodsService iGoodsService;
	/**
	 * 
	* @Title: getGoodsList 
	* @Description: TODO(返回商品列表数据) 
	* @param page：当前页；pageSize：每页展示数；sort：升降序标记；  priceLevel：价格等级
	* @return Map<String,Object>   
	* @throws
	 */
	@ResponseBody
	@RequestMapping("list")
     public Map<String,Object> getGoodsList(goodsListByPage goodList){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		Map<String, Object> goodsListsMap = new HashMap<String, Object>();
		try{
			System.out.println(goodList);
			List<Goods> goodsList = iGoodsService.selectPageOfGoods(goodList);
			int total = iGoodsService.selectCountOfGoods(goodList);
			goodsListsMap.put("status", "0");
			goodsListsMap.put("count", total);
			goodsListsMap.put("total", goodsList.size());
			goodsListsMap.put("datalist", goodsList);
		}catch (Exception e) {
			goodsListsMap.put("status", "1");
			goodsListsMap.put("msg", "异常");
			logger.error("error:[{}ms]",e);
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return goodsListsMap;
     }
	/**
	 * 
	* @Title: getGoodsListById 
	* @Description: TODO(根据商品id 获取 商品列表) 
	* @param @param goodIds
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("cartList")
     public Map<String,Object> getGoodsListById(Goods goods){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> goodsListsMap = new HashMap<String, Object>();
		try{
			System.out.println("数组ID:"+goods);
			List<Goods> goodsList = iGoodsService.selectById(goods);
			System.out.println("goodlisyBYID:"+goodsList);
			goodsListsMap.put("status", "0");
			goodsListsMap.put("datalist", goodsList);
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			goodsListsMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return goodsListsMap;
     }
	/**
	 * 
	* @Title: removeGood 
	* @Description: TODO(删除商品) 
	* @param @param goods
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("remove")
     public Map<String,Object> removeGood(Goods goods){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> removeMap = new HashMap<String, Object>();
		try{
			System.out.println("数组ID:"+goods);
			iGoodsService.delete(goods.getGoodId());
			removeMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			removeMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return removeMap;
     }
	/**
	 * 
	* @Title: addGood 
	* @Description: TODO(添加商品) 
	* @param @param goods
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("addGood")
     public Map<String,Object> addGood(@RequestBody Goods goods){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> addMap = new HashMap<String, Object>();
		try{
			System.out.println("goods:"+goods);
			iGoodsService.insert(goods);
			addMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			addMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return addMap;
     }
	/**
	 * 
	* @Title: editGood 
	* @Description: TODO(修改 商品) 
	* @param @param goods
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("editGood")
     public Map<String,Object> editGood(@RequestBody Goods goods){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> editMap = new HashMap<String, Object>();
		try{
			System.out.println("goods:"+goods);
			iGoodsService.update(goods);
			editMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			editMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return editMap;
     }
	/**
	 * 
	* @Title: orderDetailList 
	* @Description: TODO(根据商品 查询订单明细) 
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("orderDetailList")
     public Map<String,Object> orderDetailList(){
		final Logger logger = LoggerFactory.getLogger(GoodsController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		Map<String, Object> editMap = new HashMap<String, Object>();
		try{
		
			List<orderDetailByGood> orderList = iGoodsService.selectOrderDetailByGoods();
			editMap.put("status", "0");
			editMap.put("data", orderList);
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			editMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return editMap;
     }
}

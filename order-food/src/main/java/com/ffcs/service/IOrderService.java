package com.ffcs.service;

import java.util.List;

import com.ffcs.bean.Goods;
import com.ffcs.bean.Order;
import com.ffcs.bean.OrderCountByDay;

public interface IOrderService extends BaseService<Order>{
	/**
	 * 
	* @Title: insertGood 
	* @Description: TODO(用于 controller 层 统一 goods 参数传入service) 
	* @param @param good    设定文件 
	* @return void    返回类型 
	* @throws
	 */
     public Order insertGood(Goods good);
     /**
      * 
     * @Title: selectAll 
     * @Description: TODO(获取 订单列表) 
     * @param @param userName
     * @param @return    设定文件 
     * @return List<Order>    返回类型 
     * @throws
      */
     public List<Order> selectAll(String userName);
     /**
      * 
     * @Title: selectOrderByDay 
     * @Description: TODO(统计每天订单 数量 和总金额) 
     * @param @return    设定文件 
     * @return List<OrderCountByDay>    返回类型 
     * @throws
      */
     public List<OrderCountByDay> selectOrderByDay();
}

package com.ffcs.service;

import java.util.List;

import com.ffcs.bean.Goods;
import com.ffcs.bean.Order;
import com.ffcs.bean.OrderCountByDay;

public interface IOrderService extends BaseService<Order>{
	/**
	 * 
	* @Title: insertGood 
	* @Description: TODO(���� controller �� ͳһ goods ��������service) 
	* @param @param good    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
     public Order insertGood(Goods good);
     /**
      * 
     * @Title: selectAll 
     * @Description: TODO(��ȡ �����б�) 
     * @param @param userName
     * @param @return    �趨�ļ� 
     * @return List<Order>    �������� 
     * @throws
      */
     public List<Order> selectAll(String userName);
     /**
      * 
     * @Title: selectOrderByDay 
     * @Description: TODO(ͳ��ÿ�충�� ���� ���ܽ��) 
     * @param @return    �趨�ļ� 
     * @return List<OrderCountByDay>    �������� 
     * @throws
      */
     public List<OrderCountByDay> selectOrderByDay();
}

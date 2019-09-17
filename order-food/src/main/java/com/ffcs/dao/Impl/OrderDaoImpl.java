package com.ffcs.dao.Impl;
/**
 * 
* @ClassName: OrderDaoImpl 
* @Description: TODO(订单) 
* @author 黄青才 
* @date 2019年8月29日 上午8:59:48 
*
 */

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.ffcs.bean.Goods;
import com.ffcs.bean.Order;
import com.ffcs.bean.OrderCountByDay;
import com.ffcs.dao.IOrderDao;
@Component
public class OrderDaoImpl extends SqlSessionDaoSupport implements IOrderDao{

	@Override
	public void insert(Order order) {
		 getSqlSession().insert("order.insertOrder",order);
	}

	@Override
	public void update(Order t) {
		
	}

	@Override
	public void delete(String goodId) {
		
		 getSqlSession().delete("order.delOrder",goodId);
	}

	@Override
	public Order selectOne(Integer id) {
		return null;
	}

	@Override
	public List<Order> selectAll() {
		List<Order> selectList = getSqlSession().selectList("order.selectOrderDetail");
		return selectList;
	}
	
	public List<Order> selectAll(String userName) {
		
		List<Order> orderList = getSqlSession().selectList("order.selectCount",userName);
		return orderList;
	}

	@Override
	public List<Order> selectPage(int page, int rows) {
		return null;
	}

	@Override
	public int selectCount() {
		return 0;
	}

	@Override
	public void insertGood(Goods good) {
		
	}

	@Override
	public List<OrderCountByDay> selectOrderByDay() {
		List<OrderCountByDay> selectList = getSqlSession().selectList("order.selectOrderByday");
		return selectList;
	}
     
}

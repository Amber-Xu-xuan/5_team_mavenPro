package com.ffcs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.bean.Goods;
import com.ffcs.bean.Order;
import com.ffcs.bean.OrderCountByDay;
import com.ffcs.bean.orderDetail;
import com.ffcs.dao.IOrderDao;
import com.ffcs.dao.IOrderDetailDao;
import com.ffcs.service.IOrderService;
import com.ffcs.util.DateUtil;
import com.ffcs.util.OrderIdUtil;
@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	IOrderDao iOrderDao;
	@Autowired
	IOrderDetailDao iOrderDetailDao;
	@Override
	public void insert(Order t) {
		iOrderDao.insert(t);
	}

	@Override
	public void update(Order t) {
		
	}

	@Override
	public void delete(String id) {
		iOrderDao.delete(id);
	}

	@Override
	public Order selectOne(Integer id) {
		return null;
	}

	@Override
	public List<Order> selectAll() {
		return iOrderDao.selectAll();
	}
	public List<Order> selectAll(String userName) {
		return iOrderDao.selectAll(userName);
	}

	@Override
	public List<Order> selectPage(int offset, int len) {
		return null;
	}

	@Override
	public int selectCount(){
		return 0;
	}

	@Override
	public Order insertGood(Goods good) {
		Order order = new Order();
		//订单总金额
		String ordertotal = good.getTotal();
		String orderId = OrderIdUtil.getOrderId();
		String nowDate = DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss");
		String nowDate2 = DateUtil.getNowDate("yyyy-MM-dd");
		order.setOrderId(orderId);
		order.setOrdDayTime(nowDate2);
		order.setOrdTime(nowDate);
		order.setMoney(ordertotal);
		//已支付
		order.setPayStatus("0");
		//配送中
		order.setStatus("1");
		order.setOrderTel(good.getIntrodece());
		insert(order);
		List<orderDetail> postDataList = good.getPostDataList();
		for(int i=0;i<postDataList.size();i++){
			orderDetail od =postDataList.get(i);
			od.setOrderId(orderId);
			iOrderDetailDao.insert(od);
		}
		return order;
	}

	@Override
	public List<OrderCountByDay> selectOrderByDay() {
		return iOrderDao.selectOrderByDay();
	}
	
	
}

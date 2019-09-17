package com.ffcs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;
import com.ffcs.dao.IOrderDetailDao;
import com.ffcs.service.IOrderDetailService;
@Service
public class OrderDetailServiceImpl implements IOrderDetailService{
	@Autowired
	IOrderDetailDao iOrderDetailDao;
	@Override
	public void insert(orderDetail t) {
		iOrderDetailDao.insert(t);
	}

	@Override
	public void update(orderDetail t) {
		
	}

	@Override
	public void delete(String id) {
		iOrderDetailDao.delete(id);
	}

	@Override
	public orderDetail selectOne(Integer id) {
		return null;
	}

	@Override
	public List<orderDetail> selectAll() {
		return null;
	}

	@Override
	public List<orderDetail> selectPage(int offset, int len) {
		return null;
	}

	@Override
	public int selectCount() {
		return 0;
	}

	
	@Override
	public void insertGood(Goods good) {
		
		
		
	}

}

package com.ffcs.dao.Impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;
import com.ffcs.dao.IOrderDetailDao;
@Component
public class OrderDetailDaoImpl extends SqlSessionDaoSupport implements IOrderDetailDao{

	@Override
	public void insert(orderDetail t) {
		 getSqlSession().insert("orderDetail.insertOrderDetail",t);
	}

	@Override
	public void update(orderDetail t) {
		
	}

	@Override
	public void delete(String id) {
		 getSqlSession().delete("orderDetail.delOrderD",id);
	}

	@Override
	public orderDetail selectOne(Integer id) {
		return null;
	}

	@Override
	public List<orderDetail> selectAll() {
		List<orderDetail> selectList = getSqlSession().selectList("orderDetail.selectOrderDetail");
		return selectList;
	}

	@Override
	public List<orderDetail> selectPage(int page, int rows) {
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

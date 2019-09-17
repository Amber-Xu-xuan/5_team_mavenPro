package com.ffcs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.bean.Goods;
import com.ffcs.bean.goodsListByPage;
import com.ffcs.bean.orderDetailByGood;
import com.ffcs.dao.IGoodsDao;
import com.ffcs.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService{
	@Autowired
	IGoodsDao GoodsDao;
	@Override
	public void insert(Goods t) {
		t.setImg("21.jpg");
		t.setGoodId(System.currentTimeMillis()+"");
		GoodsDao.insert(t);
	}

	@Override
	public void update(Goods t) {
		t.setImg("1.jpg");
		GoodsDao.update(t);
	}

	@Override
	public void delete(String id) {
		GoodsDao.delete(id);
	}

	@Override
	public Goods selectOne(Integer id) {
		return null;
	}

	@Override
	public List<Goods> selectAll() {
		return null;
	}

	@Override
	public List<Goods> selectPage(int offset, int rows) {
		int page = (offset-1)*rows;
		List<Goods> goodLists = GoodsDao.selectPage(page, rows);
		 return goodLists;
	}
	
	@Override
	public int selectCount() {
		 int goodsCountByPage = GoodsDao.selectCount();
		 return goodsCountByPage;
	}
	
	@Override
	public int selectCountOfGoods(goodsListByPage goodList) {
		String priceLte=goodList.getPriceLevel();
		switch (priceLte){
	      case "0":goodList.setPriceGt(0.0);goodList.setPriceLte(100.0);break;
	      case "1":goodList.setPriceGt(100.0);goodList.setPriceLte(500.0);break;
	      case "2":goodList.setPriceGt(500.0);goodList.setPriceLte(1000.0);break;
	      case "3":goodList.setPriceGt(1000.0);goodList.setPriceLte(5000.0);break;
	      case "all":goodList.setPriceGt(0.0);goodList.setPriceLte(50000000000.0);break;
	    }
		int count = GoodsDao.selectCountOfGoods(goodList);
		 return count;
	}

	@Override
	public List<Goods> selectPageOfGoods(goodsListByPage goodList) {
		String priceLte=goodList.getPriceLevel();
		int page=(goodList.getPage()-1)*goodList.getPageSize();
		goodList.setPage(page);
		//升序
		if(goodList.getSort()==1){
			goodList.setUpOrdown("asc");
		}else{
			goodList.setUpOrdown("desc");
		}
		//价格等级
		switch (priceLte){
	      case "0":goodList.setPriceGt(0.0);goodList.setPriceLte(100.0);break;
	      case "1":goodList.setPriceGt(100.0);goodList.setPriceLte(500.0);break;
	      case "2":goodList.setPriceGt(500.0);goodList.setPriceLte(1000.0);break;
	      case "3":goodList.setPriceGt(1000.0);goodList.setPriceLte(5000.0);break;
	      case "all":goodList.setPriceGt(0.0);goodList.setPriceLte(50000000000.0);break;
	    }
		List<Goods> goodLists = GoodsDao.selectPageOfGoods(goodList);
		 return goodLists;
	}

	@Override
	public List<Goods> selectById(Goods goods){
		List<Goods> goodList = GoodsDao.selectById(goods);
		return goodList;
	}

	@Override
	public List<orderDetailByGood> selectOrderDetailByGoods() {
		return GoodsDao.selectOrderDetailByGoods();
	}
}

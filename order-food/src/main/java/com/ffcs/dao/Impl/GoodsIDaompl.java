package com.ffcs.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.ffcs.bean.Goods;
import com.ffcs.bean.goodsListByPage;
import com.ffcs.bean.orderDetailByGood;
import com.ffcs.dao.IGoodsDao;

/**
 * 
* @ClassName: GoodsImpl 
* @Description: TODO(商品相关功能 实现类) 
* @author 黄青才 
* @date 2019年8月26日 下午6:03:26 
*
 */
@Component
public class GoodsIDaompl extends SqlSessionDaoSupport implements IGoodsDao{

	@Override
	public void insert(Goods t) {
		 getSqlSession().insert("goods.addGood",t);
	}

	@Override
	public void update(Goods t) {
		getSqlSession().update("goods.editGood",t);
	}

	@Override
	public void delete(String id) {
		
		 getSqlSession().delete("goods.delById",id);
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
	public List<Goods> selectPage(int page, int rows) {
		
		 return getSqlSession().selectList("goods.selectPage",new RowBounds(page, rows));
	}
    
    

	@Override
	public int selectCount() {
		 return getSqlSession().selectOne("goods.selectCount");
	}

	@Override
	public List<Goods> selectPageOfGoods(goodsListByPage goodList) {
		
		  List<Goods> goodsList = getSqlSession().selectList("goods.selectPage",goodList);
		
		return goodsList;
	}

	@Override
	public int selectCountOfGoods(goodsListByPage goodList) {
		  int goodsCount = getSqlSession().selectOne("goods.selectCount",goodList);
		return goodsCount;
	}

	@Override
	public List<Goods> selectById(Goods goods) {
		  System.out.println("wowo1:");
		  List<Goods> goodsList = getSqlSession().selectList("goods.selectById",goods);
		  System.out.println("wowo:"+goodsList);
		return goodsList;
	}

	@Override
	public List<orderDetailByGood> selectOrderDetailByGoods() {
		List<orderDetailByGood> selectList = getSqlSession().selectList("goods.orderDaByGood");
		return selectList;
	}

	
}

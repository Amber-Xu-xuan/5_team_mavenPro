package com.ffcs.service;

import java.util.List;

import com.ffcs.bean.Goods;
import com.ffcs.bean.goodsListByPage;
import com.ffcs.bean.orderDetailByGood;

/**
 * 
* @ClassName: IGoodsService 
* @Description: TODO(商品 service 层接口) 
* @author 黄青才 
* @date 2019年8月26日 下午7:11:36 
*
 */
public interface IGoodsService extends BaseService<Goods>{
	/**
	 * 
	* @Title: selectPageOfGoods 
	* @Description: TODO(根据 价格 升降序等 分页查询商品列表) 
	* @param @param goodList
	* @param @return    设定文件 
	* @return List<Goods>    返回类型 
	* @throws
	 */
	public List<Goods> selectPageOfGoods(goodsListByPage goodList);
	/**
	 * 
	* @Title: selectCount 
	* @Description: TODO(根据 价格 区间 分页查询商品总数) 
	* @param @param goodList
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public int selectCountOfGoods(goodsListByPage goodList);
	/**
	 * 
	* @Title: selectById 
	* @Description: TODO(根据商品id 获取商品列表) 
	* @param @param goodIds
	* @param @return    设定文件 
	* @return List<Goods>    返回类型 
	* @throws
	 */
	public List<Goods> selectById(Goods goods);
	/**
	 * 
	* @Title: selectOrderDetailByGoods 
	* @Description: TODO(根据商品 查询 订单明细) 
	* @param @return    设定文件 
	* @return List<orderDetailByGood>    返回类型 
	* @throws
	 */
	public List<orderDetailByGood> selectOrderDetailByGoods();
}

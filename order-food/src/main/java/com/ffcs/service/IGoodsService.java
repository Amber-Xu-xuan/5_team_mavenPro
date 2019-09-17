package com.ffcs.service;

import java.util.List;

import com.ffcs.bean.Goods;
import com.ffcs.bean.goodsListByPage;
import com.ffcs.bean.orderDetailByGood;

/**
 * 
* @ClassName: IGoodsService 
* @Description: TODO(��Ʒ service ��ӿ�) 
* @author ����� 
* @date 2019��8��26�� ����7:11:36 
*
 */
public interface IGoodsService extends BaseService<Goods>{
	/**
	 * 
	* @Title: selectPageOfGoods 
	* @Description: TODO(���� �۸� ������� ��ҳ��ѯ��Ʒ�б�) 
	* @param @param goodList
	* @param @return    �趨�ļ� 
	* @return List<Goods>    �������� 
	* @throws
	 */
	public List<Goods> selectPageOfGoods(goodsListByPage goodList);
	/**
	 * 
	* @Title: selectCount 
	* @Description: TODO(���� �۸� ���� ��ҳ��ѯ��Ʒ����) 
	* @param @param goodList
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws
	 */
	public int selectCountOfGoods(goodsListByPage goodList);
	/**
	 * 
	* @Title: selectById 
	* @Description: TODO(������Ʒid ��ȡ��Ʒ�б�) 
	* @param @param goodIds
	* @param @return    �趨�ļ� 
	* @return List<Goods>    �������� 
	* @throws
	 */
	public List<Goods> selectById(Goods goods);
	/**
	 * 
	* @Title: selectOrderDetailByGoods 
	* @Description: TODO(������Ʒ ��ѯ ������ϸ) 
	* @param @return    �趨�ļ� 
	* @return List<orderDetailByGood>    �������� 
	* @throws
	 */
	public List<orderDetailByGood> selectOrderDetailByGoods();
}

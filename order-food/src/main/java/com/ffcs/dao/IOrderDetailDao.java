package com.ffcs.dao;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;

/**
 * 
* @ClassName: IOrderDetailDao 
* @Description: TODO(������ϸ) 
* @author ����� 
* @date 2019��8��29�� ����9:13:14 
*
 */
public interface IOrderDetailDao extends BaseDao<orderDetail>{
	/**
	 * 
	* @Title: insertGood 
	* @Description: TODO(���� controller �� ͳһ goods ��������service) 
	* @param @param good    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
     public void insertGood(Goods good);
}

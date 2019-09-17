package com.ffcs.dao;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;

/**
 * 
* @ClassName: IOrderDetailDao 
* @Description: TODO(订单明细) 
* @author 黄青才 
* @date 2019年8月29日 上午9:13:14 
*
 */
public interface IOrderDetailDao extends BaseDao<orderDetail>{
	/**
	 * 
	* @Title: insertGood 
	* @Description: TODO(用于 controller 层 统一 goods 参数传入service) 
	* @param @param good    设定文件 
	* @return void    返回类型 
	* @throws
	 */
     public void insertGood(Goods good);
}

package com.ffcs.service;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;
/**
 * 
* @ClassName: IOrderDetailService 
* @Description: TODO(订单明细) 
* @author 黄青才 
* @date 2019年8月29日 上午9:15:58 
*
 */
public interface IOrderDetailService extends BaseService<orderDetail>{
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

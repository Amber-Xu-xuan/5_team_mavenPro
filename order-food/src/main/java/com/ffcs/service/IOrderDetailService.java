package com.ffcs.service;

import com.ffcs.bean.Goods;
import com.ffcs.bean.orderDetail;
/**
 * 
* @ClassName: IOrderDetailService 
* @Description: TODO(������ϸ) 
* @author ����� 
* @date 2019��8��29�� ����9:15:58 
*
 */
public interface IOrderDetailService extends BaseService<orderDetail>{
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

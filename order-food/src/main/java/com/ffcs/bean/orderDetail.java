package com.ffcs.bean;
/**
 * 
* @ClassName: orderDetail 
* @Description: TODO(������ϸ) 
* @author ����� 
* @date 2019��8��29�� ����8:41:23 
*
 */
public class orderDetail {
	//����
    private Integer id;
    //����id
    private String orderId;
    //��Ʒid
    private String goodId;
    //��Ʒ����
    private String goodsNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	@Override
	public String toString() {
		return "orderDetail [id=" + id + ", orderId=" + orderId + ", goodId=" + goodId + ", goodsNumber=" + goodsNumber
				+ "]";
	}
    
    
}

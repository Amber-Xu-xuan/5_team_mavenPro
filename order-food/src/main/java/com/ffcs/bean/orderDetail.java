package com.ffcs.bean;
/**
 * 
* @ClassName: orderDetail 
* @Description: TODO(订单明细) 
* @author 黄青才 
* @date 2019年8月29日 上午8:41:23 
*
 */
public class orderDetail {
	//主键
    private Integer id;
    //订单id
    private String orderId;
    //商品id
    private String goodId;
    //商品数量
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

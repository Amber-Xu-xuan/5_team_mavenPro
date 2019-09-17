package com.ffcs.bean;
/**
 * 
* @ClassName: orderDetailByGood 
* @Description: TODO(根据商品 查询订单明细 实体) 
* @author 黄青才 
* @date 2019年8月31日 下午1:44:47 
*
 */
public class orderDetailByGood {
	//商品ID
    private String goodId;
    //商品名称
    private String goodsName;
    //订单数量
    private String orderCount;
    //商品销售数量
    private String goodsNum;
    //商品销售总金额
    private String goodsTotalPrice;
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsTotalPrice() {
		return goodsTotalPrice;
	}
	public void setGoodsTotalPrice(String goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "orderDetailByGood [goodId=" + goodId + ", goodsName=" + goodsName + ", orderCount=" + orderCount
				+ ", goodsNum=" + goodsNum + ", goodsTotalPrice=" + goodsTotalPrice + "]";
	}
    
    
}

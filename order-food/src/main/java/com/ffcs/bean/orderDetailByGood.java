package com.ffcs.bean;
/**
 * 
* @ClassName: orderDetailByGood 
* @Description: TODO(������Ʒ ��ѯ������ϸ ʵ��) 
* @author ����� 
* @date 2019��8��31�� ����1:44:47 
*
 */
public class orderDetailByGood {
	//��ƷID
    private String goodId;
    //��Ʒ����
    private String goodsName;
    //��������
    private String orderCount;
    //��Ʒ��������
    private String goodsNum;
    //��Ʒ�����ܽ��
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

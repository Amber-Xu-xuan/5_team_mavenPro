package com.ffcs.bean;
/**
 * 
* @ClassName: Order 
* @Description: TODO(订单实体类) 
* @author 黄青才 
* @date 2019年8月29日 上午8:36:34 
*
 */
public class Order {
	//订单id
	private String orderId;
	//订单 年月日 时分秒 时间
	private String ordTime;
	//订单人账号
	private String orderTel;
	//总金额
	private String money;
	//配送状态
	private String status;
	//订单 年月日 时间
	private String ordDayTime;
	//订单支付状态
	private String payStatus;
	
	private String checked;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(String ordTime) {
		this.ordTime = ordTime;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrdDayTime() {
		return ordDayTime;
	}
	public void setOrdDayTime(String ordDayTime) {
		this.ordDayTime = ordDayTime;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ordTime=" + ordTime + ", orderTel=" + orderTel + ", money=" + money
				+ ", status=" + status + ", ordDayTime=" + ordDayTime + ", payStatus=" + payStatus + ", checked="
				+ checked + "]";
	}
	
	
}

package com.ffcs.bean;
/**
 * 
* @ClassName: Order 
* @Description: TODO(����ʵ����) 
* @author ����� 
* @date 2019��8��29�� ����8:36:34 
*
 */
public class Order {
	//����id
	private String orderId;
	//���� ������ ʱ���� ʱ��
	private String ordTime;
	//�������˺�
	private String orderTel;
	//�ܽ��
	private String money;
	//����״̬
	private String status;
	//���� ������ ʱ��
	private String ordDayTime;
	//����֧��״̬
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

package com.ffcs.bean;
/**
 * 
* @ClassName: OrderCountByDay 
* @Description: TODO(ͳ��ÿ�� ���� ������ ���ʵ��) 
* @author ����� 
* @date 2019��8��31�� ����3:24:49 
*
 */
public class OrderCountByDay {
	//ʱ��
   private String time;
   //��������
   private String orderCount;
   //���
   private String priceTotal;
   public String getTime() {
	   return time;
   }
   public void setTime(String time) {
	   this.time = time;
   }
   public String getOrderCount() {
	   return orderCount;
   }
   public void setOrderCount(String orderCount) {
	   this.orderCount = orderCount;
   }
   public String getPriceTotal() {
	   return priceTotal;
   }
   public void setPriceTotal(String priceTotal) {
	   this.priceTotal = priceTotal;
   }
   @Override
   public String toString() {
	   return "OrderCountByDay [time=" + time + ", orderCount=" + orderCount + ", priceTotal=" + priceTotal + "]";
   }
   
}

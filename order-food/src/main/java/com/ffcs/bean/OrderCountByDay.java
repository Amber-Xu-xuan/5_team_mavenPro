package com.ffcs.bean;
/**
 * 
* @ClassName: OrderCountByDay 
* @Description: TODO(统计每日 订单 数量和 金额实体) 
* @author 黄青才 
* @date 2019年8月31日 下午3:24:49 
*
 */
public class OrderCountByDay {
	//时间
   private String time;
   //订单数量
   private String orderCount;
   //金额
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

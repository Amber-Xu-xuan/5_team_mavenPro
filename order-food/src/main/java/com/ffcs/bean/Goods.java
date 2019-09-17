package com.ffcs.bean;

import java.util.Arrays;
import java.util.List;

/**
 * 
* @ClassName: Goods 
* @Description: TODO(商品实体，用于映射 商品表) 
* @author 黄青才 
* @date 2019年8月26日 下午5:39:59 
*
 */
public class Goods {
	//商品编号
     private String goodId;
     //商品单价
     private String price;
     //商品说明
     private String introdece;
     //商品数量
     private String total;
     //商品图片地址
     private String img;
     //商品名称
     private String goodName;
     //商品id 数组
     private String[] goodIds;
     //是否选择
     private String checked;
     //
     private List<orderDetail> postDataList;
     
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntrodece() {
		return introdece;
	}
	public void setIntrodece(String introdece) {
		this.introdece = introdece;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	public String[] getGoodIds() {
		return goodIds;
	}
	public void setGoodIds(String[] goodIds) {
		this.goodIds = goodIds;
	}
	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public List<orderDetail> getPostDataList() {
		return postDataList;
	}
	public void setPostDataList(List<orderDetail> postDataList) {
		this.postDataList = postDataList;
	}
	@Override
	public String toString() {
		return "Goods [goodId=" + goodId + ", price=" + price + ", introdece=" + introdece + ", total=" + total
				+ ", img=" + img + ", goodName=" + goodName + ", goodIds=" + Arrays.toString(goodIds) + ", checked="
				+ checked + ", postDataList=" + postDataList + "]";
	}
    
}

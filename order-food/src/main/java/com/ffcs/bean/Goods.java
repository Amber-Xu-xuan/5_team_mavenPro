package com.ffcs.bean;

import java.util.Arrays;
import java.util.List;

/**
 * 
* @ClassName: Goods 
* @Description: TODO(��Ʒʵ�壬����ӳ�� ��Ʒ��) 
* @author ����� 
* @date 2019��8��26�� ����5:39:59 
*
 */
public class Goods {
	//��Ʒ���
     private String goodId;
     //��Ʒ����
     private String price;
     //��Ʒ˵��
     private String introdece;
     //��Ʒ����
     private String total;
     //��ƷͼƬ��ַ
     private String img;
     //��Ʒ����
     private String goodName;
     //��Ʒid ����
     private String[] goodIds;
     //�Ƿ�ѡ��
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

package com.ffcs.bean;
/**
 * 
* @ClassName: goodsListByPage 
* @Description: TODO( ��ѯ��Ʒ�б� ����ʵ��) 
* @author ����� 
* @date 2019��8��26�� ����8:24:25 
*
 */
public class goodsListByPage {
	//��ǰҳ
     private Integer page;
     //ҳ��С
     private Integer pageSize;
     //������
     private Integer sort;
     //�۸�ȼ�
     private String priceLevel;
     //�۸���С��Χ
     private Double priceGt;
     //�۸����Χ
     private Double priceLte;
     private String upOrdown;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(String priceLevel) {
		this.priceLevel = priceLevel;
	}
	
	public Double getPriceGt() {
		return priceGt;
	}
	public void setPriceGt(Double priceGt) {
		this.priceGt = priceGt;
	}
	public Double getPriceLte() {
		return priceLte;
	}
	public void setPriceLte(Double priceLte) {
		this.priceLte = priceLte;
	}
	public String getUpOrdown() {
		return upOrdown;
	}
	public void setUpOrdown(String upOrdown) {
		this.upOrdown = upOrdown;
	}
	@Override
	public String toString() {
		return "goodsListByPage [page=" + page + ", pageSize=" + pageSize + ", sort=" + sort + ", priceLevel="
				+ priceLevel + ", priceGt=" + priceGt + ", priceLte=" + priceLte + ", upOrdown=" + upOrdown + "]";
	}     
}

package com.ffcs.bean;
/**
 * 
* @ClassName: goodsListByPage 
* @Description: TODO( 查询商品列表 参数实体) 
* @author 黄青才 
* @date 2019年8月26日 下午8:24:25 
*
 */
public class goodsListByPage {
	//当前页
     private Integer page;
     //页大小
     private Integer pageSize;
     //升降序
     private Integer sort;
     //价格等级
     private String priceLevel;
     //价格最小范围
     private Double priceGt;
     //价格最大范围
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

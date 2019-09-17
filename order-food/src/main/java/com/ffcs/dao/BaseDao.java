package com.ffcs.dao;

import java.util.List;

/**
 * 
* @ClassName: BaseDao 
* @Description: TODO(dao层  父接口 定义了基本的增删改查) 
* @author 黄青才 
* @date 2019年8月26日 下午5:54:47 
*
 */
public interface BaseDao<T> {
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(增加) 
	* @param @param t    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insert(T t);
	/**
	 * 
	* @Title: update 
	* @Description: TODO(修改) 
	* @param @param t    设定文件 
	* @return void    返回类型 
	* @throws
	 */
    public void update(T t);
    /**
     * 
    * @Title: delete 
    * @Description: TODO(删除) 
    * @param @param id    设定文件 
    * @return void    返回类型 
    * @throws
     */
    public void delete(String id);
    /**
     * 
    * @Title: selectOne 
    * @Description: TODO(根据id 查询) 
    * @param @param id
    * @param @return    设定文件 
    * @return T    返回类型 
    * @throws
     */
    public T selectOne(Integer id);
    /**
     * 
    * @Title: selectAll 
    * @Description: TODO(查询所有) 
    * @param @return    设定文件 
    * @return List<T>    返回类型 
    * @throws
     */
    public List<T> selectAll();
    /**
     * 
    * @Title: selectPage 
    * @Description: TODO(分页查询) 
    * @param @param page :当前页
    * @param @param rows  ：每页显示几条
    * @param @return    设定文件 
    * @return List<T>    返回类型 
    * @throws
     */
    public List<T> selectPage(int page,int rows);
    /**
     * 
    * @Title: selectCount 
    * @Description: TODO(查询的总条数) 
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    public int selectCount();
}

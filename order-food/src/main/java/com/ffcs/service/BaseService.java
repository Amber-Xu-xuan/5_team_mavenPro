package com.ffcs.service;

import java.util.List;

/**
 * 
* @ClassName: BaseService 
* @Description: TODO(servce 层 父类接口) 
* @author 黄青才 
* @date 2019年8月26日 下午7:08:23 
*
 */
public interface BaseService<T> {
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(添加) 
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
    * @Description: TODO(查询一条记录) 
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
	  * @param @param offset
	  * @param @param len
	  * @param @return    设定文件 
	  * @return List<T>    返回类型 
	  * @throws
	   */
	    public List<T> selectPage(int offset, int len) ;
      /**
       * 
      * @Title: selectCount 
      * @Description: TODO(查询总条数) 
      * @param @return    设定文件 
      * @return int    返回类型 
      * @throws
       */
	    public int selectCount();
}

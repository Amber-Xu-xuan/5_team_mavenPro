package com.ffcs.service;

import java.util.List;

/**
 * 
* @ClassName: BaseService 
* @Description: TODO(servce �� ����ӿ�) 
* @author ����� 
* @date 2019��8��26�� ����7:08:23 
*
 */
public interface BaseService<T> {
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(���) 
	* @param @param t    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	 	public void insert(T t);
    /**
     * 
    * @Title: update 
    * @Description: TODO(�޸�) 
    * @param @param t    �趨�ļ� 
    * @return void    �������� 
    * @throws
     */
	    public void update(T t);
    /**
     * 
    * @Title: delete 
    * @Description: TODO(ɾ��) 
    * @param @param id    �趨�ļ� 
    * @return void    �������� 
    * @throws
     */
	    public void delete(String id);
    /**
     * 
    * @Title: selectOne 
    * @Description: TODO(��ѯһ����¼) 
    * @param @param id
    * @param @return    �趨�ļ� 
    * @return T    �������� 
    * @throws
     */
	    public T selectOne(Integer id);
    /**
     * 
    * @Title: selectAll 
    * @Description: TODO(��ѯ����) 
    * @param @return    �趨�ļ� 
    * @return List<T>    �������� 
    * @throws
     */
	    public List<T> selectAll();

	  /**
	   *   
	  * @Title: selectPage 
	  * @Description: TODO(��ҳ��ѯ) 
	  * @param @param offset
	  * @param @param len
	  * @param @return    �趨�ļ� 
	  * @return List<T>    �������� 
	  * @throws
	   */
	    public List<T> selectPage(int offset, int len) ;
      /**
       * 
      * @Title: selectCount 
      * @Description: TODO(��ѯ������) 
      * @param @return    �趨�ļ� 
      * @return int    �������� 
      * @throws
       */
	    public int selectCount();
}

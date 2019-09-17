package com.ffcs.dao;

import java.util.List;

/**
 * 
* @ClassName: BaseDao 
* @Description: TODO(dao��  ���ӿ� �����˻�������ɾ�Ĳ�) 
* @author ����� 
* @date 2019��8��26�� ����5:54:47 
*
 */
public interface BaseDao<T> {
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(����) 
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
    * @Description: TODO(����id ��ѯ) 
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
    * @param @param page :��ǰҳ
    * @param @param rows  ��ÿҳ��ʾ����
    * @param @return    �趨�ļ� 
    * @return List<T>    �������� 
    * @throws
     */
    public List<T> selectPage(int page,int rows);
    /**
     * 
    * @Title: selectCount 
    * @Description: TODO(��ѯ��������) 
    * @param @return    �趨�ļ� 
    * @return int    �������� 
    * @throws
     */
    public int selectCount();
}

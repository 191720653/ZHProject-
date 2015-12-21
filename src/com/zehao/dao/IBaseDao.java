package com.zehao.dao;

import java.io.Serializable;
import java.util.List;

import com.zehao.util.Page;

/**
 * ͨ��Dao�ӿ�
 * 
 * @author zehao
 * 
 * @param <T>
 */
public interface IBaseDao<T> {

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 */
	public void insert(T entity);

	/**
	 * ����ʵ�壬������ʵ�������
	 * 
	 * @param entity
	 * @return id
	 */
	public Serializable save(T entity);

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * ������������ʵ��
	 * 
	 * @param id
	 * @return T
	 */
	public T findById(Serializable id);

	/**
	 * ���ݴ����hql������ʵ��
	 * 
	 * @param hql
	 * @param params
	 * @return List<T>
	 */
	public List<T> findByHQL(String hql, List<Object> params);

	/**
	 * ���ݴ����sql������ʵ��
	 * 
	 * @param sql
	 * @param params
	 * @return List<T>
	 */
	public List<T> findBySQL(String sql, List<Object> params);

	/**
	 * �@ȡ����ӛ�
	 * 
	 * @return List<T>
	 */
	public List<T> getAll();

	/**
	 * �@ȡ��ӛ䛔�
	 * 
	 * @return size
	 */
	public int getSize();

	/**
	 * ��ҳ��ȡ����(sql)
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public Page<T> find(int currentPage, int pageSize, String sql,
			List<Object> values);
	
	/**
	 * ��ҳ��ȡ����(hql)
	 * @param currentPage
	 * @param pageSize
	 * @param hql
	 * @param values
	 * @return
	 */
	public Page<T> findPageByHQL(int currentPage, int pageSize, String hql,
			List<Object> values);

	/**
	 * �������ԫ@ȡӛ�
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * �������ԫ@ȡΨһӛ�
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findUniqueByProperty(String propertyName, Object value);
	
	/**
	 * ����hql��ȡΨһ��¼(hql)
	 * 
	 * @param propertyName
	 * @param values
	 * @return
	 */
	public T findUniqueByPropertys(String hql, List<Object> values);

}

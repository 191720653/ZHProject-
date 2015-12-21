package com.zehao.util;

import java.util.List;

/**
 * ��ҳBean
 * 
 * @author zehao
 * 
 * @param <T>
 */
public class Page<T> {
	/**
	 * �����
	 */
	private List<T> resultList;
	/**
	 * �ܼ�¼��
	 */
	private int recordSUM;
	/**
	 * ��ҳ��
	 */
	private int pageSUM;
	/**
	 * ��ǰҳ
	 */
	private int currentPage;
	/**
	 * ҳ��¼��
	 */
	private int pageSize;

	/**
	 * ��ʼ��
	 */
	public Page(List<T> resultList, int recordSUM, int pageSize, int currentPage) {
		this.resultList = resultList;
		this.recordSUM = recordSUM;
		this.pageSize = pageSize;
		this.countCurrentPage(currentPage);
		this.countTotalPage(pageSize, recordSUM);
	}

	/**
	 * ��ҳ��
	 */
	public void countTotalPage(int pageSize, int recordSUM) {

		pageSUM = recordSUM % pageSize == 0 ? recordSUM / pageSize : recordSUM
				/ pageSize + 1;

	}

	/**
	 * ��̬��������ǰҳ��ʼ��¼�ţ����ݿ�Ӵ˴���ʼȡ����
	 */
	public static int countOffset(int pageSize, int currentPage) {

		return pageSize * (currentPage - 1);

	}

	/**
	 * ��ǰҳ
	 */
	public void countCurrentPage(int page) {

		currentPage = (page == 0 ? 1 : page);

	}

	/**
	 * �жϵ�ǰҳ��״̬,�Ƿ��ǵ�һҳ
	 */
	public boolean isFirstPage() {
		return currentPage != 1;
	}

	/**
	 * �Ƿ������һҳ
	 */
	public boolean isLastPage() {
		return currentPage != pageSUM;
	}

	/**
	 * �Ƿ�����һҳ
	 */
	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}

	/**
	 * �Ƿ�����һҳ
	 */
	public boolean isHasNextPage() {
		return currentPage != pageSUM;
	}

	/**
	 * ��һҳ
	 */
	public int previousPage() {
		return currentPage - 1;
	}

	/**
	 * ��һҳ
	 */
	public int nextPage() {
		return currentPage + 1;
	}

	/**
	 * Get/Set����
	 */
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public int getRecordSUM() {
		return recordSUM;
	}

	public void setRecordSUM(int recordSUM) {
		this.recordSUM = recordSUM;
	}

	public int getPageSUM() {
		return pageSUM>0?pageSUM:1;
	}

	public void setPageSUM(int pageSUM) {
		this.pageSUM = pageSUM;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [resultList=" + resultList + ", recordSUM=" + recordSUM
				+ ", pageSUM=" + pageSUM + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + "]";
	}

}

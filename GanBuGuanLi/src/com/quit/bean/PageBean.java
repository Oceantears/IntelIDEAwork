package com.quit.bean;
public class PageBean {
	private int page; // �ڼ�ҳ
	private int rows; // ÿҳ��¼��
	private int start;  // ��ʼҳ	
	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", start=" + start + "]";
	}
	public PageBean(int page, int rows, int start) {
		this.page = page;
		this.rows = rows;
		this.start = start;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return (page-1)*rows;
	}	
}


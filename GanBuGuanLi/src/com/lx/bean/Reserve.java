package com.lx.bean;

public class Reserve{
	
	private int employee_id;	
	private String work_exper;
	private String reserveposition;
	private String name;
	/**
	 * @return the employee_id  
	 */
	public int getEmployee_id() {
		return employee_id;
	}
	/**
	 * * @param employee_id the employee_idto set  
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	/**
	 * @return the work_exper  
	 */
	public String getWork_exper() {
		return work_exper;
	}
	/**
	 * * @param work_exper the work_experto set  
	 */
	public void setWork_exper(String work_exper) {
		this.work_exper = work_exper;
	}
	/**
	 * @return the reserveposition  
	 */
	public String getReserveposition() {
		return reserveposition;
	}
	/**
	 * * @param reserveposition the reservepositionto set  
	 */
	public void setReserveposition(String reserveposition) {
		this.reserveposition = reserveposition;
	}
	/**
	 * @return the name  
	 */
	public String getName() {
		return name;
	}
	/**
	 * * @param name the nameto set  
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*(non Javadoc) 
	 * <p>Title: toString</p>
	 * <p>Description:</p>
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "Reserve [employee_id=" + employee_id + ", work_exper=" + work_exper + ", reserveposition="
				+ reserveposition + ", name=" + name + "]";
	}
	/**
	 * <p>Title:</p>
	 * <p>Description:</p>
	 * @param employee_id
	 * @param work_exper
	 * @param reserveposition
	 * @param name 
	 */
	public Reserve(int employee_id, String work_exper, String reserveposition, String name) {
		super();
		this.employee_id = employee_id;
		this.work_exper = work_exper;
		this.reserveposition = reserveposition;
		this.name = name;
	}
	/**
	 * <p>Title:</p>
	 * <p>Description:</p> 
	 */
	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}

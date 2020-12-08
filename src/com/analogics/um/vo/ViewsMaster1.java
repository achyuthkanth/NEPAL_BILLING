package com.analogics.um.vo;

/**
 * ViewsMaster1 entity. @author MyEclipse Persistence Tools
 */

public class ViewsMaster1 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6337401026027724927L;
	private String viewname;
	private String viewdescription;
	private String actionname;

	// Constructors

	/** default constructor */
	public ViewsMaster1() {
	}

	/** minimal constructor */
	public ViewsMaster1(String viewname) {
		this.viewname = viewname;
	}

	/** full constructor */
	public ViewsMaster1(String viewname, String viewdescription,
			String actionname) {
		this.viewname = viewname;
		this.viewdescription = viewdescription;
		this.actionname = actionname;
	}

	// Property accessors

	public String getViewname() {
		return this.viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

	public String getViewdescription() {
		return this.viewdescription;
	}

	public void setViewdescription(String viewdescription) {
		this.viewdescription = viewdescription;
	}

	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

}
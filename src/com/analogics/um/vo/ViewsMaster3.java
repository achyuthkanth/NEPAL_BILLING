package com.analogics.um.vo;

/**
 * ViewsMaster3 entity. @author MyEclipse Persistence Tools
 */

public class ViewsMaster3 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6447565696152396926L;
	private String viewname;
	private String viewdescription;
	private String parentview;
	private String actionname;

	// Constructors

	/** default constructor */
	public ViewsMaster3() {
	}

	/** minimal constructor */
	public ViewsMaster3(String viewname, String parentview) {
		this.viewname = viewname;
		this.parentview = parentview;
	}

	/** full constructor */
	public ViewsMaster3(String viewname, String viewdescription,
			String parentview, String actionname) {
		this.viewname = viewname;
		this.viewdescription = viewdescription;
		this.parentview = parentview;
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

	public String getParentview() {
		return this.parentview;
	}

	public void setParentview(String parentview) {
		this.parentview = parentview;
	}

	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

}
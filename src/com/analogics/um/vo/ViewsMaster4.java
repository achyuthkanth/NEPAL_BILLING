package com.analogics.um.vo;

/**
 * ViewsMaster4 entity. @author MyEclipse Persistence Tools
 */

public class ViewsMaster4 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7969735525502455364L;
	private String viewname;
	private String viewdescription;
	private String parentview;
	private String actionname;

	// Constructors

	/** default constructor */
	public ViewsMaster4() {
	}

	/** minimal constructor */
	public ViewsMaster4(String viewname, String parentview) {
		this.viewname = viewname;
		this.parentview = parentview;
	}

	/** full constructor */
	public ViewsMaster4(String viewname, String viewdescription,
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
package com.analogics.um.vo;

import java.util.List;

import com.analogics.utils.ExtraFieldspojo;

/**
 * ViewsMaster2 entity. @author MyEclipse Persistence Tools
 */

public class ViewsMaster2 extends ExtraFieldspojo implements java.io.Serializable {

	private static final long serialVersionUID = -1125705393824925731L;
	private String viewname;
	private String viewdescription;
	private String parentview;
	private String actionname;
	
	private Integer viewLevel;
	
	private List<ViewsMaster2> viewMasterList;

	/** default constructor */
	public ViewsMaster2() {
	}

	/** minimal constructor */
	public ViewsMaster2(String viewname, String parentview) {
		this.viewname = viewname;
		this.parentview = parentview;
	}

	/** full constructor */
	public ViewsMaster2(String viewname, String viewdescription,
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

	public Integer getViewLevel() {
		return viewLevel;
	}

	public void setViewLevel(Integer viewLevel) {
		this.viewLevel = viewLevel;
	}

	public List<ViewsMaster2> getViewMasterList() {
		return viewMasterList;
	}

	public void setViewMasterList(List<ViewsMaster2> viewMasterList) {
		this.viewMasterList = viewMasterList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
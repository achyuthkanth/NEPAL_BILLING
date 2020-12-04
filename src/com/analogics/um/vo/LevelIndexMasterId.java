package com.analogics.um.vo;

/**
 * LevelIndexMasterId entity. @author MyEclipse Persistence Tools
 */

public class LevelIndexMasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2106169047565248131L;
	private Integer level15id;
	private Integer level14id;
	private Integer level13id;
	private Integer level12id;
	private Integer level11id;
	private Integer level10id;
	private Integer level9id;
	private Integer level8id;
	private Integer level7id;
	private Integer level6id;
	private Integer level5id;
	private Integer level4id;
	private Integer level3id;
	private Integer level2id;
	private Integer level1id;

	// Constructors

	/** default constructor */
	public LevelIndexMasterId() {
	}

	/** full constructor */
	public LevelIndexMasterId(Integer level15id, Integer level14id,
			Integer level13id, Integer level12id, Integer level11id,
			Integer level10id, Integer level9id, Integer level8id,
			Integer level7id, Integer level6id, Integer level5id,
			Integer level4id, Integer level3id, Integer level2id,
			Integer level1id) {
		this.level15id = level15id;
		this.level14id = level14id;
		this.level13id = level13id;
		this.level12id = level12id;
		this.level11id = level11id;
		this.level10id = level10id;
		this.level9id = level9id;
		this.level8id = level8id;
		this.level7id = level7id;
		this.level6id = level6id;
		this.level5id = level5id;
		this.level4id = level4id;
		this.level3id = level3id;
		this.level2id = level2id;
		this.level1id = level1id;
	}

	// Property accessors

	public Integer getLevel15id() {
		return this.level15id;
	}

	public void setLevel15id(Integer level15id) {
		this.level15id = level15id;
	}

	public Integer getLevel14id() {
		return this.level14id;
	}

	public void setLevel14id(Integer level14id) {
		this.level14id = level14id;
	}

	public Integer getLevel13id() {
		return this.level13id;
	}

	public void setLevel13id(Integer level13id) {
		this.level13id = level13id;
	}

	public Integer getLevel12id() {
		return this.level12id;
	}

	public void setLevel12id(Integer level12id) {
		this.level12id = level12id;
	}

	public Integer getLevel11id() {
		return this.level11id;
	}

	public void setLevel11id(Integer level11id) {
		this.level11id = level11id;
	}

	public Integer getLevel10id() {
		return this.level10id;
	}

	public void setLevel10id(Integer level10id) {
		this.level10id = level10id;
	}

	public Integer getLevel9id() {
		return this.level9id;
	}

	public void setLevel9id(Integer level9id) {
		this.level9id = level9id;
	}

	public Integer getLevel8id() {
		return this.level8id;
	}

	public void setLevel8id(Integer level8id) {
		this.level8id = level8id;
	}

	public Integer getLevel7id() {
		return this.level7id;
	}

	public void setLevel7id(Integer level7id) {
		this.level7id = level7id;
	}

	public Integer getLevel6id() {
		return this.level6id;
	}

	public void setLevel6id(Integer level6id) {
		this.level6id = level6id;
	}

	public Integer getLevel5id() {
		return this.level5id;
	}

	public void setLevel5id(Integer level5id) {
		this.level5id = level5id;
	}

	public Integer getLevel4id() {
		return this.level4id;
	}

	public void setLevel4id(Integer level4id) {
		this.level4id = level4id;
	}

	public Integer getLevel3id() {
		return this.level3id;
	}

	public void setLevel3id(Integer level3id) {
		this.level3id = level3id;
	}

	public Integer getLevel2id() {
		return this.level2id;
	}

	public void setLevel2id(Integer level2id) {
		this.level2id = level2id;
	}

	public Integer getLevel1id() {
		return this.level1id;
	}

	public void setLevel1id(Integer level1id) {
		this.level1id = level1id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LevelIndexMasterId))
			return false;
		LevelIndexMasterId castOther = (LevelIndexMasterId) other;

		return ((this.getLevel15id() == castOther.getLevel15id()) || (this
				.getLevel15id() != null && castOther.getLevel15id() != null && this
				.getLevel15id().equals(castOther.getLevel15id())))
				&& ((this.getLevel14id() == castOther.getLevel14id()) || (this
						.getLevel14id() != null
						&& castOther.getLevel14id() != null && this
						.getLevel14id().equals(castOther.getLevel14id())))
				&& ((this.getLevel13id() == castOther.getLevel13id()) || (this
						.getLevel13id() != null
						&& castOther.getLevel13id() != null && this
						.getLevel13id().equals(castOther.getLevel13id())))
				&& ((this.getLevel12id() == castOther.getLevel12id()) || (this
						.getLevel12id() != null
						&& castOther.getLevel12id() != null && this
						.getLevel12id().equals(castOther.getLevel12id())))
				&& ((this.getLevel11id() == castOther.getLevel11id()) || (this
						.getLevel11id() != null
						&& castOther.getLevel11id() != null && this
						.getLevel11id().equals(castOther.getLevel11id())))
				&& ((this.getLevel10id() == castOther.getLevel10id()) || (this
						.getLevel10id() != null
						&& castOther.getLevel10id() != null && this
						.getLevel10id().equals(castOther.getLevel10id())))
				&& ((this.getLevel9id() == castOther.getLevel9id()) || (this
						.getLevel9id() != null
						&& castOther.getLevel9id() != null && this
						.getLevel9id().equals(castOther.getLevel9id())))
				&& ((this.getLevel8id() == castOther.getLevel8id()) || (this
						.getLevel8id() != null
						&& castOther.getLevel8id() != null && this
						.getLevel8id().equals(castOther.getLevel8id())))
				&& ((this.getLevel7id() == castOther.getLevel7id()) || (this
						.getLevel7id() != null
						&& castOther.getLevel7id() != null && this
						.getLevel7id().equals(castOther.getLevel7id())))
				&& ((this.getLevel6id() == castOther.getLevel6id()) || (this
						.getLevel6id() != null
						&& castOther.getLevel6id() != null && this
						.getLevel6id().equals(castOther.getLevel6id())))
				&& ((this.getLevel5id() == castOther.getLevel5id()) || (this
						.getLevel5id() != null
						&& castOther.getLevel5id() != null && this
						.getLevel5id().equals(castOther.getLevel5id())))
				&& ((this.getLevel4id() == castOther.getLevel4id()) || (this
						.getLevel4id() != null
						&& castOther.getLevel4id() != null && this
						.getLevel4id().equals(castOther.getLevel4id())))
				&& ((this.getLevel3id() == castOther.getLevel3id()) || (this
						.getLevel3id() != null
						&& castOther.getLevel3id() != null && this
						.getLevel3id().equals(castOther.getLevel3id())))
				&& ((this.getLevel2id() == castOther.getLevel2id()) || (this
						.getLevel2id() != null
						&& castOther.getLevel2id() != null && this
						.getLevel2id().equals(castOther.getLevel2id())))
				&& ((this.getLevel1id() == castOther.getLevel1id()) || (this
						.getLevel1id() != null
						&& castOther.getLevel1id() != null && this
						.getLevel1id().equals(castOther.getLevel1id())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLevel15id() == null ? 0 : this.getLevel15id().hashCode());
		result = 37 * result
				+ (getLevel14id() == null ? 0 : this.getLevel14id().hashCode());
		result = 37 * result
				+ (getLevel13id() == null ? 0 : this.getLevel13id().hashCode());
		result = 37 * result
				+ (getLevel12id() == null ? 0 : this.getLevel12id().hashCode());
		result = 37 * result
				+ (getLevel11id() == null ? 0 : this.getLevel11id().hashCode());
		result = 37 * result
				+ (getLevel10id() == null ? 0 : this.getLevel10id().hashCode());
		result = 37 * result
				+ (getLevel9id() == null ? 0 : this.getLevel9id().hashCode());
		result = 37 * result
				+ (getLevel8id() == null ? 0 : this.getLevel8id().hashCode());
		result = 37 * result
				+ (getLevel7id() == null ? 0 : this.getLevel7id().hashCode());
		result = 37 * result
				+ (getLevel6id() == null ? 0 : this.getLevel6id().hashCode());
		result = 37 * result
				+ (getLevel5id() == null ? 0 : this.getLevel5id().hashCode());
		result = 37 * result
				+ (getLevel4id() == null ? 0 : this.getLevel4id().hashCode());
		result = 37 * result
				+ (getLevel3id() == null ? 0 : this.getLevel3id().hashCode());
		result = 37 * result
				+ (getLevel2id() == null ? 0 : this.getLevel2id().hashCode());
		result = 37 * result
				+ (getLevel1id() == null ? 0 : this.getLevel1id().hashCode());
		return result;
	}

}
package com.analogics.utils;

import com.analogics.um.vo.LevelIndexMaster;

public class UserHierarchyQueryFraming {
	public StringBuffer frameUserHierarchyQuery(LevelIndexMaster levelIndexObj) {
		  
		StringBuffer sb = new StringBuffer();
		try {
			if (levelIndexObj.getId().getLevel1id() > 0)
				sb.append(" and levels.id.level1id = '" + levelIndexObj.getId().getLevel1id()+"'");
			if (levelIndexObj.getId().getLevel2id() > 0)
				sb.append(" and levels.id.level2id = '" + levelIndexObj.getId().getLevel2id()+"'");
			if (levelIndexObj.getId().getLevel3id() > 0)
				sb.append(" and levels.id.level3id = '" + levelIndexObj.getId().getLevel3id()+"'");
			if (levelIndexObj.getId().getLevel4id() > 0)
				sb.append(" and levels.id.level4id = '" + levelIndexObj.getId().getLevel4id()+"'");
			if (levelIndexObj.getId().getLevel5id() > 0)
				sb.append(" and levels.id.level5id = '" + levelIndexObj.getId().getLevel5id()+"'");
			if (levelIndexObj.getId().getLevel6id() > 0)
				sb.append(" and levels.id.level6id = '" + levelIndexObj.getId().getLevel6id()+"'");
			if (levelIndexObj.getId().getLevel7id() > 0)
				sb.append(" and levels.id.level7id = '" + levelIndexObj.getId().getLevel7id()+"'");
			if (levelIndexObj.getId().getLevel8id() > 0)
				sb.append(" and levels.id.level8id = '" + levelIndexObj.getId().getLevel8id()+"'");
			if (levelIndexObj.getId().getLevel9id() > 0)
				sb.append(" and levels.id.level9id = '" + levelIndexObj.getId().getLevel9id()+"'");
			if (levelIndexObj.getId().getLevel10id() > 0)
				sb.append(" and levels.id.level10id = '" + levelIndexObj.getId().getLevel10id()+"'");
			if (levelIndexObj.getId().getLevel11id() > 0)
				sb.append(" and levels.id.level11id = '" + levelIndexObj.getId().getLevel11id()+"'");
			if (levelIndexObj.getId().getLevel12id() > 0)
				sb.append(" and levels.id.level12id = '" + levelIndexObj.getId().getLevel12id()+"'");
			if (levelIndexObj.getId().getLevel13id() > 0)
				sb.append(" and levels.id.level13id = '" + levelIndexObj.getId().getLevel13id()+"'");
			if (levelIndexObj.getId().getLevel14id() > 0)
				sb.append(" and levels.id.level14id = '" + levelIndexObj.getId().getLevel14id()+"'");
			if (levelIndexObj.getId().getLevel15id() > 0)
				sb.append(" and levels.id.level15id = '" + levelIndexObj.getId().getLevel15id()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}
	
}

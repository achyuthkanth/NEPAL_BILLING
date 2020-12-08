package com.analogics.utils;

import com.analogics.um.dao.BaseHibernateDAO;

/**
 * 
 * @author Sandhya.B
 *
 */
public class CommonQueryFrameUtils extends BaseHibernateDAO {
	
	public StringBuilder conditionQuery(String searchSelectVar, String searchParameter, String conditionStr){
		StringBuilder strb = new StringBuilder();
		try {
			for (int i = 0; i < searchSelectVar.split(",").length; i++) {
				String [] searchVal = searchSelectVar.split(",");
				String [] searchParam = searchParameter.split(",");
				String [] conditionStrg = conditionStr.split(",");
					if(conditionStrg[i].equalsIgnoreCase("LIKE")){
						strb.append(" master."+searchVal[i]+" like '%"+searchParam[i]+"%' ");
					}else if(conditionStrg[i].equalsIgnoreCase("EQUAL TO")){
						strb.append(" master."+searchVal[i]+" = '"+searchParam[i]+"' ");
					}else if(conditionStrg[i].equalsIgnoreCase("NOT EQUAL TO")){
						strb.append(" master."+searchVal[i]+" != '"+searchParam[i]+"' ");
					}
					if(i+1 < searchSelectVar.split(",").length){
						strb.append(" or ");
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strb;
	}
	

}

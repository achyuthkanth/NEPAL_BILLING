package com.analogics.um.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author achyuth kanth pamuru
 *
 */
public class CommonDAO extends BaseHibernateDAO{
	
	
	public boolean saveOrUpdate(Object obj){
		boolean response=false;
		Session session=null;
		Transaction tr=null;
		try{
			session=getSession();
			tr=session.beginTransaction();
			session.saveOrUpdate(obj);
			tr.commit();
			response=true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return response;
	}
	
	public boolean save(Object obj){
		boolean response=false;
		Session session=null;
		Transaction tr=null;
		try{
			session=getSession();
			tr=session.beginTransaction();
			session.save(obj);
			tr.commit();
			response=true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return response;
	}
	

	public static void main(String[] args) {
		new CommonDAO().save(null);

	}

	 public String readHeader(Sheet sheet){
		    String header = "";
		    try {
		        for(Cell i: sheet.getRow(0)){
		            if(!StringUtils.isEmpty(header)){
		                header = header + ",";
		            }
		            header = header + i.getContents();
		        }               
		    }catch(Exception ex){
		        ex.printStackTrace();
		    }
		    return header;
		
		}

	public HashMap<String, String> getRowDataMap(Cell[] rowCell, HashMap<String, Integer> headerMap ) {
		 HashMap<String, String> rowDataMap = new HashMap<String, String>();
	        try{
	            String row = "";
	            for (Cell i : rowCell) {
	                if(!StringUtils.isEmpty(row)){
	                    row = row + "@";
	                }
	                row = row + i.getContents();
	            }

	            String[] rowToken = StringUtils.splitPreserveAllTokens(row, '@');

	            Set<Entry<String,Integer>> headerColumns = headerMap.entrySet();
	            int columnNo = 0;

	            for (Entry<String, Integer> column : headerColumns) {
	                columnNo = (column.getValue()).intValue();
	                if (columnNo < rowToken.length) {
	                    rowDataMap.put(column.getKey(), StringUtils.trimToEmpty(rowToken[columnNo]));
	                }
	            }

	        }catch(Exception ex){
	            ex.printStackTrace();
	        }

	        return rowDataMap;
	    }
	
	public HashMap<String, Integer> prepareHeaderMap(String header){
        HashMap<String, Integer> headerMap = new HashMap<String, Integer>();
        try{
            String headerDetails[] = StringUtils.splitPreserveAllTokens(header, ',');

            int columnCounter = 0;
            for(String headerEntry: headerDetails){
                headerMap.put(headerEntry.toUpperCase().trim(), columnCounter);
                columnCounter ++;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return headerMap;
    }
}

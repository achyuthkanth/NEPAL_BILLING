package com.analogics.dao;

import java.util.List;

import com.analogics.um.dao.BaseHibernateDAO;
import com.analogics.utils.CommonQueryFrameUtils;
import com.analogics.vo.ConsumerMaster;

/**
 * 
 * @author Sandhya.B
 *
 */
public class ConsumerMasterDao extends BaseHibernateDAO {
	
	CommonQueryFrameUtils queryFrameObj = new CommonQueryFrameUtils();

	public List<ConsumerMaster> fetchConsumerMasterList(int pageNumber,
			int parseInt, String searchParameter, String sorting,
			ConsumerMaster masterObj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long fetchConsumerMasterCount(int pageNumber, int parseInt,
			String searchParameter, String sorting, ConsumerMaster masterObj) {
		// TODO Auto-generated method stub
		return null;
	}	

}

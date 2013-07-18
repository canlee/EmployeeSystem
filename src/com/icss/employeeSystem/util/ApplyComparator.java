package com.icss.employeeSystem.util;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class ApplyComparator implements Comparator<Map<String, Object>>{

	@Override
	public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		// TODO Auto-generated method stub
		if(((Date)o1.get("applyTime")).after((Date)o2.get("applyTime")))return -1;
		else return 1;
	}

}

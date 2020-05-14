package com;

import java.io.IOException;
import java.util.List;

import com.tledu.tt.manager.DataProcessManager;
import com.tledu.tt.pojo.IPAndLocationPojo;

public class TestArraySort_03 {
 
	public static void main(String[] args) throws IOException {
		String filePath = "ip_location_relation.txt";
		String encoding = "utf-8";
		List<IPAndLocationPojo> ipAndLocationPojoList = DataProcessManager
				.getPojoList(filePath, encoding);

		IPAndLocationPojo[] ipAndLocationPojoArray = DataProcessManager
				.convertListToArrayAndSort(ipAndLocationPojoList);

		System.out.println(ipAndLocationPojoArray[0]);
		System.out
				.println(ipAndLocationPojoArray[ipAndLocationPojoArray.length - 1]);
	}
}

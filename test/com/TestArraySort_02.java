package com;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.tledu.tt.manager.DataProcessManager;
import com.tledu.tt.pojo.IPAndLocationPojo;

public class TestArraySort_02 {

	public static void main(String[] args) throws IOException {
		String filePath = "ip_location_relation.txt";
		String encoding = "utf-8";
		List<IPAndLocationPojo> ipAndLocationPojoList = DataProcessManager
				.getPojoList(filePath, encoding);

		IPAndLocationPojo[] ipAndLocationPojoArray = new IPAndLocationPojo[ipAndLocationPojoList
				.size()];
		// 转换数组
		ipAndLocationPojoList.toArray(ipAndLocationPojoArray);
		// 排序
		Arrays.sort(ipAndLocationPojoArray);
		
		System.out.println(ipAndLocationPojoArray[0]);
		System.out.println(ipAndLocationPojoArray[ipAndLocationPojoArray.length-1]);
	}
}

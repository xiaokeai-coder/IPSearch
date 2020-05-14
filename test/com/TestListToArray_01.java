package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tledu.tt.manager.DataProcessManager;
import com.tledu.tt.pojo.IPAndLocationPojo;

public class TestListToArray_01 {

	public static void main(String[] args) throws IOException {
		/**
		 * List转数组
		 */

		List<String> strList = new ArrayList<String>();
		strList.add("one");
		strList.add("two");
		strList.add("three");
		String[] strArray = new String[strList.size()];
		// strArray = (String[]) strList.toArray();
		strList.toArray(strArray);
		for (String string : strArray) {
			System.out.println(string);
		}

		/**
		 * List结构化对象 转 array
		 */

		String filePath = "ip_location_relation.txt";
		String encoding = "utf-8";
		List<IPAndLocationPojo> ipAndLocationPojoList = DataProcessManager
				.getPojoList(filePath, encoding);

		IPAndLocationPojo[] ipAndLocationPojoArray = new IPAndLocationPojo[ipAndLocationPojoList
				.size()];

		ipAndLocationPojoList.toArray(ipAndLocationPojoArray);

		for (IPAndLocationPojo ipAndLocationPojo : ipAndLocationPojoArray) {
			System.out.println(ipAndLocationPojo);
		}
	}
}

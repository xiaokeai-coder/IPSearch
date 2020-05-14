package com;

import java.io.IOException;
import java.util.List;

import com.tledu.tt.manager.DataProcessManager;
import com.tledu.tt.pojo.IPAndLocationPojo;

public class TestNonStructToStruct_03 {

	public static void main(String[] args) throws IOException {

		String ipLibarayPath = "ip_location_relation.txt";
		String encoding = "utf-8";
		List<IPAndLocationPojo> ipAndLocationPojos = DataProcessManager
				.getPojoList(ipLibarayPath, encoding);
		
		for (IPAndLocationPojo ipAndLocationPojo : ipAndLocationPojos) {
			System.out.println(ipAndLocationPojo);
		}

	}
}


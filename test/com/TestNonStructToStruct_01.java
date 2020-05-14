package com;

import java.io.IOException;
import java.util.List;

import com.tledu.tt.util.FileOperatorUtil;

public class TestNonStructToStruct_01 {

	/**
	 * 把数据行分为三列
	 * 
	 * @author 
	 * @Date 2020年5月14日
	 */

		public static void main(String[] args) throws IOException {

			String ipLibarayPath = "ip_location_relation.txt";
			String encoding = "utf-8";
			List<String> lineList = FileOperatorUtil.getLineList(ipLibarayPath,
					encoding);
			for (String line : lineList) {
				String[] columnArray = line.split("\t");
				for (String col : columnArray) {
					System.out.println(col);
				}
			}

		}
}


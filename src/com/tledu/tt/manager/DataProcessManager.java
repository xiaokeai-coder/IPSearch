package com.tledu.tt.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tledu.tt.pojo.IPAndLocationPojo;
import com.tledu.tt.util.FileOperatorUtil;
import com.tledu.tt.util.IPUtil;


/**
 * 该类为项目数据处理管理类,衔接各个模块的输入输出 进行有机组合
 * 
 * @author
 * @Date 
 */
public class DataProcessManager {
	public static void main(String[] args) {
		String adidIP = "27.128.199.131";
		String location = DataProcessManager.getLocation(adidIP);
		System.out.println(location);
	}

	private static IPAndLocationPojo[] pojoArray = null;
	static {
		// 业务二分法测试
		String ipLibraryPath = "ip_location_relation.txt";
		String encoding = "utf-8";
		List<IPAndLocationPojo> pojoList;

		try {
			pojoList = DataProcessManager.getPojoList(ipLibraryPath, encoding);
			pojoArray = DataProcessManager.convertListToArrayAndSort(pojoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把 List<String> 结构化 , 返回 List<IPAdnLocationPojo>
	 * 
	 * @param filePath
	 *            IP地址库的文件地址
	 * @param encoding
	 *            字符编码
	 * @return
	 * @throws IOException
	 */
	public static List<IPAndLocationPojo> getPojoList(String filePath,
			String encoding) throws IOException {

		List<String> lineList = FileOperatorUtil
				.getLineList(filePath, encoding);

		List<IPAndLocationPojo> ipAndLocationPojos = new ArrayList<IPAndLocationPojo>();
		for (String line : lineList) {
			// 如果有空行 直接跳过
			if (line == null || line.trim().equals("")) {
				continue;
			}
			String[] columnArray = line.split("\t");
			String startIP = columnArray[0];
			String endIP = columnArray[1];
			String location = columnArray[2];

			// 封装到对象中
			IPAndLocationPojo ipAndLocationPojo = new IPAndLocationPojo(
					startIP, endIP, location);

			ipAndLocationPojos.add(ipAndLocationPojo);
		}

		return ipAndLocationPojos;
	}

	/**
	 * 将对象的集合形式 转换为 数组形式 并 进行排序
	 * 
	 * @param pojoList
	 * @return
	 */
	public static IPAndLocationPojo[] convertListToArrayAndSort(
			List<IPAndLocationPojo> pojoList) {
		IPAndLocationPojo[] ipAndLocationPojoArray = new IPAndLocationPojo[pojoList
				.size()];
		// 转换数组
		pojoList.toArray(ipAndLocationPojoArray);
		// 排序
		Arrays.sort(ipAndLocationPojoArray);
		return ipAndLocationPojoArray;
	}

	/**
	 * 二分法查找IP
	 * 
	 * @param ipAndLocationPojoArray
	 * @param aidIP
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int binaraySearch4IPAndLocationPojo(
			IPAndLocationPojo[] ipAndLocationPojoArray, String aidIP,
			int startIndex, int endIndex) {
		// 终止条件
		if (startIndex > endIndex) {
			return -1;
		}

		int middle = (startIndex + endIndex) / 2;

		/**
		 * 思路 :
		 * 
		 * IP的值 如果 小于 起始IP段 说明在左边
		 * 
		 * 如果 大于 结束IP段 说明在右边
		 */
		// 转换为long类型
		long ipLong = IPUtil.ipToLong(aidIP);
		if (ipLong > ipAndLocationPojoArray[middle].getEndIPLong()) {
			startIndex = middle + 1;
		} else if (ipLong < ipAndLocationPojoArray[middle].getStartIPLong()) {
			endIndex = middle - 1;
		} else {
			return middle;
		}
		return binaraySearch4IPAndLocationPojo(ipAndLocationPojoArray, aidIP,
				startIndex, endIndex);
	}

	/**
	 * 对外提供接口,入参IP 出参归属地
	 * 
	 * @param ip
	 * @return
	 */
	public static String getLocation(String ip) {
		int startIndex = 0;
		int endIndex = pojoArray.length - 1;
		int resultIndex = DataProcessManager.binaraySearch4IPAndLocationPojo(
				pojoArray, ip, startIndex, endIndex);
		if (resultIndex == -1) {
			return null;
		}
		return pojoArray[resultIndex].getLocation();
	}
}

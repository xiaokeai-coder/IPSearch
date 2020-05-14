package com.tledu.tt.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tledu.tt.pojo.IPAndLocationPojo;
import com.tledu.tt.util.FileOperatorUtil;

/**
 * 该类为项目数据处理管理类,衔接各个模块的输入输出 进行有机组合
 * @author Administrator
 *
 */
public class DataProcessManager {

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
}

package com;

import java.io.IOException;
import java.util.List;

import com.tledu.tt.manager.DataProcessManager;
import com.tledu.tt.pojo.IPAndLocationPojo;
import com.tledu.tt.util.IPUtil;

/**
 * 二分法测试
 * 五部
 * 边界 左边界和右边界
 * 边界之外，左边界之外，右边界之外
 * 
 * 边界之内 有这个数据和没这个数据
 * @author Administrator
 *
 *二分法一般是递归，所以我们不能写在main方法中，要单独编写方法
 */
public class TestBinrarySearch_01 {

	public static void main(String[] args) throws IOException {
		int [] intArray ={1,3,5,7,9,22,66,};
		int aid =66;
		int startIndex=0;
		int endIndex=intArray.length-1;
		int resultIndex=binaraySearchlnt(intArray, aid, startIndex, endIndex);
		System.out.println(resultIndex);
		
		
		User u1 = new User(18, "张三1");
		User u2 = new User(20, "张三2");
		User u3 = new User(22, "张三3");
		User u4 = new User(24, "张三4");

		User[] userArray = { u1, u2, u3, u4 };

		User userAid = new User(21, "");

		startIndex = 0;
		endIndex = userArray.length - 1;
		resultIndex = binaraySearchUser(userArray, userAid, startIndex,
				endIndex);
		System.out.println(resultIndex);
		
		// 业务二分法测试
				String ipLibraryPath = "ip_location_relation.txt";
				String encoding = "utf-8";
				List<IPAndLocationPojo> pojoList = DataProcessManager.getPojoList(ipLibraryPath, encoding);
				IPAndLocationPojo[] pojoArray = DataProcessManager.convertListToArrayAndSort(pojoList);
				
				String aidIP = "123.123.123.123";
				startIndex = 0;
				endIndex = pojoArray.length-1;
				resultIndex = binaraySearch4IPAndLocationPojo(pojoArray, aidIP, startIndex, endIndex);
				System.out.println(pojoArray[resultIndex]);
	}
	/**
	 * 数组
	 * @param intArray
	 * 所查找的值
	 * @param aid
	 * 起始索引
	 * @param startIndex
	 * 最终索引
	 * @param endIndex
	 * @return
	 */
	public static int binaraySearchlnt(int[] intArray,int aid,int startIndex,int endIndex){
		//终止条件
		if(startIndex>endIndex){
			return -1;
		}
		//获取中间数据
		int middle =(startIndex+endIndex)/2;
		if(aid>intArray[middle]){
			startIndex=middle+1;
			
		}else if(aid<intArray[middle]){
			endIndex=middle-1;
		}else{
			return middle;
		}
		return binaraySearchlnt(intArray, aid, startIndex, endIndex);
	}
	//复杂类型二分法
	
	/**
	 * 数组
	 * @param intArray
	 * 所查找的值
	 * @param aid
	 * 起始索引
	 * @param startIndex
	 * 最终索引
	 * @param endIndex
	 * @return
	 */
	public static int binaraySearchUser(User[] userArray,User userAid,int startIndex,int endIndex){
		//终止条件
		if(startIndex>endIndex){
			return -1;
		}
		//获取中间数据
		int middle =(startIndex+endIndex)/2;
		if(userAid.getAge()>userArray[middle].getAge()){
			startIndex=middle+1;
			
		}else if(userAid.getAge()<userArray[middle].getAge()){
			endIndex=middle-1;
		}else{
			return middle;
		}
		return binaraySearchUser(userArray, userAid, startIndex, endIndex);
	}
	
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
}

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
public class TestBinrarySearch_03 {

	public static void main(String[] args) throws IOException {
		
String ip ="";
String location=DataProcessManager.getLocation(ip);
System.out.println(location);
	}

	
	}


package com.tledu.tt.controller;

import com.tledu.tt.manager.DataProcessManager;

public class SystemController {

	public static void main(String[] args) {
		// 1500 ~ 1600 之间
				if (args == null  || args.length == 0) {
					System.err.println("传入参数不正确,请传入要查询的IP地址!!");
					System.exit(-1);
				}
				String adidIP = args[0];
				long startMS = System.currentTimeMillis();
				String location = DataProcessManager.getLocation(adidIP);
				long endMS = System.currentTimeMillis();
				System.out.println(location);
				System.out.println(endMS - startMS);
	}
}

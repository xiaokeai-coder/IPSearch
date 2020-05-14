package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 
 * @author Administrator
 *
 */
public class TestFileIO_01 {
/**
 * 1.定义文件路径
 * 
 * 2.通过节点流对接到文件上
 * 
 * 3.转换为字符流
 * 
 * 4.添加缓冲流
 * 
 * 5.读取
 * 
 * 6.关闭流
 * 
 * 先开启的后关闭，关闭最外层的流
 * 
 * 
 */
	
	public static void main(String[] args){
		try{
			String ipLibarayPath = "ip_location_relation";
			String encoding ="utf-8";
			FileInputStream fis=new FileInputStream(ipLibarayPath);
			Reader reader =new InputStreamReader(fis,encoding);
			BufferedReader br =new BufferedReader(reader);
			
			String tempLine=null;
			
			while ((tempLine=br.readLine())!=null){
				System.out.println(tempLine);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

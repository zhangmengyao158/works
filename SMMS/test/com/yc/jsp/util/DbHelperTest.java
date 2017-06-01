package com.yc.jsp.util;
 import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import com.yc.smms.entity.Students;
import com.yc.smms.util.DbHelper;

public class DbHelperTest {

//	@Test
//	public void test() {
//      Connection con = getConn();
//      LogManager.getLogger().debug("连接成功>>>");
//      assertNotNull(con);
//	}
	@Test
	public void testGet() {
     try {
      Students news = DbHelper.get(Students.class, "select * from news where nid=80");
      System.out.println(news);
	} catch (Exception e) {
		e.printStackTrace();
	}
      
	}
	@Test
	public void testList() {
     try {
      List<Students> newss = DbHelper.list(Students.class, "select * from news");
      System.out.println(newss);
	} catch (Exception e) {
		e.printStackTrace();
	}
      
	}
	@Test
	public void testDate(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//日期转换成日期字符串
//		String dateStr = sdf.format(d); //将日期格式化一下
//		System.out.println(dateStr);
		
		//日期字符串转换成日期
		String dateStr = "2016-09-29 19:53:53";
//		Date d1 = sdf.parse(dateStr);
//		System.out.println(d1);

		
	}

}

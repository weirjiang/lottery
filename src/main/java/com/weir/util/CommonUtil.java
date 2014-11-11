package com.weir.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class CommonUtil {
	public void jsonUtil(Object o,HttpServletResponse respone) throws IOException{
		JSONObject json = JSONObject.fromObject(o);
		respone.getWriter().print(json);
	}
	
	public static void main(String args[]){
//		CommonUtil util = new CommonUtil();
//		int i= util.compare_date("1995-11-12 15:21", "1999-12-11 09:59");
//	       System.out.println("i=="+i);
		
	}
	public int compare_date(String date1,String Date2){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		 try {
	            Date dt1 = df.parse(date1);
	            Date dt2 = df.parse(Date2);
	            if (dt1.getTime() > dt2.getTime()) {
	         //       System.out.println("dt1 在dt2前");
	            //	System.out.println(dt1);
	                return -1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	       //         System.out.println("dt1在dt2后");
	              //	System.out.println(dt1);
	                return 1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	public String genterateDate(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateStr = format.format(date);
		return dateStr;
	}
	
	}


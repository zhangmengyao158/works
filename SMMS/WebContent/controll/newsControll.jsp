 <%@page import="com.yc.smms.entity.StudentsBean"%>
<%@page import="com.yc.smms.util.DbHelper"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.math.BigDecimal"%>
 <%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--声明--%>
<%!public List<Map<String, Object>> getAllStudents(int pageSize, int pageNum) throws Exception {
		String sql = String.format("select nid, ntitle, ncreatedate, nauthor from(select n.*, rownum rn from " + 
		"(select * from news order by 5) n where rownum <= %d) " + "where rn > %d", pageSize * pageNum, pageSize
				* (pageNum - 1));
		return DbHelper.findMultiObject(sql, null);
	}

	public int getTotalPage(int pageSize) throws Exception {
		String sql = String.format("select ceil(count(1)/%d) tp from students", pageSize);
		return ((BigDecimal) (DbHelper.findSingleObject(sql, null).get("TP"))).intValue();
	}
	
	//...表示可以有，可有1,也可以有多个
	public List<Map<String, Object>> getNewsByType(int...ntids) throws Exception {
		String sql = "select nid, ntid, ntitle from news";
		
		if(ntids != null && ntids.length != 0){
			sql += " where ";
			for(int ntid : ntids){
				sql += "nid in (select nid from (select * from news where ntid = " + ntid + " order by 5)  where rownum <= 5) or "; 
			}
			sql = sql.substring(0, sql.length() - 4);
		}
		System.out.println(sql);
		
		return DbHelper.findMultiObject(sql, null);
	}
	
	public Map<String, Object> getaStudentsById(String id) throws Exception {
		String sql = "select * from student where sno=" + id;
		return DbHelper.findSingleObject(sql, null);
	}
	%>

	
<%--小脚本--%>
<%
	String type =  request.getParameter("type");
	if(type == null){
		
	}
	else if("125" == type.intern()){
		
	}else if("byId" == type.intern()){
		
	}
%>
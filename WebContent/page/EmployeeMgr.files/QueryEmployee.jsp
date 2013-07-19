<%@page import="com.icss.employeeSystem.model.vo.EmployeeVo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Query Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<script type="text/javascript" src="../../js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="../../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../../js/employee/queryEmployee.js"></script>
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<STYLE type=text/css> 
body
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	text-align: center; BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(../../images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../../images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none;
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../../images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<%
	List<Integer> auths = (List<Integer>) session.getAttribute("authIds");
	EmployeeVo myInfo = (EmployeeVo) session.getAttribute("employee");
	boolean hasQueryAll = false;
	boolean hasDelete = false;
	boolean hasUpdateInfo = false;
	boolean hasUpdateAllInfo = false;
	boolean hasUpdateAuth = false;
	if(auths.contains(5)) {
		hasQueryAll = true;
	}
	if(auths.contains(2)) {
		hasDelete = true;
	}
	if(auths.contains(3)) {
		hasUpdateAllInfo = true;
		hasUpdateInfo = true;
	}
	if(auths.contains(4)) {
		hasUpdateInfo = true;
	}
	if(auths.contains(14)) {
		hasUpdateAuth = true;
	}
%>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../../images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(../../images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">查询员工信息 </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(../../images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(../../images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=center>
          <DIV>
          	<form action="queryEmployee" method="post">
          	<input style="display:none" name=target value="success">
          		员工号<input type="text" name="empId"/>
          		<%
          			if(hasQueryAll) {
          		%>
		          		部门<select name="depId">
          					<option value="%"></option>
		          		</select>
          		<%
          			}
          			else {
          		%>
          				部门<select name="depId">
          					<option value="<%=myInfo.getDepId() %>"><%=myInfo.getDepName() %></option>
          				</select>
          				<script type="text/javascript">noQueryAll(<%=myInfo.getDepId() %>);</script>
          		<%
          			}
          		%>
          		职位<select name="postId">
          			<option value="%"></option>
          		</select>
          		<input type="submit" value="查询">
          	</form>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
              	<TR>
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH class=gridViewHeader scope=col>员工号</TH>
                  <TH class=gridViewHeader scope=col>姓名</TH>
                  <TH class=gridviewHeader scope=col>性别</TH>
                  <TH class=gridviewHeader scope=col>部门¨</TH>
                  <TH class=gridviewHeader scope=col>职位</TH>
                  <TH class=gridviewHeader scope=col>查看详情</TH>
                  <%
                  	if(hasUpdateInfo || hasUpdateAuth) {
                  %>
	                  <TH class=gridviewHeader scope=col>修改</TH>
                  <%
                  	}
                  %>
                  <%
                  	if(hasDelete) {
                  %>
	                  <TH class=gridviewHeader scope=col>删除</TH>
                  <%
                  	}
                  %>
                </TR>
              <%
              	List<Map<String,Object>> employeeList = (List<Map<String,Object>>)request.getAttribute("employeeList");
                for(int i=0;i<employeeList.size();++i){
                	String sex = (String)employeeList.get(i).get("sex");
                	if(sex==null)sex="";
                	else if(sex.equals("1"))sex="男";
                	else sex="女";
              %>
                  <TR>
                  <TD class=gridViewItem style="WIDTH: 50px"><IMG 
            src="bg_users.gif"> </TD>
                  <TD class=gridViewItem><%=employeeList.get(i).get("empId") %></TD>
                  <TD class=gridViewItem><%=employeeList.get(i).get("empName") %></TD>
                  <TD class=gridViewItem><%=sex %></TD>
                  <TD class=gridViewItem><%=employeeList.get(i).get("depName") %></TD>
                  <TD class=gridViewItem><%=employeeList.get(i).get("postName") %></TD>
                  <TD class=gridViewItem><A class=cmdField 
            href="queryEmployee?empId=<%=employeeList.get(i).get("empId") %>&target=individual">查询详情</A></TD>
                  <TD class=gridViewItem>
                  	<%
                  		if(hasUpdateInfo) {
                  			if(hasUpdateAllInfo) {
                  	%>
			                  	<A class="cmdField" 
			            		href="queryEmployee?empId=<%=employeeList.get(i).get("empId") %>&target=updateOthers">个人资料</A>
                 	<%
                  			}
                  			else {
                  				if(myInfo.getDepId() == (Integer) employeeList.get(i).get("depId")) {
                  	%>
                  					<A class="cmdField" 
			            		href="queryEmployee?empId=<%=employeeList.get(i).get("empId") %>&target=updateOthers">个人资料</A>
                  	<%
                  				}
                  			}
                  		}
                  	%>
            		<%
            			if(hasUpdateAuth) {
            		%>
		            		<A class="cmdField"  
		            		href="queryAuthority?empId=<%=employeeList.get(i).get("empId") %>">权限</A>
            		<%
            			}
            		%>
            	  </TD>
            	  <%
            	  	if(hasDelete) {
            	  %>
	                  <TD class=gridViewItem><A class=cmdField 
	            id=ctl00_ContentPlaceHolder2_GridView1_ctl03_LinkButton1 
	            onclick="return confirm('确定删除？');" 
	            href="deleteEmployee?empId=<%=employeeList.get(i).get("empId") %>">删除</A> </TD>
            	  
            	  <%
            	  	}
            	  %>
                </TR>
              			
              <%
                }
              %>                                                        
              </TBODY>	
            </TABLE>
            <div class="selectPage" align="right">
            	<a href="">上一页</a>
            	<select name="page">
            		<option value="1">1</option>
            	</select>
            	<a href="">下一页</a>
            </div>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(../../images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(../../images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(../../images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(../../images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(../../images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
<SCRIPT type=text/javascript>
//<![CDATA[
Sys.Application.initialize();
//]]>
</SCRIPT>
</BODY>
</HTML>

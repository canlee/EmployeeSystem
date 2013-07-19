<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Update Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../../js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="../../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../../js/public/dateSelect.js"></script>
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
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../../images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../../images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
.gridViewBtn {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid;
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">修改员工信息 </SPAN><SPAN 
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
          <%
          	List<Map<String,Object>> employeeList = (List<Map<String,Object>>)request.getAttribute("employeeList");
          %>
          	<form action="updateEmployee" method="post">
          	<input style="display:none" name="empId" value="<%=employeeList.get(0).get("empId") %>">
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 70%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
                <TR>
                  <TD class=gridViewHeader>员工号</TD>
                  <TD class=gridViewItem><%=employeeList.get(0).get("empId") %></TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>姓名</TD>
                  <TD class=gridViewItem><input type="text" name="empName" value="<%=employeeList.get(0).get("empName") %>"/></TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>性别</TD>
                  <TD class=gridViewItem>
                  <%
                  	if(employeeList.get(0).get("sex")==null){                 		
                  %>
                  	    <input type="radio" name="sex" value="1"/>男
                  		<input type="radio" name="sex" value="0"/>女
                  <%
                  	}
                  	else if(employeeList.get(0).get("sex").equals("1")){
                  %>
                  		<input type="radio" name="sex" value="1" checked="checked"/>男
                  		<input type="radio" name="sex" value="0"/>女
                  <%
                  	}
                  	else{
                  %>
                  		<input type="radio" name="sex" value="1"/>男
                  		<input type="radio" name="sex" value="0" checked="checked"/>女
                  <%
                  	}
                  %> 
                  </TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>联系电话</TD>
                  <TD class=gridViewItem><input type="text" name="phone" value="<%=employeeList.get(0).get("phone") %>"/></TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>电子邮件</TD>
                  <TD class=gridViewItem><input type="text" name="email" value="<%=employeeList.get(0).get("email") %>"/></TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>住址</TD>
                  <TD class=gridViewItem><input type="text" name="address" value="<%=employeeList.get(0).get("address") %>"/></TD>
                </TR> 
                <TR>
                  <TD class=gridViewHeader>生日(年-月-日)</TD>
                  <TD class=gridViewItem>
                  	<select id="year" name="year"></select>年
                  	<select id="month" name="month"></select>月
                  	<select id="day" name="day"></select>日
                  </TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>工资</TD>
                  <TD class=gridViewItem><input type="text" name="salary" value="<%=employeeList.get(0).get("salary") %>"/></TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>部门</TD>
                  <TD class=gridViewItem>
                  	<select name="department">
                  		<option value="1">技术部</option>
                  		<option value="2">人事部</option>
                  		<option value="2">宣传部</option>
                  	</select>
                  </TD>
                </TR>
                <TR>
                  <TD class=gridViewHeader>职位</TD>
                  <TD class=gridViewItem>
                  	<select name="post">
                  		<option value="1">普通员工</option>
                  		<option value="2">部长</option>
                  	</select>
                  </TD>
                </TR>
                <TR>
                	<TD class="gridViewBtn" colspan="2" align="right">
                		<input class="buttonBlue" type="submit" value="提交"/>
                		<input class="buttonBlue" type="reset" value="重置"/>
                	</TD>
                </TR>                                                                      
              </TBODY>
            </TABLE>
            </form>
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

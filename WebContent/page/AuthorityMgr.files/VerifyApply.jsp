<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Verify Apply Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<STYLE type=text/css> 
body
{
	FONT-SIZE: 5px
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">审批申请 </SPAN><SPAN 
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
          	List<Map<String,Object>> applyList = (List<Map<String,Object>>)request.getAttribute("ApplyList");
          %>
          	<form action="queryApply">
          		<input style="display:none" name="target" value="verify"/>
          		员工号<input type="text" name="empId"/>
          		申请类型<select name="type">
          			<option value="-1"></option>
          			<option value="0">请假</option>
          			<option value="1">申请加薪</option>
          			<option value="2">申请调部门</option>
          		</select>
          		部门<select name="department">
          			<option value="%"></option>
          			<option value="技术部">技术部</option>
          			<option value="人事部">人事部</option>
          			<option value="宣传部">宣传部</option>
          		</select>
          		<input type="submit" value="查询">
          	</form>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
              	<TR>
              	  <TH class=gridViewHeader scope=col>申请类型</TH>
                  <TH class=gridViewHeader scope=col>申请人号</TH>
                  <TH class=gridViewHeader scope=col>申请人名</TH>
                  <TH class=gridViewHeader scope=col>申请时间</TH>
                  <TH class=gridviewHeader scope=col>查看详情</TH>
                </TR>
                <%
                	for(int i=0;i<applyList.size();++i){
                		String type = (String)applyList.get(i).get("type");
                		int flag = Integer.parseInt(type);
              			String applyId;
              			String target;
                		switch(flag){
        					case 0:{
        						type = "请假";
        						applyId = Integer.toString((Integer)applyList.get(i).get("applyHolidayId"));
      							target = "vholiday";
        						break;
        					}
        					case 1:{
        						type = "申请加薪";
        						applyId = Integer.toString((Integer)applyList.get(i).get("applySalaryId"));
      							target = "vsalary";
        						break;
        					}
        					case 2:{
        						type = "申请调部门";
        						applyId = Integer.toString((Integer)applyList.get(i).get("applyDepId"));
      							target = "vdep";
        						break;
        					}
        					default:{
        						type = "";
        						applyId = "";
      							target = "";
        						break;
        					}
        				}
                %>
                  <TR>
                  <TD class=gridViewItem><%=type %></TD>                  
                  <TD class=gridViewItem><%=applyList.get(i).get("empId") %></TD>
                  <TD class=gridViewItem><%=applyList.get(i).get("empName") %></TD>
                  <TD class=gridViewItem><%=applyList.get(i).get("applyTime") %></TD>
                  <TD class=gridViewItem><A class=cmdField 
            href="queryApply?type=<%=flag%>&target=<%=target%>&applyId=<%=applyId %>">查看详情</A></TD>
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

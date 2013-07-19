<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Verify Change Department Page</TITLE>
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
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center;
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">审批调部门 </SPAN><SPAN 
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
          	<form>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 70%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
               <%
          		List<Map<String,Object>> applyList = (List<Map<String,Object>>)request.getAttribute("ApplyList");
          		String type = (String)applyList.get(0).get("type");
          		String sex = (String)applyList.get(0).get("sex");
          		if(sex==null)sex = "";
          		else if(sex.equals("1"))sex = "男";
          		else sex = "女";
  				int flag = Integer.parseInt(type);
  				switch(flag){
						case 0:{
							type = "请假";
							break;
						}
						case 1:{
							type = "申请加薪";
							break;
						}
						case 2:{
							type = "申请调部门";
							break;
						}
						default:{
							type = "";
							break;
						}
					}
  				String status = (String)applyList.get(0).get("status");
  				int sta = Integer.parseInt(status);
  				switch(sta){
						case 0:{
							status = "等待审批";
							break;
						}
						case 1:{
							status = "通过申请";
							break;
						}
						case 2:{
							status = "拒绝申请";
							break;
						}
						default:{
							status = "";
							break;
						}
				}
            
         	  %>           
              <TBODY>
                <TR>
                  <th class=gridViewHeaderMax>申请类型</th>
                  <TD class=gridViewItem><%=type %></TD>
                </TR>              
                <TR>
                  <th class=gridViewHeaderMax>员工号</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("empId") %></TD>
                </TR>
                <TR>
                  <th class=gridViewHeaderMax>姓名</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("empName") %></TD>
                </TR>
                <TR>
                  <th class=gridViewHeaderMax>性别</th>
                  <TD class=gridViewItem><%=sex %></TD>
                </TR>
                <TR>
                  <th class=gridViewHeaderMax>工资</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("salary") %></TD>
                </TR>
                <TR>
                  <th class=gridViewHeaderMax>部门</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("depName") %></TD>
                </TR>
                <TR>
                  <th class=gridViewHeaderMax>职位</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("postName") %></TD>
                </TR> 
                <TR>
                  <th class=gridViewHeaderMax>想调到的部门</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("applyDepName") %></TD>
                </TR>  
                <TR>
                  <th class=gridViewHeaderMax>想调到的岗位</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("applyPostName") %></TD>
                </TR> 
                <TR>
                  <th class=gridViewHeaderMax>申请时间</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("applyTime") %></TD>
                </TR> 
                <TR>
                  <th class=gridViewHeaderMax style="background-color: #ECF5FF; background-image: none;">原因</th>
                  <TD class=gridViewItem><%=applyList.get(0).get("description")==null?applyList.get(0).get("description"):"" %></TD>
                </TR>           
                <TR>
                	<TD class="gridViewItem" colspan="2" align="right">
                	<A class=cmdField 
            href="verifyApply?type=<%=flag%>&empId=<%=applyList.get(0).get("empId") %>&status=1&post=<%=applyList.get(0).get("applyPost") %>&applyId=<%=applyList.get(0).get("applyDepId") %>">通过申请</A>
            		<A class=cmdField 
            href="verifyApply?type=<%=flag%>&status=2&applyId=<%=applyList.get(0).get("applyDepId") %>">拒绝申请</A>
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

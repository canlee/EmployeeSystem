<%@page import="com.icss.employeeSystem.model.vo.EmployeeVo"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Apply For Holiday Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/public.css" type=text/css rel=stylesheet>
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../../js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="../../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../../js/public/holidaySelect.js"></script>
<script type="text/javascript" src="../../js/authority/applyHoliday.js"></script>
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">请假 </SPAN><SPAN 
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
          	<form id="form_applyHoliday" action="applyHoliday" method="post">
          	<input style="display: none" name="empId" value="<%=((EmployeeVo)session.getAttribute("employee")).getEmpID() %>" />
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 70%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader>假期长度</TH>
                  <TD class=gridViewItem>
                  	<div class="float_left" style="margin-left: 165px; _margin-left: 90px;">
	                  	<input type="text" name="holidayLength"/>
	                  	<span class="tips">请输入整数</span>
                  	</div>
                  </TD>
                </TR>
                <TR>
                  <TH class=gridViewHeader>起始日期(年-月-日)</TH>
                  <TD class=gridViewItem>
                  	<select id="holidayYear" name="holidayYear"></select>年
                  	<select id="holidayMonth" name="holidayMonth"></select>月
                  	<select id="holidayDay" name="holidayDay"></select>日
                  </TD>
                </TR>
                <TR>
                  <TH class=gridViewHeader style="background-color: #ECF5FF; background-image: none;">原因</TH>
                  <TD class=gridViewItem><textarea name="reason" cols="50" rows="15"></textarea></TD>
                </TR>
                <TR>
                	<TD class="gridViewBtn" colspan="2" align="right">
                		<input id="btn_submit" class="buttonBlue" type="button" value="提交"/>
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
</BODY>
</HTML>

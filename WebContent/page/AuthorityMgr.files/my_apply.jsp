<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(../../images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid; 
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">�ҵ����� </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(../../images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(../../images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=middle>
          <DIV>
          <%
          	List<Map<String,Object>> applyList = (List<Map<String,Object>>)request.getAttribute("ApplyList");
          %>
          	<form action="queryApply" method="post">
          		<input style="display:none" name="target" value="show"/>
	          	<div align="center" style="margin: 10px;">
	          		�������ͣ�
	          		<select name="type">
	          			<option value="-1"></option>
	          			<option value="0">���</option>
	          			<option value="1">�����н</option>
	          			<option value="2">���������</option>
	          		</select>
	          		����״̬��
	          		<select name="status">
	          			<option value="%"></option>
	          			<option value="0">�ȴ�����</option>
	          			<option value="1">ͨ������</option>
	          			<option value="2">�ܾ�����</option>
	          		</select>
	          		<input class="buttonBlue" type="submit" value="��ѯ">
	          	</div>
        	</form>
	          <form action="">
	            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
	      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
	      border=1>
	              <TBODY>
	                <TR>
	                  <TH class=gridViewHeader scope=col>��������</TH>
	                  <th class="gridViewHeader" scope="col">����ʱ��</th>
	                  <th class="gridViewHeader" scope="col">����״̬</th>
	                  <th class="gridViewHeader" scope="col">�鿴����</th>
	                </TR>
	              <%
	              	for(int i=0;i<applyList.size();++i){
              			String type = (String)applyList.get(i).get("type");
              			String applyId;
              			String target;
              			int flag = Integer.parseInt(type);
              			switch(flag){
      						case 0:{
      							type = "���";
      							applyId = Integer.toString((Integer)applyList.get(i).get("applyHolidayId"));
      							target = "iholiday";
      							break;
      						}
      						case 1:{
      							type = "�����н";
      							applyId = Integer.toString((Integer)applyList.get(i).get("applySalaryId"));
      							target = "isalary";
      							break;
      						}
      						case 2:{
      							type = "���������";
      							applyId = Integer.toString((Integer)applyList.get(i).get("applyDepId"));
      							target = "idep";
      							break;
      						}
      						default:{
      							type = "";
      							applyId = "";
      							target = "";
      							break;
      						}
      					}
              			String status = (String)applyList.get(i).get("status");
              			int sta = Integer.parseInt(status);
              			switch(sta){
      						case 0:{
      							status = "�ȴ�����";
      							break;
      						}
      						case 1:{
      							status = "ͨ������";
      							break;
      						}
      						case 2:{
      							status = "�ܾ�����";
      							break;
      						}
      						default:{
      							status = "";
      							break;
      						}
      					}
	              %>
	                <TR>
	                  <td class=gridViewItem scope=col><%=type %></td>
	                  <td class="gridViewItem"><%=applyList.get(i).get("applyTime") %></td>
	                  <td class="gridViewItem"><%=status %></td>
	                  <td class="gridViewItem"><a class="cmdField" href="queryApply?type=<%=flag%>&target=<%=target%>&applyId=<%=applyId %>">��ѯ����</a></td>
	                </TR>
	              <%
	              	}
	              %>	                
	              </TBODY>
	            </TABLE>
	            <div class="selectPage" align="right">
            	<a href="">��һҳ</a>
            	<select name="page">
            		<option value="1">1</option>
            	</select>
            	<a href="">��һҳ</a>
            </div>
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

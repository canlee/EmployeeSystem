<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.icss.employeeSystem.model.po.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="../../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../../js/post/updatePost.js"></script>
<script type="text/javascript" src="../../js/public/toast.js"></script>
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
<%
	List<Department> deps = (List<Department>) request.getAttribute("departments");
	JSONArray json = JSONArray.fromObject(deps);
	List<Integer> auths = (List<Integer>) session.getAttribute("authIds");
	boolean hasUpdateAuth = false;
	if(auths.contains(14)) {
		hasUpdateAuth = true;
	}
%>
<script type="text/javascript">saveDeps(<%=json.toString() %>);</script>
</head>
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">修改岗位 </SPAN><SPAN 
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
          <form action="" id="form_update_post" method="post">
          	<div align="center" style="padding: 10px;">
          		<span>选择部门：</span>
          		<select name="depId" size="1" style="margin: 10px; width: 100px;">
          			<option value=""></option>
          			<%
          				if(deps != null) {
          					for(Department dep : deps) {
          			%>
          						<option value="<%=dep.getDepId() %>"><%=dep.getDepName() %></option>
          			<%
          					}
          				}
          			%>
          		</select>
          		<br>
          		<span>选择岗位：</span>
          		<select name="postId" size="1" style="margin: 10px; width: 100px;">
          			<option value=""></option>
          		</select>
          		<br>
          	</div>
	            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
	      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
	      border=1>
	              <TBODY>
	              	<TR>
	                  <TH class=gridViewHeader scope=col>部门名称</TH>
	                  <td class="gridViewItem" id="depName"></td>
	                </TR>
	                <TR>
	                  <TH class=gridViewHeader scope=col>岗位名称</TH>
	                  <th class="gridViewItem"><input name="postName" type="text" value=""></th>
	                </TR>
	                <%
	                	if(hasUpdateAuth) {
	                %>
		                <TR>
		                  <TH class=gridViewHeader scope=col>岗位所有人员权限</TH>
		                  <th class="gridViewItem"><a class="cmdField" href="../AuthorityMgr.files/AddAuthority.html">去看看</a></th>
		                </TR>
	                <%
	                	}
	                %>
	              </TBODY>
	            </TABLE>
	          </form>
	          <div align="center" id="btn_ok">
	          	<button id="btn_delete" class="buttonBlue" style="margin: 10px 30px 10px 10px;">删除部门</button>
	          	<button id="btn_update" class="buttonBlue" style="margin: 10px 10px 10px 30px;">确定修改</button>
	          </div>
	          <div class="tips"></div>
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
<%
	String result = (String) request.getParameter("result");
	if(result != null) {
		if(result.equals("update_success")) {
%>
			<script type="text/javascript">Toast("修改岗位成功！", 2000);</script>
<%
		}
		else if(result.equals("update_fail")) {
%>
			<script type="text/javascript">Toast("修改岗位失败！", 2000);</script>
<%
		}
		else if(result.equals("delete_success")) {
%>
			<script type="text/javascript">Toast("删除岗位成功！", 2000);</script>
<%
		}
		else if(result.equals("delete_fail")) {
%>
			<script type="text/javascript">Toast("删除岗位失败！", 2000);</script>
<%
		}
	}
%>
</html>
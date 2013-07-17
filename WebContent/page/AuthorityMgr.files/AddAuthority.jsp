<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>AddAuthority Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<script type="text/javascript" src="../../js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="../../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../../js/authority/authority_select.js"></script>
<LINK href="../../css/page.css" type=text/css rel=stylesheet>
<LINK href="../../css/authority/add_authority.css" type=text/css rel=stylesheet>
<STYLE type=text/css> 
body
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	text-align: center; BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid;
	background-color: #DDEEFF;

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
.authority_choose {
	max-width: 300px;
	word-break : break-all;
	BORDER-RIGHT: #bad6ec 1px solid; 
	BORDER-TOP: #bad6ec 1px solid; 
	BORDER-LEFT: #bad6ec 1px solid; 
	LINE-HEIGHT: 32px; 
	BORDER-BOTTOM: #bad6ec 1px solid; 
}
.authority_choose input {
	margin: 10px;
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
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">添加权限 </SPAN><SPAN 
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
          	List<Map<String,Integer>> authorityList = (List<Map<String,Integer>>)request.getAttribute("authorityList");
    		String[] flag = new String[23];
          	if(authorityList!=null){
          		for(int i=0;i<authorityList.size();++i){
          			int index = (Integer)authorityList.get(i).get("authorityId");
          			flag[index] = "checked=\"checked\"";
          		}
          	}
          	for(int i=1;i<23;++i){
          		if(flag[i]==null)
          			flag[i] = "";
          	}
          %>
          	<form action="addAuthority">
          	<input style="display:none" name="empId" value="<%=request.getAttribute("empId")%>"/>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1
      style="WIDTH: 90%; BORDER-COLLAPSE: collapse" cellSpacing=5 rules=all 
      border=1	 cellpadding="5px">
              <TBODY>
                <TR><TH class="gridViewHeader" colspan="2" style="background-color: #D2E9FF;">选择赋予的权限</TH></TR>     
                <TR>
                	<TD class="gridViewHeader" style="background-color: #ECF5FF;">员工管理模块</TD>
                	<TD class="authority_choose">
                		<ul>
		                	<li><input class="authority" type="checkbox" name="authority" value="1" <%=flag[1] %>/>增加员工</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="2" <%=flag[2] %>/>删除员工</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="3" <%=flag[3] %>/>修改所有员工信息</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="4" <%=flag[4] %>/>修改自己部门员工信息</li>
		   					<li><input class="authority" type="checkbox" name="authority" value="5" <%=flag[5] %>/>查询所有员工信息</li>
	   					</ul>
   					</TD>
                </TR> 
                <TR>
                <TD class="gridViewHeader">部门管理模块</TD>
                    <TD class="authority_choose">
                    	<ul>
		                    <li><input class="authority" type="checkbox" name="authority" value="6" <%=flag[6] %>/>增加部门</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="7" <%=flag[7] %>/>删除部门</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="8" <%=flag[8] %>/>修改部门</li>
		               		<li><input class="authority" type="checkbox" name="authority" value="9" <%=flag[9] %>/>查询部门</li>
	               		</ul>
               		</TD>               	
                </TR>
                <TR>
                	<TD class="gridViewHeader"  style="background-color: #ECF5FF;">岗位管理模块</TD>
                	<TD class="authority_choose">
                		<ul>
		                	<li><input class="authority" type="checkbox" name="authority" value="10" <%=flag[10] %>/>增加岗位</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="11" <%=flag[11] %>/>删除岗位</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="12" <%=flag[12] %>/>修改岗位</li> 
		                	<li><input class="authority" type="checkbox" name="authority" value="13" <%=flag[13] %>/>查询岗位</li>
		            	</ul>
		            </TD>        
                </TR> 
                <TR>
                	<TD class="gridViewHeader">权限管理模块</TD>
               		<TD class="authority_choose">
               			<ul>
		               		<li><input class="authority" type="checkbox" name="authority" value="14"  <%=flag[14] %>/>修改权限</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="15"  <%=flag[15] %>/>查询权限</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="16"  <%=flag[16] %>/>申请请假</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="17"  <%=flag[17] %>/>申请加薪</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="18" <%=flag[18] %>/>申请调部门</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="19" <%=flag[19] %>/>审批所有员工休假</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="20" <%=flag[20] %>/>审批自己部门请假</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="21" <%=flag[21] %>/>审批加薪申请</li>
		                	<li><input class="authority" type="checkbox" name="authority" value="22" <%=flag[22] %>/>审批调部门申请</li>
                		</ul>
                	</TD>
                </TR>  
                <TR><TD class="authority_choose"  colspan="2" align="right">
                	<input class="buttonBlue" type="submit" value="提交"/>
            	</TD></TR>              
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

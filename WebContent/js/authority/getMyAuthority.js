$(document).ready(function() {
	$.post(
		"getAuthority", 
		{}, 
		function(result) {
			setAuthority(result.authorities);
		}, 
		'json'
	);
});

function setAuthority(authIds) {
	var tree = null;
	var root = new TreeNode('系统菜单');
	var fun1 = new TreeNode('员工管理');
	var fun5 = new TreeNode('部门管理');
	var fun9 = new TreeNode('岗位管理');
	var fun13 = new TreeNode('权限管理');
	
	var fun3 = null;
	var fun7 = null;
	var fun8 = null;
	var fun11 = null;
	var fun12 = null;
	var fun152 = null;
	var fun_allApply = null;
	
	$(authIds).each(function(i) {
		switch (i) {
		case 1:
			var fun2 = new TreeNode('添加员工', 'EmployeeMgr.files/InsertEmployee.html', 'tree_node.gif', null, 'tree_node.gif', null);
			fun1.add(fun2);
			break;
			
		case 2:
		case 3:
		case 4:
		case 5:
			if(fun3 == null) {
				fun3 = new TreeNode('查询员工信息', 'EmployeeMgr.files/queryEmployee?target=success', 'tree_node.gif', null, 'tree_node.gif', null);
				fun1.add(fun3);
			}
			break;
			
		case 6:
			var fun6 = new TreeNode('增加部门', 'DepartmentMgr.files/addDep', 'tree_node.gif', null, 'tree_node.gif', null);
			fun5.add(fun6);
			break;
			
		case 7:
		case 8:
			if(fun7 == null && fun8 == null) {
				fun7 = new TreeNode('查询部门', 'DepartmentMgr.files/queryDep', 'tree_node.gif', null, 'tree_node.gif', null);
				fun5.add(fun7);
				fun8 = new TreeNode('修改部门', 'DepartmentMgr.files/getUpdateDep', 'tree_node.gif', null, 'tree_node.gif', null);
				fun5.add(fun8);
			}
			break;
			
		case 9:
			if(fun7 == null) {
				fun7 = new TreeNode('查询部门', 'DepartmentMgr.files/queryDep', 'tree_node.gif', null, 'tree_node.gif', null);
				fun5.add(fun7);
			}
			break;
			
		case 10:
			var fun10 = new TreeNode('增加岗位', 'PostMgr.files/post_insert.htm', 'tree_node.gif', null, 'tree_node.gif', null);
			fun9.add(fun10);
			break;
			
		case 11:
		case 12:
			if(fun11 == null && fun12 == null) {
				fun11 = new TreeNode('查询岗位', 'PostMgr.files/post_query.htm', 'tree_node.gif', null, 'tree_node.gif', null);
				fun9.add(fun11);
				fun12 = new TreeNode('修改岗位', 'PostMgr.files/post_update.htm', 'tree_node.gif', null, 'tree_node.gif', null);
				fun9.add(fun12);
			}
			break;
			
		case 13:
			if(fun11 == null) {
				fun11 = new TreeNode('查询岗位', 'PostMgr.files/post_query.htm', 'tree_node.gif', null, 'tree_node.gif', null);
				fun9.add(fun11);
			}
			break;
			
		case 16:
			var fun14 = new TreeNode('请假', 'AuthorityMgr.files/ApplyForHoliday.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
			fun13.add(fun14);
			break;
			
		case 17:
			var fun15 = new TreeNode('申请加薪', 'AuthorityMgr.files/ApplyForSalaryIncrease.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
			fun13.add(fun15);
			break;

		case 18:
			var fun151 = new TreeNode('申请调部门', 'AuthorityMgr.files/ApplyForChangeDep.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
			fun13.add(fun151);
			break;
			
		case 19:
		case 20:
		case 21:
		case 22:
			if(fun152 == null && fun_allApply == null) {
				fun152 = new TreeNode('审批申请', 'AuthorityMgr.files/VerifyApply.html', 'tree_node.gif', null, 'tree_node.gif', null);
				fun13.add(fun152);
				fun_allApply = new TreeNode('所有审批', 'AuthorityMgr.files/all_apply.htm', 'tree_node.gif', null, 'tree_node.gif', null);
				fun13.add(fun_allApply);
			}
			break;
			
		default:
			break;
		}
	});
	
	var fun4 = new TreeNode('个人信息查询', 'EmployeeMgr.files/queryEmployee?target=individual', 'tree_node.gif', null, 'tree_node.gif', null);
	fun1.add(fun4);
	var fun_update_myinfo = new TreeNode('个人信息修改', 'EmployeeMgr.files/queryEmployee?target=update', 'tree_node.gif', null, 'tree_node.gif', null);
	fun1.add(fun_update_myinfo);
	
	var fun_myApply = new TreeNode('我的申请', 'AuthorityMgr.files/my_apply.htm', 'tree_node.gif', null, 'tree_node.gif', null);
	fun13.add(fun_myApply);
	
	root.add(fun1);
	root.add(fun5);
	root.add(fun9);
	root.add(fun13);
	tree = new Tree(root);
	tree.show('menuTree');
}

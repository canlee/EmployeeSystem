var departments = null;

$(document).ready(function() {
	$("select[name='depId']").change(function() {
		$(".tips").css("display", "none");
		var value = $("select[name='depId']").attr("value");
		if(value != "") {
			$("#depName").attr("value", getDepartmentById(value));
		}
		else {
			$("#depName").attr("value", "");
		}
	});
	
	$("#btn_update").click(function() {
		var value = $("select[name='depId']").attr("value");
		var depName = $("#depName").attr("value");
		if(value != "") {
			if(!hasDepartmen(depName)) {
				$("#form_update_department").attr("action", "updateDep");
				$("#form_update_department").submit();
			}
			else {
				if(getDepartmentById(value) != depName) {
					$(".tips").css("display", "block");
				}
			}
		}
	});
	
	$("#btn_delete").click(function() {
		var depId = $("select[name='depId']").attr("value");
		if(depId != "") {
			var depName = getDepartmentById(depId);
			if(confirm("确定删除 " + depName + "？")) {
				$("#form_update_department").attr("action", "deleteDep");
				$("#form_update_department").submit();
			}
		}
	});
});

function getDepartmentById(id) {
	if(departments != null) {
		for(var i = 0; i < departments.length; i++) {
			if(departments[i].depId == id) {
				return departments[i].depName;
			}
		}
	}
	return "";
}

function hasDepartmen(dep) {
	if(departments != null) {
		for(var i = 0; i < departments.length; i++) {
			if(departments[i].depName == dep) {
				return true;
			}
		}
	}
	return false;
}

/**
 * 保存所有的部门缓存
 * @param deps
 */
function saveDeps(deps) {
	departments = deps;
}
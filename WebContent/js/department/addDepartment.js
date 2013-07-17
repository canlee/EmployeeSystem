var departments = null;

$(document).ready(function() {
	$("#btn_add").click(function() {
		var dep = $("#input_dep").attr("value");
		if(dep == "") {
			$(".tips").html("部门输入不能为空");
			$(".tips").css("display", "block");
		}
		else {
			if(hasDepartmen(dep) == false) {
				$(".tips").css("display", "none");
				$("#form_addDep").submit();
			}
			else {
				$(".tips").html("已经存在该部门");
				$(".tips").css("display", "block");
			}
		}
	});
});

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
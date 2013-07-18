function onClick(){
	var empId = document.getElementById("empId");
	var empName = document.getElementById("empName");
	var password = document.getElementById("password");
	var salary = document.getElementById("salary");
	var postId = document.getElementById("post");
	var flag = 0;
	if(empId.value==""){
		document.getElementById("empIds").style.diaplay = "block";
		flag = 1;
	}
	if(empName.value==""){
		document.getElementById("empNames").innerHTML = "员工名不能为空";
		flag = 1;
	}
	if(password.value==""){
		document.getElementById("passwords").innerHTML = "密码不能为空";
		flag = 1;
	}
	if(salary.value==""){
		document.getElementById("salarys").innerHTML = "工资不能为空";
		flag = 1;
	}
	if($("#post").attr("value")==""){
		document.getElementById("posts").innerHTML = "职位不能为空";
		flag = 1;
	}
	if(flag==0){
		document.getElementById("insertForm").submit();
	}
}

$(document).ready(function() {
	$("#btn_submit").click(function() {
		var judge = false;
		if($("#empId").attr("value") == "") {
			$("#empIds").css("display", "inline");
			judge = true;
		}
		if($("#empName").attr("value") == "") {
			$("#empNames").html("员工名不能为空");
			$("#empNames").css("display", "inline");
			judge = true;
		}
		if($("#password").attr("value") == "") {
			$("#passwords").html("密码不能为空");
			$("#passwords").css("display", "inline");
			judge = true;
		}
		if($("#salary").attr("value") == "") {
			$("#salarys").html("工资不能为空");
			$("#salarys").css("display", "inline");
			judge = true;
		}
		if($("#post").attr("value") == "") {
			$("#posts").html("职位不能为空");
			$("#posts").css("display", "inline");
			judge = true;
		}
		if(!judge) {
			$("#insertForm").submit();
		}
	});
});

/*<----------------------------------    ------------------------------->*/

var posts = [{"depId": "", "posts": []}];

$(document).ready(function() {
	$.post(
			"getAllDep", 
			{}, 
			function(result) {
				setDepartment(result.departments);
			}, 
			'json'
	);
});

$(document).ready(function() {
	$("select[name='department']").change(function() {
		var depId = $("select[name='department']").attr("value");
		var posts = getPostByDep(depId);
		if(depId != "") {
			if(posts != null) {
				setPost(posts);
			}
			else {
				$.post(
						"queryPostsByDep", 
						{
							depId: depId
						}, 
						function(result) {
							addPosts(result.posts);
							setPost(result.posts.posts);
						}, 
						'json'
				);
			}
		}
	});
});

function getPostByDep(depId) {
	for(var i = 0; i < posts.length; i++) {
		if(posts[i].depId == depId) {
			return posts[i].posts;
		}
	}
	return null;
}

function setDepartment(data) {
	var html = "<option value=\"\"></option>";
	$(data).each(function(i, dep) {
		html += "<option value=\"" + dep.depId + "\">" + dep.depName + "</option>";
	});
	$("select[name='department']").html(html);
}

function setPost(data) {
	var html = "<option value=\"\"></option>";
	$(data).each(function(i, post) {
		html += "<option value=\"" + post.postId + "\">" + post.postName + "</option>";
	});
	$("#post").html(html);
}

function addPosts(data) {
	posts[posts.length] = data;
}

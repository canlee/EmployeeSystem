var departments = null;
var posts = [{"depId": "", "posts": []}];

$(document).ready(function() {
	$("select[name='depId']").change(function() {
		$(".tips").css("display", "none");
		var depId = $("select[name='depId']").attr("value");
		var allPosts = getPostsByDep(depId);
		if(allPosts != null) {
			setPosts(allPosts);
		}
		else {
			$.post(
					"queryPostsByDep", 
					{
						depId: depId
					}, 
					function(result) {
						addPosts(result.posts);
						setPosts(result.posts.posts);
					}, 
					'json'
				);
		}
	});
	
	$("select[name='postId']").change(function() {
		$(".tips").css("display", "none");
		var postId = $("select[name='postId']").attr("value");
		if(postId != "") {
			var depName = $("select[name='depId'] option:selected").text();
			var postName = $("select[name='postId'] option:selected").text();
			$("#depName").html(depName);
			$("input[name='postName']").attr("value", postName);
		}
	});
});

/**
 * 按钮
 */
$(document).ready(function() {
	$("#btn_update").click(function() {
		$(".tips").css("display", "none");
		var postName = $("input[name='postName']").attr("value");
		if(postName != $("select[name='postId'] option:selected").text()) {
			var postId = $("select[name='postId']").attr("value");
			if(postId != "") {
				var depId = $("select[name='depId']").attr("value");
				if(!hasPostByDep(depId, postName))  {
					$("#form_update_post").attr("action", "update");
					$("#form_update_post").submit();
				}
				else {
					$(".tips").html("该部门已经存在该岗位！");
					$(".tips").css("display", "block");
				}
			}
		}
	});
	
	$("#btn_delete").click(function() {
		$(".tips").css("display", "none");
		var depId = $("select[name='depId']").attr("value");
		var postId = $("select[name='postId']").attr("value");
		if(depId != "" && postId != "") {
			var depName = getDepartmentById(depId);
			var postName = getPostById(depId, postId);
			if(confirm("确定删除 " + depName + " 下的 " + postName + " 岗位?")) {
				$("#form_update_post").attr("action", "delete");
				$("#form_update_post").submit();
			}
		}
	});
});

function setPosts(allPosts) {
	var html = "<option value=\"\"></option>";
	$(allPosts).each(function(i, p) {
		html += "<option value=\"" + p.postId + "\">" + p.postName + "</option>";
	});
	$("select[name='postId']").html(html);
}

function hasPostByDep(depId, postName) {
	for(var i = 0; i < posts.length; i++) {
		if(depId == posts[i].depId) {
			for(var j = 0; j < posts[i].posts.length; j++) {
				if(postName == posts[i].posts[j].postName) {
					return true;
				}
			}
			return false;
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

function getPostsByDep(depId) {
	for(var i = 0; i < posts.length; i++) {
		if(posts[i].depId == depId) {
			return posts[i].posts;
		}
	}
	return null;
}

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

function getPostById(depId, postId) {
	for(var i = 0; i < posts.length; i++) {
		if(depId == posts[i].depId) {
			for(var j = 0; j < posts[i].posts.length; j++) {
				if(postId == posts[i].posts[j].postId) {
					return posts[i].posts[j].postName;
				}
			}
			return "";
		}
	}
	return "";
}

function addPosts(data) {
	posts[posts.length] = data;
}
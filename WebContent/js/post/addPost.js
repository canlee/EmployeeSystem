var departments = null;
var posts = [{"depId": "", "posts": []}];

/**
 * 选择部门监听
 */
$(document).ready(function() {
	$("select[name='depId']").change(function() {
		$(".tips").css("display", "none");
		var value = $("select[name='depId']").attr("value");
		var allPost = getPostsByDep(value);
		if(allPost != null) {
			setPosts(allPost);
		}
		else {
			$.post(
				"getPostsByDep", 
				{
					depId: value
				}, 
				function(result) {
					allPost = result.posts;
					addPosts(allPost);
					setPosts(allPost.posts);
				}, 
				'json'
			);
		}
	});
});

/**
 * 添加监听
 */
$(document).ready(function() {
	$("#btn_add").click(function() {
		$(".tips").css("display", "none");
		var depId = $("select[name='depId']").attr("value");
		if(depId != "") {
			var postName = $("input[name='postName']").attr("value");
			if(postName != null && postName != "") {
				if(!hasPost(depId, postName)) {
					$("#form_insert_post").submit();
				}
				else {
					$(".tips").html("已经存在该岗位！");
					$(".tips").css("display", "block");
				}
			}
			else {
				$(".tips").html("岗位名称不能为空！");
				$(".tips").css("display", "block");
			}
		}
	});
});

function setPosts(allPost) {
	var html = "";
	$(allPost).each(function(i, p) {
		html += "<span>" + p + "</span>";
	});
	$("#all_post").html(html);
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

function addPosts(data) {
	posts[posts.length] = data;
}

function hasPost(depId, postName) {
	for(var i = 0; i < posts.length; i++) {
		if(depId == posts[i].depId) {
			for(var j = 0; j < posts[i].posts.length; j++) {
				if(posts[i].posts[j] == postName) {
					return true;
				}
			}
			return false;
		}
	}
	return false;
}
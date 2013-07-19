var departments = null;
var posts = [{"depId": "", "posts": []}];

$(document).ready(function() {
	$("select[name='depId']").change(function() {
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
});

$(document).ready(function() {
	$("#btn_query").click(function() {
		var depId = $("select[name='depId']").attr("value");
		var postId = $("select[name='postId']").attr("value");
		if(depId != "" && postId != "") {
			$.post(
				"queryPost", 
				{
					postId: postId
				}, 
				function(result) {
					setPostInfo(result.postInfo);
				}, 
				'json'
			);
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

function setPostInfo(data) {
	$("#postName").html(data.postName);
	$("#employeeCount").html(data.employeeCount);
	$("tr").remove(".empInfo");
	var html = $("#postInfo").html();
	$(data.employees).each(function(i, emp) {
		html += "<tr class=\"empInfo\">" +
					"<td class=\"gridViewItem\" scope=\"col\" colspan=\"2\" id=\"" + emp.empId + "\">" + emp.empName + "</td>" + 
				"</tr>";
	});
	$("#postInfo").html(html);
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
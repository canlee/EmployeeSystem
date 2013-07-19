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
	$("select[name='depId']").change(function() {
		var depId = $("select[name='depId']").attr("value");
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
	var html = "<option value=\"%\"></option>";
	$(data).each(function(i, dep) {
		html += "<option value=\"" + dep.depId + "\">" + dep.depName + "</option>";
	});
	$("select[name='depId']").html(html);
}

function setPost(data) {
	var html = "<option value=\"%\"></option>";
	$(data).each(function(i, post) {
		html += "<option value=\"" + post.postId + "\">" + post.postName + "</option>";
	});
	$("select[name='postId']").html(html);
}

function addPosts(data) {
	posts[posts.length] = data;
}

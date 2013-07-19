var myDepId = null;
var myPostId = null;
var posts = [{"depId": "", "posts": []}];
var firstRun = true;

function setMyDepId(depId) {
	myDepId = depId;
}

function setMyPostId(postId) {
	myPostId = postId;
}


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
	var html = "";
	$(data).each(function(i, dep) {
		if(dep.depId == myDepId) {
			html += "<option selected=\"selected\" value=\"" + dep.depId + "\">" + dep.depName + "</option>";
			if(firstRun) {
				$.post(
						"queryPostsByDep", 
						{
							depId: myDepId
						}, 
						function(result) {
							addPosts(result.posts);
							setPost(result.posts.posts);
						}, 
						'json'
				);
			}
		}
		else {
			html += "<option value=\"" + dep.depId + "\">" + dep.depName + "</option>";
		}
	});
	$("select[name='department']").html(html);
}

function setPost(data) {
	var html = "";
	$(data).each(function(i, post) {
		if(firstRun && post.postId == myDepId) {
			firstRun = false;
			html += "<option selected=\"selected\" value=\"" + post.postId + "\">" + post.postName + "</option>";
		}
		else {
			html += "<option value=\"" + post.postId + "\">" + post.postName + "</option>";
		}
	});
	$("select[name='post']").html(html);
}

function addPosts(data) {
	posts[posts.length] = data;
}

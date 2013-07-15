function onSubmit(){
	var userName = document.getElementById("txtUserName");
	var userPwd = document.getElementById("txtUserPassword");
	if(userName.value==""||userPwd.value=="")
	{
		document.getElementById("userName").innerHTML="用户名或密码不能为空";
	}
	else {
		document.getElementById("form_login").submit();
	}
}
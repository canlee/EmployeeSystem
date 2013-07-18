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
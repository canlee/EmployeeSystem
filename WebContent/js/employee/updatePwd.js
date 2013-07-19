$(document).ready(function() {
	$("#btn_submit").click(function() {
		var judge = false;
		if($("input[name='oldPassword']").attr("value") == "") {
			$("#oldPwdTips").css("display", "inline");
			judge = true;
		}
		if($("input[name='password']").attr("value") == "") {
			$("#pwdTips").css("display", "inline");
			judge = true;
		}
		if($("input[name='confirmPassword']").attr("value") != $("input[name='password']").attr("value")) {
			$("#confirmPwdTips").css("display", "inline");
			judge = true;
		}
		if(!judge) {
			$("#form_updatePwd").submit();
		}
	});
});
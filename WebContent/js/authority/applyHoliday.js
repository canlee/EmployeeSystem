$(document).ready(function() {
	$("#btn_submit").click(function() {
		var days = $("input[name='holidayLength']").attr("value");
		if(days != "" && isInteger(days)) {
			$("#form_applyHoliday").submit();
		}
		else {
			$(".tips").css("display", "inline");
		}
	});
});

function isInteger(num) {
	var type = "^([0-9]*)$";
    var re = new RegExp(type);
    if(num.match(re) != null) {
    	return true;
    }
    return false;
}
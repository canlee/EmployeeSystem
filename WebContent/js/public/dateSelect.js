/**
 * 设置日期选择
 */
$(document).ready(function() {
	var child = "";
	var date = new Date();
	for(var i = 1900; i <= date.getFullYear(); i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#year").html(child);
	child = "";
	for(var i = 1; i <= 12; i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#month").html(child);
	child = "";
	for(var i = 1; i <= 31; i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#day").html(child);
});

/**
 * 日期选择时的监听
 */
$(document).ready(function() {
	$("#year").change(function() {
		setDay();
	});
	
	$("#month").change(function() {
		setDay();
	});
});

/**
 * 检查是否闰年
 */
function isLeapYear(year) {
	if(year % 100 != 0) {
		if(year % 4 == 0) {
			return true;
		}
	}
	else {
		if(year % 400 == 0) {
			return true;
		}
	}
	return false;
}

/**
 * 根据年月来设置下拉框的日期
 */
function setDay() {
	var days = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var year = $("#year").val();
	var month = $("#month").val();
	var day = days[month - 1];
	if(isLeapYear(year) && month == 2) {
		day++;
	}
	var child = "";
	for(var i = 1; i <= day; i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#day").html(child);
}
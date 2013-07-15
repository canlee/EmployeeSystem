var days = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

/**
 * 请假的起始日期选择设置
 */
$(document).ready(function() {
	var currentDate = new Date();
	var child = "";
	for(var i = currentDate.getFullYear(), j = 0; j < 10; i++, j++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#holidayYear").html(child);
	child = "";
	for(var i = currentDate.getMonth() + 1; i <= 12; i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#holidayMonth").html(child);
	var day = days[currentDate.getMonth()];
	if(isLeapYear(currentDate.getFullYear())) {
		if(currentDate.getMonth() == 1) {
			day++;
		}
	}
	child = "";
	for(var i = currentDate.getDate(); i <= day; i++) {
		child += "<option value=\"" + i + "\">" + i + "</option>";
	}
	$("#holidayDay").html(child);
});

/**
 * 日期选择时的监听
 */
$(document).ready(function() {
	$("#holidayYear").change(function() {
		setMonth();
	});
	
	$("#holidayMonth").change(function() {
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

function setMonth() {
	var currentDate = new Date();
	var year = $("#holidayYear").val();
	var child = "";
	if(year < currentDate.getFullYear()) {
		year = currentDate.getFullYear();
		$("#holidayYear").val(year);
	}
	if(year == currentDate.getFullYear()) {
		for(var i = currentDate.getMonth() + 1; i <= 12; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
		$("#holidayMonth").html(child);
		var day = days[currentDate.getMonth()];
		if(isLeapYear(currentDate.getFullYear())) {
			if(currentDate.getMonth() == 1) {
				day++;
			}
		}
		child = "";
		for(var i = currentDate.getDate(); i <= day; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
		$("#holidayDay").html(child);
	}
	else {
		for(var i = 1; i <= 12; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
		$("#holidayMonth").html(child);
		child = "";
		for(var i = 1; i <= 31; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
		$("#holidayDay").html(child);
	}
}

/**
 * 根据年月来设置下拉框的日期
 */
function setDay() {
	var currentDate = new Date();
	var year = $("#holidayYear").val();
	var month = $("#holidayMonth").val();
	if(year == currentDate.getFullYear() && month < currentDate.getMonth() + 1) {
		month = currentDate.getMonth() + 1;
		$("#holidayMonth").val(month);
	}
	var day = days[month - 1];
	if(isLeapYear(year) && month == 2) {
		day++;
	}
	var child = "";
	if(year == currentDate.getFullYear() && month == currentDate.getMonth() + 1) {
		for(var i = currentDate.getDate(); i <= day; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
	}
	else {
		for(var i = 1; i <= day; i++) {
			child += "<option value=\"" + i + "\">" + i + "</option>";
		}
	}
	$("#holidayDay").html(child);
}
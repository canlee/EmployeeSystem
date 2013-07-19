$(document).ready(function() {
	$("#btn_query").click(function() {
		var depId = $("select[name='department']").attr("value");
		if(depId != "") {
			$.post(
				"queryDetailDep", 
				{
					depId: depId
				}, 
				function(result) {
					setDepartmentInfo(result.depInfo);
				}, 
				'json'
			);
		}
	});
});

function setDepartmentInfo(data) {
	$("#department_name").html(data.depName);
	$("#employee_count").html(data.employeeCount);
	$("tr").remove(".empInfo");
	var html = $("#table_dep").html();
	for(var i = 0; i < data.employeeCount; i++) {
		var emp = data.employees[i];
		html += 
			"<tr class=\"empInfo\">" +
				"<td class=\"gridViewItem\" scop=\"col\">" + emp.empName + "</td>" + 
				"<td class=\"gridViewItem\" scop=\"col\">" + emp.postName + "</td>";
			"</tr>";
	}
	$("#table_dep").html(html);
}
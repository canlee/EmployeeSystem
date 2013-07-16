$(document).ready(function() {
	var ele = $("input.authority");
	ele.click(function() {
		if((this.value == 1 || this.value == 2 || this.value == 3) 
				&& this.checked == true) {
			ele[4].checked = true;
		}
		else if(this.value == 5 && this.checked == false) {
			ele[0].checked = false;
			ele[1].checked = false;
			ele[2].checked = false;
		}
		else if((this.value == 6 || this.value == 7 || this.value == 8)
				&& this.checked == true) {
			ele[8].checked = true;
		}
		else if(this.value == 9 && this.checked == false) {
			ele[5].checked = false;
			ele[6].checked = false;
			ele[7].checked = false;
		}
		else if((this.value == 10 || this.value == 11 || this.value == 12) && 
				this.checked == true) {
			ele[12].checked = true;
		}
		else if(this.value == 13 && this.checked == false) {
			ele[9].checked = false;
			ele[10].checked = false;
			ele[11].checked = false;
		}
		else if(this.value == 14 && this.checked == true) {
			ele[14].checked = true;
		}
		else if(this.value == 15 && this.checked == false) {
			ele[13].checked = false;
		}
	});
});

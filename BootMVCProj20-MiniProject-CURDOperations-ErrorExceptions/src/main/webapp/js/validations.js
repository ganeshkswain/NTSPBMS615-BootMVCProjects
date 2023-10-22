
function validation(frm) {
	//empty the error message
	document.getElementById("enameErr").innerHTML = "";
	document.getElementById("jobErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	//read Form data
	let ename = frm.ename.value;
	let job = frm.job.value;
	let sal = frm.sal.value;
	let flag = true;
	//form validations(client side)
	if (ename == "") {//ename required
		document.getElementById("enameErr").innerHTML = "Employee Number is Mandatory(cs)"
		flag = false;
	}
	else if (ename.length > 10) {//ename-max length rule
		document.getElementById("enameErr").innerHTML = "Employee name must have max of 10 chars(cs)";
		flag = false;

	}
	if (job == "") {
		document.getElementById("jobErr").innerHTML = "Employee Desg can have max 9 characters(cs)";
		flag = false;
	}
	else if (job.length > 9) {//job max length rule
		document.getElementById("jobErr").innerHTML = "Employee Desg can have max of 9 chars(cs)";
		flag = false;
	}
	if (sal == "") {
		document.getElementById("salErr").innerHTML = "Employee Salary is required(cs)";
		flag = false;
	}
	else if (isNaN(sal)) {
		document.getElementById("salErr").innerHTML = "Employee Salary must be numeric value(cs)";
		flag = false;
	}
	else if (sal < 1000 || sal > 100000) {
		document.getElementById("salErr").innerHTML = "Employee Salary must be in the range 1000 through 100000(cs)";
	}
	//change vflag value to "yes" indicating client side  form validations are not done
	frm.vflag.value="yes"
	
	return flag;
}

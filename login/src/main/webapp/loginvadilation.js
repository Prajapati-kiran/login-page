function validate(){
	var id = document.login.id.value;
	var password = document.login.pass.value;
	
	if(id==""){
		alert("Id is Mandatory");
		document.login.id.focus();
		return false;
	}
	if(password==""){
		alert("Password is Mandatory");
		document.login.id.focus();
		return false;
	}
	if(isNaN(id)){
		alert("Id must be a Number");
		document.login.id.value="";
		document.login.pass.value="";
		document.login.id.focus();
		return false;
	}
	return true;
}
function validate(){
	var name = document.login.name.value;
	var age = document.login.age.value;
	var id = document.login.id.value;
	var password = document.login.pass.value;
	
	if(id=="" || password=="" ||name=="" || age==""){
		alert("Enter all the fields");
		return false;
	}
	if(isNaN(id) || isNaN(age)){
		alert("Id or age must be a Number");
		document.login.id.value="";
		document.login.name.value="";
		document.login.age.value="";
		document.login.pass.value="";
		return false;
	}
	return true;
}
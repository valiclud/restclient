function validateForm(form) {
	
    if (form.username.value == "") {
        alert("User Name must be filled out");
        return false;
    }
    
    if (form.password.value == "") {
        alert("Password must be filled out");
        return false;
    }
}
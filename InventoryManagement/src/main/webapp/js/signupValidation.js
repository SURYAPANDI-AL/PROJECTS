/**
 * 
 */

var obj= new XMLHttpRequest();

function validateForm() {
	var namePattern = /^[a-zA-Z]+[ a-zA-Z]*$/;
	var shopNamePattern = /^[a-zA-Z]+[ a-zA-Z]*$/;
	var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
	var contactPattern = /^[6-9]\d{9}$/;
	console.log(document.getElementById("userName"));
	console.log(document.getElementById("userName").value);
	var userName = document.getElementById("userName").value;
	var shopName = document.getElementById("shopName").value;
	var email = document.getElementById("email").value;
	var contact = document.getElementById("contact").value;
	var password = document.getElementById("password").value;
	var rPassword = document.getElementById("re-password").value;

	if (!namePattern.test(userName))
		alert("Please enter a valid name.");

	else if (!shopNamePattern.test(shopName))
		alert("Please enter a valid shopname.");

	else if (!emailPattern.test(email))
		alert("Please enter a valid email address.");

	else if (!passwordPattern.test(password))
		alert("Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one specialcharacter and one number.");

	else if (password !== rPassword)
		alert("Passwords does not match.");

	else if (!contactPattern.test(contact))
		alert("Please enter valid mobile number");

	else
		register();

}

function register() {
	

	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			let result = obj.responseText;
			console.log(result);
			if (result == 1) {
				alert("your account has created successfully.");
				window.open("http://localhost:8080/InventoryManagement/login.html","_self");
			} else if(result == 2){
				alert("your account has been already registered.");
			}else{
				alert("some invalid data fetched on server end.");
			}
		}
	}
	obj.open("POST", "http://localhost:8080/InventoryManagement/RegisterationServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("userName=" + userName.value + "&shopName=" + shopName.value + "&email=" + email.value + "&contact=" + contact.value + "&password=" + password.value);
}


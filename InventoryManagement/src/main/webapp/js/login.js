
var obj = new XMLHttpRequest();

function validateLogin() {
	var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;

	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;

	if (!emailPattern.test(email))
		alert("Please enter a valid email address.");
	else if (!passwordPattern.test(password))
		alert("invalid password.");
	else
		login();

}

function login() {
	obj.onreadystatechange = function() {
		if (obj.readyState == 4) {
			var curUser = obj.responseText;
			if (curUser === null) {
				window.alert("invalid email or password");
				window.open("login.html");
			} else {
				//log
				console.log("a valid user in login function");
				window.open("home.html", "_self");
			}
		}
	}
	var email = document.getElementById("email");
	var password = document.getElementById("password");
	obj.open("POST", "http://localhost:8080/InventoryManagement/Login");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("email=" + email.value + "&password=" + password.value);
}

/*************************************************************************************************************************************** */

function forgotPassword() {
	var login = document.getElementById("login");
	login.style.display = "none";
	//log
	console.log("inside the forgot password")
	var forgotPassword = document.getElementById("forgot-password");
	forgotPassword.innerHTML = `
		<div class="container " style="width: 50%;" >
		<div class="row justify-content-center mt-5">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<div id="login">
							<h5 class="card-title text-center">Forget Password</h5>
							<form>
								<div class="form-group mb-3">
									<label for="mail">Email</label>
										<input type="email" id="forgot-email" name="email" required>
									</div>
									<div class="form-group mb-3 text-center">
										<button type="button" class="btn btn-primary w-50 " onclick="checkForUser()">Submit</button>
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	`;
}
var emailToRetrive;
function checkForUser(){
	emailToRetrive=document.getElementById("forgot-email").value;
	
	obj.onreadystatechange=function(){
		if(obj.readyState==4){
			let response =JSON.parse(obj.responseText);
			console.log(response);
			if(response ==1){
				var forgotPassword = document.getElementById("forgot-password");
				forgotPassword.innerHTML="";
				forgotPassword.innerHTML = `
						<div class="container " style="width: 50%;" >
		<div class="row justify-content-center mt-5">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<div id="login">
							<h5 class="card-title text-center">Forget Password</h5>
							<table id="create-new-password" >
								<tr>
									<td>New Password</td>
									<td><input type="password" id="new-password-id" placeholder="password"/></td>
								</tr>
								<tr>
									<td>Confirm password</td>
									<td><input type="password" id="confirm-password-id" placeholder="password"/></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;" ><span id="captcha"></span></td>
								</tr>
								<tr >
									<td colspan="2" style="text-align: center; margin-bottom: 10px;" ><input type="text" placeholder="Captcha" id="cpatchaTextBox"/></td>
								</tr>
								<tr class="mt-2">
									<td colspan="2" style="text-align: center;" ><button type="submit" class="btn btn-primary w-50 " onclick="validateCaptcha()">Submit</button></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
				`;
				createCaptcha();
			}else if(response==-1){
				alert("no such account available.");
				window.open("http://localhost:8080/InventoryManagement/login.html","_self");
			}
			
		}
	}
	console.log(emailToRetrive);
	obj.open("POST", "http://localhost:8080/InventoryManagement/Login");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("email=" + emailToRetrive + "&password=" + null);
}



var code;
function createCaptcha() {
  //clear the contents of captcha div first 
  console.log("inside create captcha");
  document.getElementById('captcha').innerHTML = "";
  var charsArray =
  "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$%^&*";
  var lengthOtp = 6;
  var captcha = [];
  for (var i = 0; i < lengthOtp; i++) {
    var index = Math.floor(Math.random() * charsArray.length + 1); 
    if (captcha.indexOf(charsArray[index]) == -1)
      captcha.push(charsArray[index]);
    else i--;
  }
  var canv = document.createElement("canvas");
  canv.id = "captcha";
  canv.width = 100;
  canv.height = 50;
  var ctx = canv.getContext("2d");
  ctx.font = "25px Georgia";
  ctx.strokeText(captcha.join(""), 0, 30);
  code = captcha.join("");
  document.getElementById("captcha").appendChild(canv);
}
function validateCaptcha() {
	console.log(document.getElementById("cpatchaTextBox").value);
  if (document.getElementById("cpatchaTextBox").value == code) {
    validatePassword();
  }else{
    alert("Invalid Captcha. try Again");
    createCaptcha();
  }
}

function validatePassword(){
	var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
	var newPassword=document.getElementById("new-password-id").value;
	
	if (!passwordPattern.test(newPassword))
		alert("Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one specialcharacter and one number.");
	else
		getNewPassword();
}

function getNewPassword(){
	var newPassword=document.getElementById("new-password-id").value;
	console.log(emailToRetrive);
	console.log(newPassword);
	obj.onreadystatechange=function(){
		if(obj.readyState==4){
			if(obj.responseText != null){
				alert("password updated successfully");
			}
			window.open("http://localhost:8080/InventoryManagement/login.html","_self");
		}
	}
	
	obj.open("POST", "http://localhost:8080/InventoryManagement/UpdatePasswordServlet");
	obj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	obj.send("email=" + emailToRetrive + "&password=" + newPassword);
}


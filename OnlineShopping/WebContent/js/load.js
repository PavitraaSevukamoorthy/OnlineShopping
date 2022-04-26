
function login(){
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "loginpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function login_validate(){
	event.preventDefault();
	var email = document.getElementById('email_id').value;
	var password = document.getElementById('password').value;
	const request = new XMLHttpRequest();
	var url = window.location.pathname +"login?email="+email+"&pass="+password;
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var msg = this.response
			if (msg == 1){
				admin() ; 	    
			}
			else if (msg == 2){
				manager();
			}
			else if (msg == 3){
				customer();
			}
			else {window.alert(msg+"Username or Password entered is wrong")}
		}
	}
	request.open("GET", url);
	request.send();
}

function admin(){
	document.getElementById('login').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "adminpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}

function manager(){
	document.getElementById('login').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "managerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}

function customer(){
	document.getElementById('login').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "customerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}

function signuppage(){
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "signuppage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function signup(){
	event.preventDefault();
	var role = document.getElementById('role').value;
	var lname = document.getElementById('last_name').value;
	var fname = document.getElementById('first_name').value;
  	var email = document.getElementById('email_id').value;
  	var password = document.getElementById('password').value;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "signup?role="+role+"&lastname="+lname+"&firstname="+fname+"&email="+email+"&pass="+password;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Sign-up Successful");
			document.getElementById("signup").remove();
			index();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function index(){
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "indexpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}
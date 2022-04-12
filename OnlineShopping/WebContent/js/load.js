
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
			if (msg == 2){
				manager();
			}
			if (msg == 3){
				customer();
			}
		}
	}
	request.open("GET", url, false );
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
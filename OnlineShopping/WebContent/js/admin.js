function changepasspage(){
	event.preventDefault();
	document.getElementById('admin').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "changepasswordpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function changepassword() {
	event.preventDefault();
	var password = document.getElementById('password').value;
	const request = new XMLHttpRequest();
	var url = window.location.pathname +"changepassword?new_password="+password;
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.alert("Password updated Successfully");
			document.getElementById("changepassword").remove();
			admin();
		}
	}
  request.open("GET", url );
  request.send();
}


function createmanagerpage(){
	event.preventDefault();
	document.getElementById('admin').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "createmanagerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function createmanager() {
	event.preventDefault();
	var role = document.getElementById('role').value;
	var lname = document.getElementById('last_name').value;
	var fname = document.getElementById('first_name').value;
  	var email = document.getElementById('email_id').value;
  	var password = document.getElementById('password').value;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "createmanager?role="+role+"&lastname="+lname+"&firstname="+fname+"&email="+email+"&pass="+password;
  	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.alert("Manager Creation was Successful");
			document.getElementById('createmanager').remove();
			admin();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function viewmanager(){
	event.preventDefault();
	document.getElementById('admin').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "ViewManager";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function goback(){
	event.preventDefault();
	document.getElementById("viewmanager").remove();
	document.getElementById("gbutton").remove();
	admin();

}

function removemanagerpage(){
	event.preventDefault();
	document.getElementById('admin').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "removemanagerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function removemanager(){
	event.preventDefault();	
	var id = document.getElementById('id').value;
	const request = new XMLHttpRequest();
	var url = window.location.pathname + "removemanager?ID="+id;
	request.onreadystatechange = function (){
			if(this.readyState == 4 && this.status==200){
				window.alert("Manager removed Successfully");
				document.getElementById('removemanager').remove();
				admin();
			}
		}
	  	request.open("GET", url );
	  	request.send();
}
function addiventorypage(){
	event.preventDefault();
	document.getElementById('admin').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "addinventorypage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function addinventory(){
	event.preventDefault();
	var pid = document.getElementById('pid').value;
	var pname = document.getElementById('pn').value;
	var pdes = document.getElementById('pd').value;
  	var price = document.getElementById('price').value;
  	var quant = document.getElementById('quantity').value;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "addinventory?product_id="+pid+"&product_name="+pname+"&product_des="+pdes+"&price="+price+"&quantity="+quant;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Products were added to the Inventory ");
			document.getElementById('abutton').remove();
			document.getElementById('add_inventory').remove();
			document.getElementById('add_inventory_table').remove();
			document.getElementById('head').remove();
			admin();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function removeproduct(a){
	event.preventDefault();
	var pid = a;
	console.log(pid);
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "removeinventory?productid="+pid;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Product was removed from Inventory ");
			innventory();
		}
	}
  	request.open("GET", url );
  	request.send();
}
function innventory(){
	event.preventDefault();
	document.getElementById("inventory").remove();
	document.getElementById("ibutton").remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "Inventory";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function inventory(){
	event.preventDefault();
	document.getElementById('admin').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "Inventory";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function gooback(){
	event.preventDefault();
	document.getElementById("inventory").remove();
	document.getElementById("ibutton").remove();
	admin();

}

function logout(){
	document.getElementById('admin').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "Logout";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.location.replace(window.location.pathname);
		}
	}
	request.open("GET",url);
	request.send();
}

function admin(){
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
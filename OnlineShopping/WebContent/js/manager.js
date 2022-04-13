function changepassmanagerpage(){
	event.preventDefault();
	document.getElementById('manager').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "changepasswordmanagerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function changepasswordmanager() {
	event.preventDefault();
	var password = document.getElementById('password').value;
	const request = new XMLHttpRequest();
	var url = window.location.pathname +"changepassword?new_password="+password;
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.alert("Password updated Successfully");
			document.getElementById("changepasswordmanager").remove();
			manager();
		}
	}
  request.open("GET", url );
  request.send();
}


function addiventorympage(){
	event.preventDefault();
	document.getElementById('manager').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "addinventorympage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function addinventorymanager(){
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
			window.alert("Product was successfully added to the Inventory");
			document.getElementById('abutton').remove();
			document.getElementById('add_inventory').remove();
			document.getElementById('add_inventory_table').remove();
			document.getElementById('head').remove();
			manager();
		}
	}
  	request.open("GET", url );
  	request.send();
}


function removeproduct(a){
	event.preventDefault();
	var pid = a;
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
	const url = window.location.pathname + "InnventoryM";
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
	document.getElementById('manager').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "InnventoryM";
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
	manager();

}


function logout(){
	document.getElementById('manager').remove();
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

function manager(){
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
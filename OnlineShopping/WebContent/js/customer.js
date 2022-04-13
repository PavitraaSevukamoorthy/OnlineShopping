function changepasspagecustomer(){
	event.preventDefault();
	document.getElementById('customer').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "changepasswordcustomerpage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function changepasswordcustomer() {
	event.preventDefault();
	var password = document.getElementById('password').value;
	const request = new XMLHttpRequest();
	var url = window.location.pathname +"changepassword?new_password="+password;
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.alert("Password updated Successfully");
			document.getElementById("changepasswordcustomer").remove();
			customer();
		}
	}
  request.open("GET", url );
  request.send();
}

function products(){
	event.preventDefault();
	document.getElementById('customer').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "products";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}


function addtocart(a, b){
	event.preventDefault();
	var pid = a;
	var req = b;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "addtocart?productid="+pid+"&req="+req;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Product was Successfully added to cart ");
			prroducts();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function prroducts(){
	event.preventDefault();
	document.getElementById('products').remove();
	document.getElementById('addtocart').remove();
	document.getElementById('button').remove();
	document.getElementById('gbutton').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "products";
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
	document.getElementById('products').remove();
	document.getElementById('addtocart').remove();
	document.getElementById('button').remove();
	document.getElementById('gbutton').remove();
	customer();
}

function viewcart(){
	event.preventDefault();
	document.getElementById('customer').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "viewcart";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}


function removecart(a){
	event.preventDefault();
	var pid = a;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "removefromcart?productid="+pid;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Product was removed from Cart ");
			vcr();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function vcr(){
	event.preventDefault();
	document.getElementById("cart").remove();
	document.getElementById("ibutton").remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "viewcart";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}

function purchase(a){
	event.preventDefault();
	var pid = a;
  	const request = new XMLHttpRequest();
  	var url = window.location.pathname + "purchase?productid="+pid;
  	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert(this.response);
			vcp();
		}
	}
  	request.open("GET", url );
  	request.send();
}

function vcp(){
	event.preventDefault();
	document.getElementById("cart").remove();
	document.getElementById("ibutton").remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "viewcart";
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
	document.getElementById("cart").remove();
	document.getElementById("ibutton").remove();
	customer();

}


function logout(){
	document.getElementById('customer').remove();
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


function viewpurchasehistory(){
	document.getElementById('customer').remove();
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "ViewPurchaseHistory";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function goooback(){
	document.getElementById('ph').remove();
	document.getElementById('button').remove();
	customer();
}

function addtowalletpage(){
	event.preventDefault();
	document.getElementById('customer').remove();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "WalletPage";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			document.write(this.response);
		}
	}
	request.open("GET",url);
	request.send();
}

function addtowallet(){
	event.preventDefault();
	var amount = document.getElementById("amount").value;
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "addtowallet?amount="+amount;
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert("Amount successfully added to wallet");
			document.getElementById('addtowallet').remove();
			customer();
		}
	}
	request.open("GET",url);
	request.send();
}

function walletbalance(){
	event.preventDefault();
	const request = new XMLHttpRequest();
	const url = window.location.pathname + "WalletBal";
	request.onreadystatechange = function (){
		if(this.readyState == 4 && this.status==200){
			window.alert(this.response);
			}
		}
	request.open("GET",url);
	request.send();
}

function customer(){
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

function logIn() {
	console.log("in logIn page");
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		console.log("inside ORSC Login " + xhr.readyState);
		
		if (xhr.readyState == 4 && xhr.status==200){
			console.log(JSON.parse(xhr.response));
			username = JSON.parse(xhr.response);
			
			if (username.username !== "null") {
				setLoginButton(username.username);
			} else {
				setLoginButton(null);
			}
		}
		
	}
	xhr.open("GET", 'http://localhost:8080/NewTrms/home', true);
	xhr.send();
}
window.onload = function() {
	logIn();
	console.log("onload ready");
}

function logOut() {
	console.log("in logOut");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", 'http://localhost:8080/NewTrms/login', true);
    xhr.send();
    /*
    logging out no need for onreadystatechange
    xhr.onreadystatechange = function() {
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
*/
}
window.onload = function() {
	logOut();
}
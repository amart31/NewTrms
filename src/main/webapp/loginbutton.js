function setLoginButton(username) {
    console.log("setting username to loggin/loggout btn")
    document.getElementById("login").setAttribute("href", "login.html");

    if (username !== null) {
        document.getElementById("login").innerHTML = username + " | Log Out";
    } else {
        document.getElementById("login").innerHTML = "Log In";
    }
}


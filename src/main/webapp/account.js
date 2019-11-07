
//load the EmployeeBean into the account.html fields
function loadAccount(account){
		//grab fields by id
    document.getElementById("username").innerHTML=account.username;
    document.getElementById("employeeId").innerHTML=account.employeeId;
    document.getElementById("reimbursement").innerHTML=account.reimbursement;

}
//ajax request to get account
function getAccount(){
console.log( "in getAccount function js!");
//where do i grab the username from to return the EmployeeDao?
//should  i create a getEmployeeBean method w a String username parameter?
let username=document.getElementById("login").value;
var xhr= new XMLHttpRequest();
xhr.onreadystatechange= function() {
    console.log("in ORSC "+ xhr.readyState );
    if(xhr.readyState==4 && xhr.status==200){
        console.log(xhr.responseText);
        var account= JSON.parse(xhr.responseText);
        loadAccount(account);
    }
}
xhr.open("GET","http://localhost:8080/NewTrms/account?username=" + username,true);
xhr.send();
}

//used to post an account, orginally postVG
function postAccount(){
console.log("in postVG");

//let vg=document.getElementById("vgForm").submit;
 var xhr= new XMLHttpRequest();
xhr.onreadystatechange= function() {
    console.log("in ORSC "+ xhr.readyState );
if(xhr.readyState==4 && xhr.status==200){
console.log(xhr.responseText);
}
}
xhr.open("POST","http://localhost:8080/JSONDemo/vg",true);
var payload=jsonBuilder();
xhr.send(payload);

}
//builds a json obj from the form fields
function jsonBuilder() {
var elements = document.getElementById("vgForm").elements;
var obj ={};
for(var i = 0 ; i < elements.length-1; i++){
    var item = elements.item(i);
    obj[item.name] = item.value;
    console.log(obj);   
}
var json= JSON.stringify(obj);
console.log(json);
return json;
}
window.onload= function() {
console.log("in onload");
document.getElementById("vgSubmitGet").addEventListener("click",getAccount,false);
//document.getElementById("vgFormSubmit").addEventListener("click", postAccount,false);
}
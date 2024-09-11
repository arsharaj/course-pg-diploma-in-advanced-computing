//import express library
const express=require("express");
//create express object
var app=express();
const bodyparser=require("body-parser");
//define middleware---middlewares are the functions which you want to execute
//for every request, It is common functionality for all urls
app.use(function(req,resp,next){
    console.log("this is first middleware");
    console.log("url: "+req.url);
    next();
})
app.use(function(req,resp,next){
    console.log("this is first middleware");
    console.log("url: "+req.url);
    next();
})

//router modules
app.get("/home",function(req,resp){
   
    resp.send("<h1>Home page</h1>")
})
app.get("/aboutus",function(req,resp){
   var str="<h1>Hello World!!</h1>";
   str+="<h2>Welcome to expressjs programming</h2>";
   resp.send(str);
})
app.listen(9090,function(){
    console.log("listening at port 9090")
})

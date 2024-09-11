//import express
const express=require("express");
const app=express();
const bodyparser=require("body-parser");
app.use(function(req,resp,next){
    console.log("this is middleware");
    next();
});

app.get("/hello",function(req,resp){
    resp.sendFile("/public/hello.html",{root:__dirname});
})

app.get("/aboutus",function(req,resp){
    resp.send("<h1>in about us</h1>"); 
})
app.listen(9090,function(){
    console.log("server is running at port 9090");
})
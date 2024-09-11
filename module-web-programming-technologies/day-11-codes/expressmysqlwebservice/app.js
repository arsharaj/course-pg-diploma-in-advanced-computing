//import all libraries
const express=require("express");
const app=express();
const bodyParser=require("body-parser");
const path=require("path");
var routes=require("./routes/router")
//configure the application
//Cors setting need to be added while connction from react application

//define middlewares
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json())

//define route handlers
app.use("/",routes);
//start the server
app.listen(9090,function(){
    console.log("server started at port 9090");
 })
module.exports=app;
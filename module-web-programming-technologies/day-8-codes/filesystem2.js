const fs=require("fs");
console.log("Before readfile async")
//asynchronous read
//every asunchronous function should have call function as last parameter
fs.readFile("test.txt",function(err,data){
    if(err){
        console.log("error occur",err)
    }else{
    console.log(data.toString())
    }
})
//asynchronous read
fs.readFile("test1.txt",function(err,data){
    if(err){
        console.log("error occured",err);
    }else{
        console.log("in 2nd async function "+data.toString());
    }
})
console.log("After readfile async");
var txt=fs.readFileSync("test1.txt");
console.log("from readsync",txt.toString());

console.log("after readsync");

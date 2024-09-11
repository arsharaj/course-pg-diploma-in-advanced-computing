const fs=require("fs");
var rs=fs.createReadStream("test.txt");
var str="";
rs.on("data",function(chunk){
   str+=chunk
});
rs.on("end",function(){
    console.log("reached to end of the file");
    console.log(str)
})
rs.on("error",function(err){
    console.log("error occured",err)
})
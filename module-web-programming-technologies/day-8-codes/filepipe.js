const fs=require("fs");
var rs=fs.createReadStream("test.txt");
var ws=fs.createWriteStream("targetdata1.txt");
rs.pipe(ws); 
console.log("reached to end")

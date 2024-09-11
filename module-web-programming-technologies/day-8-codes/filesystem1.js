const fs=require("fs");
//read data sunchronously
var data=fs.readFileSync("test.txt");
console.log(data.toString());
//write data to the file
fs.writeFileSync("test1.txt","The text in test1.txt")
//read data from the file synchronously
var s=fs.readFileSync("test1.txt");
console.log(s.toString());

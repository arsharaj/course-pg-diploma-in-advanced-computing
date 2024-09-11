var buf=Buffer.alloc(80);
for(var i=0;i<26;i++){
    buf[i]=i+97;
}
console.log(buf.toString());
console.log(buf.toString('ascii'));
//to display 1 st 5 characteres, convert it into utf8 encoding
//writing encoding format is optional
console.log(buf.toString('utf8',0,5));
console.log(buf.toString('utf8',5,8));
var buf1=new Buffer("node");
console.log(buf1.toString());

var portion=buf.slice(6,9);
console.log(portion.toString());

//write a code to allocate 100 locations for a buffer 
//and store all capital letters and display it
var data=Buffer.alloc(100);
for(var i=0;i<26;i++){
    data[i]=i+65;
}
console.log(data.toString());



const fs=require("fs");
var fname="test.txt";
fs.exists(fname,function(flag){
    if(flag){
        fs.stat(fname,function(err,status){
            if(err){
                console.log("error occured",err);
            }else{
                console.log("size",status.size);
                fs.open(fname,"r",function(err,fd){
                    if(err){
                        console.log(err);
                    }else{
                       var buff=Buffer.alloc(10);
                       fs.read(fd,buff,5,10,null,function(err,bytesread,buffer){
                           if(err){
                             console.log(err);
                           }
                           else{
                            console.log(buffer.toString());
                           }
                       }) 
                    }
                    fs.close(fd);
                })
            }
        })
    }
})
var blogs=[{name:'blog1',content:'blog1 content'},
   {name:'blog2',content:'blog2 content'},
   {name:'blog3',content:'blog3 content'}
]

var getblogs=()=>{
    setTimeout(()=>{
        console.log("getblogs called")
        var str="<ul>"
        for(var ob of blogs){
            str+=`<li>${ob.name}-----${ob.content}</li>`
        }
        str+="</ul>"
        document.getElementById("mydiv").innerHTML=str;
        
    },1000);
    
}
var createblogs=(newblog,f)=>{
     return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            console.log("createblogs called")
            blogs.push(newblog);
            error=false;
            console.log(blogs);
            if(!error){
                resolve();
            }else{
                 reject("error occured");
            }
            
            
        },2000);
     });
}
function displaytable(data){
    str="<table border='2'><tr><th>userId</th><th>id</th><th>title</th><th>body</th></tr>"
    for(var ob of data){
        str+=`<tr><td>${ob.userId}</td><td>${ob.id}</td><td>${ob.title}</td><td>${ob.body}</td></tr>`
    }
    str+="</table>"
    document.getElementById("mydiv1").innerHTML+="<br>"+str;
}
/*
var promise5=fetch("https://jsonplaceholder.typicode.com/posts")
.then((result)=>{
    console.log(result);
    if(result.status===200 && result.ok){
        console.log("successful completion of AJAX request")
        return result.json();
    }
    throw "promise rejected via then function";

},(err)=>{
   console.log("error occured",err);
   throw "promise rejected via error function";
}).catch(()=>{})

promise5.then((data)=>{console.log(data);
displaytable(data);
})
.catch((err)=>{
    console.log(err);
})

*/
async function fetchdata(){
 result=await fetch("https://jsonplaceholder.typicode.com/posts");
 if(result.status===200 && result.ok){
    data=await result.json();
    displaytable(data);
    //return data;
 }
 
}
async function greet(){
    return "hello";
}
var ans=greet();
console.log(ans);
ans.then((data)=>{
    console.log("print the hello",data);
})
console.log("before createblog")
createblogs({name:'blog4',content:'blog4 content' })
.then(getblogs)
.catch((error)=>{console.log(error);})
fetchdata().then(()=>{})
console.log("after createblog")
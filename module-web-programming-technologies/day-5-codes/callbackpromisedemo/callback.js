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
/*
var createblogs=(newblog)=>{
    setTimeout(()=>{
        console.log("createblogs called")
        blogs.push(newblog);
        console.log(blogs);
    },2000);
    
}

console.log("before createblog")
createblogs({name:'blog4',content:'blog4 content' })
getblogs();
console.log("after createblog")*/

var createblogs=(newblog,f)=>{
    setTimeout(()=>{
        console.log("createblogs called")
        blogs.push(newblog);
        console.log(blogs);
        f(f1);
    },2000);
    
}

console.log("before createblog")
createblogs({name:'blog4',content:'blog4 content' },getblogs)
console.log("after createblog")

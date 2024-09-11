arr=[{nm:"user1",passwd:"pass1"},{nm:"user2",passwd:"pass2"}]

exports.validateuser=(uname,pass)=>{
    var user=arr.find(ob=>ob.nm===uname && ob.passwd===pass);
    if(user===undefined){
        arr.push({nm:uname,passwd:pass});
        console.log(arr);
    }
    return user===undefined?null:user;
}

exports.addition=(x,y)=>{
    return x+y
}
exports.factorial=(n)=>{
    var f=1;
    for(var i=1;i<=n;i++){
        f=f*i;
    }
    return f;

}
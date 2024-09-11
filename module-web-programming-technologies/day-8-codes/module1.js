exports.addition=function(x,y){
    //x=x+10;
    //y=y+20;
    return x+y;
}

exports.factorial=function(n){
    var f=1;
    for(var i=1;i<=n;i++){
        f=f*i;
    }
    return f;
}
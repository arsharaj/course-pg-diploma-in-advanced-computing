class ProductService{
    constructor(){
        this.prodarr=[{pid:1,pname:'chair',qty:34,price:4444},
        {pid:2,pname:'Table',qty:50,price:6666},
        {pid:3,pname:'shelf',qty:30,price:2222}];
    }
    getAllProducts(){
        return this.prodarr;
    }
    insertProduct(product){
        console.log("in service add")
       this.prodarr.push(product);
       console.log(this.prodarr);
    }

    deleteproduct(pid){
        let pos=this.prodarr.findIndex(p=>p.pid==pid);
        this.prodarr.splice(pos,1);
    }
    getById(id){
        return this.prodarr.find(p=>p.pid==id);
    }
    updateproduct(prod){
        let pos=this.prodarr.findIndex(p=>p.pid==prod.pid);
        this.prodarr.splice(pos,1,{...prod});

    }

}

export default new ProductService();
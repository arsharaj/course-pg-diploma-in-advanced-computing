import {Product} from "../Product";
class ProductService{
    constructor(){
        this.prodarr=[new Product(11,'Chair',34,4444),
        new Product(12,'Shelf',70,2222),
        new Product(13,'Table',50,2000)]
    }
    getallproducts(){
        return this.prodarr;
    }
    insertProduct(p){
        this.prodarr.push(new Product(parseInt(p.pid),p.pname,parseInt(p.qty),parseInt(p.price)))

    }
   deleteProduct(pid){
        console.log("in delete product in product service");
       let pos=this.prodarr.findIndex(p=>p.pid===pid);
       this.prodarr.splice(pos,1);
       console.log(this.prodarr);
   }
   updateProduct(p){
    let pos=this.prodarr.findIndex(p1=>p1.pid===p.pid);
    this.prodarr.splice(pos,1,new Product(parseInt(p.pid),p.pname,parseInt(p.qty),parseInt(p.price)));
   }
}
export default new ProductService();
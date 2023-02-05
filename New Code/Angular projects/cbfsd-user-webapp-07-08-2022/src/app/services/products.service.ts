import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private productUrl:string  = "http://localhost:9090/products";

  public whishlistProducts:any[] =[];
  public cartProducts:any[] =[];
  public products:any[] =[];

  public productsSub: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  public productsRetreived: boolean = false;

  constructor(private httpClient: HttpClient) { }

  getProducts() {
    this.httpClient.get(this.productUrl+"/findProduct").subscribe(
      (res) => {
        console.log(res);
        this.productsSub.next(Object.assign([], res))
        this.productsRetreived = true
      }
    );
  }

  // add products to cart
  addProductToShoppingCart(prd:any, prdRemoveBool?: boolean, prdIdx=-1) {
    // add product into cart for multiple time.
      console.log(this.cartProducts)
    if(this.cartProducts.some(x=>x["productId"]===prd["productId"])) { 
      let idx = this.cartProducts.findIndex(x=> x["productId"]===prd["productId"]);
      this.cartProducts[idx]["quantity"] +=1;
      console.log(prd['title'], "Alreay Added to Cart, Quantity Updated");
    } else{
      this.cartProducts.push( {
        ...prd,
        "quantity": 1
      });
      console.log(prd['title'], "Product Added to Shoping Cart");
    }
  }

  // add product to whishlist
  addProductToWhishlist(prd:any, prdRemoveBool?:boolean, prdIdx:number=-1) {
    if(!this.whishlistProducts.some(x=>x["productId"]===prd["productId"])) {
      this.whishlistProducts.push({
        ...prd, "quantity":1
      });
      console.log(prd['title'], "Product Added to Whishlist");
    } else {
      console.log(prd['title'], "Already Added to Whishlist");
    }
    if(prdRemoveBool) {
      this.products.splice(prdIdx, 1);
    }
  }

  placeOrder(totalItems:number,totalPrice:number) {
    let order:Order = {};
    this.cartProducts.forEach(v=>{
        console.log(v)
    })   
    let obj = sessionStorage.getItem("user")
    if(obj!=null){
      let user = JSON.parse(obj);
      order = user;
    } 
    order.totalItems=totalItems;
    order.totalAmount=totalPrice;
    order.shipmentCharges=100;
    order.paymentStatusTitle="Pending";
    order.paymentMethodTitle="Cash on Delivery (COD)"
    order.orderitems=this.cartProducts;
    console.log(order);
    console.log(this.cartProducts);
    this.httpClient.post("http://localhost:9090/orders/placeOrder",order,{responseType:'text'}).subscribe({
      next:(result:any)=>console.log(result),
      error:(error:any)=>console.log(error),
      complete:()=>console.log("done")
    });

  }
}

class Order {
  constructor(
      public orderId?:number,
      public address?:string,
      public contact?:number,
      public email?:string,
      public itemsSubTotal?:number,
      public name?:string,
      public orderDate?:string,
      public orderStatus?:string,
      public paymentMethod?:number,
      public paymentMethodTitle?:string,
      public paymentStatus?:number,
      public paymentStatusTitle?:string,
      public shipmentCharges?:number,
      public totalItems?:number,
      public totalAmount?:number,
      public orderitems?:Array<OrderItem>
      ){

  }
}
class OrderItem {
  constructor(
    public orderItemId?:number,
    public productCategory?:string,
    public productCode?:string,
    public productDescription?:string,
    public productImg?:string,
    public productTitle?:string,
    public quantity?:number,
    public totalPrice?:number
  ){

  }
}
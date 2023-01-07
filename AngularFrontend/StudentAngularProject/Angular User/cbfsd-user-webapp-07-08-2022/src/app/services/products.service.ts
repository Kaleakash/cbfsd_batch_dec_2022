import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private productUrl:string  = 'https://fakestoreapi.com/products';

  public whishlistProducts:any[] =[];
  public cartProducts:any[] =[];
  public products:any[] =[];

  public productsSub: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  public productsRetreived: boolean = false;

  constructor(private httpClient: HttpClient) { }

  getProducts() {
    this.httpClient.get(this.productUrl).subscribe(
      (res) => {
        this.productsSub.next(Object.assign([], res))
        this.productsRetreived = true
      }
    );
  }

  // add products to cart
  addProductToShoppingCart(prd:any, prdRemoveBool?: boolean, prdIdx=-1) {
    // add product into cart for multiple time.
    if(this.cartProducts.some(x=>x["id"]===prd["id"])) { 
      let idx = this.cartProducts.findIndex(x=> x["id"]===prd["id"]);
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
    if(!this.whishlistProducts.some(x=>x["id"]===prd["id"])) {
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
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private HttpClient: HttpClient) { }

  getProducts() {
    //return this.HttpClient.get<any[]>('../../assets/json/products.json');
    return this.HttpClient.get<any[]>("http://localhost:9090/products/findAllProducts");
  }

  storeProduct(product:any):Observable<string> {
    return this.HttpClient.post("http://localhost:9090/products/storeProduct",product,{responseType:'text'});
  }
  deleteProduct(productId:any):Observable<string>{
    return this.HttpClient.delete("http://localhost:9090/products/deleteProductById/"+productId,{responseType:'text'});
  }
}

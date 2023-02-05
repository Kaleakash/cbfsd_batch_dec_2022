import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient: HttpClient) { }

  getProducts() {
    return this.httpClient.get<any[]>("http://localhost:9090/products/findProduct");
    //return this.httpClient.get<any[]>('../../assets/json/products.json');
  }

  storeProduct(product:any):Observable<string>{
    return this.httpClient.post("http://localhost:9090/products/storeProduct",product,{responseType:'text'});
  }

  deleteProduct(pid:any):Observable<string> {
    return this.httpClient.delete("http://localhost:9090/products/deleteProduct/"+pid,{responseType:'text'});
  }
}

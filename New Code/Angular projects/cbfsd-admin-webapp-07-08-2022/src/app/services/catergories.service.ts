import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../components/products/products.component';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private HttpClient: HttpClient) { }

  getCategories():Observable<Category[]> {
    //return this.HttpClient.get<any[]>('../../assets/json/categories.json');
    return this.HttpClient.get<Category[]>(' http://localhost:9090/categories/findAllCategories');
  }

  storeCategories(category:any) : Observable<string>{
    return this.HttpClient.post(' http://localhost:9090/categories/storeCategory',category,{responseType:'text'});
  }
  
  deleteCategory(cid:any):Observable<any> {
    return this.HttpClient.delete(' http://localhost:9090/categories/deleteCategory/'+cid,{responseType:'text'});
  }
}

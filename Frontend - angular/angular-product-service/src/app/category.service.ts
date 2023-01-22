import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(public http:HttpClient) { }

  storeCategory(category:any):Observable<string> {
    return this.http.post("http://localhost:9191/category/storeCategory",category,{responseType:'text'});
  }
}

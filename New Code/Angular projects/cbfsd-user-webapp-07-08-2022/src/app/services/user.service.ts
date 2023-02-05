import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public http:HttpClient) { }

  createUserAccount(user:any):Observable<string> {
    return this.http.post("http://localhost:9090/user/storeData",user,{responseType:'text'});  
  }

  signIn(user:any):Observable<any> {
    return this.http.post("http://localhost:9090/user/signIn",user)
  }

  
}

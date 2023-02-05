import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
 private obj = new BehaviorSubject<boolean>(false);
 private loggedIn = this.obj.asObservable();

  constructor(public http:HttpClient) { }

  get isLoggedIn(){
    return this.loggedIn;
  }
  loginIn() {
    this.obj.next(true);
  }
  loginOut() {
    this.obj.next(false);
  }
  signIn(admin:any):Observable<string> {
    return this.http.post("http://localhost:9090/admins/signIn",admin,{responseType:"text"});
  }
}

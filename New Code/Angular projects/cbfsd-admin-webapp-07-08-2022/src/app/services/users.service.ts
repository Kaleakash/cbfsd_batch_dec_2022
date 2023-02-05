import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private HttpClient: HttpClient) { }

  getUsers() {
    //return this.HttpClient.get<any[]>('../../assets/json/users.json');
    return this.HttpClient.get<any[]>('http://localhost:9090/user/allUsers');
  }

  

}

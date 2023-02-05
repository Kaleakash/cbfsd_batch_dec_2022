import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor(public router:Router){}
  canActivate() {
    let obj = sessionStorage.getItem("admin");
    if(obj==null){
      this.router.navigate(["auth"])
      return false;
    }else {
      return true;
    }

  }
  
}

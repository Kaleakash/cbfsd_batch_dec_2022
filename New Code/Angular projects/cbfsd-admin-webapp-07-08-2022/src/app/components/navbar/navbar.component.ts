import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loggedIn:boolean = false;
  constructor(public adminService:AdminService,public router:Router) { }

  ngOnInit(): void {
    this.adminService.isLoggedIn.subscribe(result=>this.loggedIn=result);
  }

  logout(){
    this.router.navigate(["home"]);
    this.adminService.loginOut();
  }
}

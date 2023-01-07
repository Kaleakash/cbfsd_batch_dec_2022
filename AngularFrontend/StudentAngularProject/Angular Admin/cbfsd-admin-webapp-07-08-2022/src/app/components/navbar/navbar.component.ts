import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loggedIn?:boolean;
  constructor(public adminService:AdminService,public router:Router) { }

  ngOnInit(): void {
      this.adminService.isLogged.subscribe({
        next:(result:any)=>this.loggedIn=result,
        error:(error:any)=>console.log(error),
        complete:()=>console.log("completed")
      })
  }

  logout(){
    this.adminService.logOut();
    this.router.navigate(["auth"]);
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  adminRef = new FormGroup({
    email:new FormControl(),
    password:new FormControl()
  }) ;
  constructor(public adminService:AdminService,public router:Router) { }

  ngOnInit(): void {
  }

  signIn(){
    let admin = this.adminRef.value;
    this.adminService.signIn(admin).subscribe({
      next:(result:any)=>{
        console.log(result)
        if(result=="Successfully login"){
            sessionStorage.setItem("admin","admin");
            this.adminService.loginIn();
            this.router.navigate(["home"]);
        } else {

        }
      },
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
}

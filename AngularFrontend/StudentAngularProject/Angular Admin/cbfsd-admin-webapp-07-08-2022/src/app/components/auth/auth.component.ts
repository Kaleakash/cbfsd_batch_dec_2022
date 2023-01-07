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
  });
  constructor(public adminService:AdminService,public router:Router) { }

  ngOnInit(): void {
  }

  signIn(){
    let admin = this.adminRef.value;
    //console.log(admin);
    this.adminService.signIn(admin).subscribe({
      next:(data:any)=>{
        if(data=="success"){
            this.adminService.logIn();
            alert("successfulluy login")
            this.router.navigate(["home"]);
        }else {
            alert("failure try once again")
        }
      },
        error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    });
    console.log("Hi")
    this.adminRef.reset();    //reset the form value. 
  }
}

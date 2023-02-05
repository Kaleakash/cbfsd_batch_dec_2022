import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userRef = new FormGroup({
    user:new FormControl(),
    email:new FormControl(),
    password:new FormControl(),
    fullName:new FormControl(),
    street:new FormControl(),
    city:new FormControl(),
    state:new FormControl(),
    country:new FormControl(),
    pincode:new FormControl(),
    contact:new FormControl(),

  })
  constructor(private router: Router,public us:UserService) { } // DI for UserService 

  ngOnInit(): void {
  }

  goTo(url:any) {
    this.router.navigateByUrl(url);
  }

  createAccount(){
    let user = this.userRef.value;
    this.us.createUserAccount(user).subscribe({
      next:(result:any)=>console.log(result),
      error:(error:any)=>console.log(error),
      complete:()=>console.log("done!")
    });

    console.log(user);
    this.userRef.reset();
  }
}

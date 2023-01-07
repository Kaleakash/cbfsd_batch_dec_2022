import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userRef = new FormGroup({
    email:new FormControl(),
    password:new FormControl()
  });

  constructor(private router:Router,public us:UserService) { }

  ngOnInit(): void {
  }

  goTo(url:any) {
    this.router.navigateByUrl(url);
  }

  signIn(){
    let user = this.userRef.value;
    //console.log(user);
    this.us.signIn(user).subscribe({
      next:(result:any)=> {
         // console.log(result);
         if(result=="success"){
              this.router.navigate(["home"]);
         }else {
          alert("failure try once again")
         }
      },
      error:(error:any)=>console.log(error),
      complete:()=>console.log("done!")
    })

    this.userRef.reset();
  }
}

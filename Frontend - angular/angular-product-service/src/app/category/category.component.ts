import { Component } from '@angular/core';
import { CategoryService } from '../category.service';
import {FormGroup,FormControl} from '@angular/forms';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {


  categoryRef = new FormGroup({
    cid:new FormControl(),
    cname:new FormControl()
  });


  constructor(public cs:CategoryService){

  }


  storeCategory() {
    let category = this.categoryRef.value;
    //console.log(category);
    this.cs.storeCategory(category).subscribe({
      next:(result:any)=>console.log(result),
      error:(error:any)=>console.log(error),
      complete:()=>console.log("done")
    })

    this.categoryRef.reset();
  }
}

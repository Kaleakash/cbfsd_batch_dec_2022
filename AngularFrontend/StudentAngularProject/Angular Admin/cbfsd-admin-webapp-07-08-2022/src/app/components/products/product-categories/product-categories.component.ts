import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/services/catergories.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-categories',
  templateUrl: './product-categories.component.html',
  styleUrls: ['./product-categories.component.css']
})
export class ProductCategoriesComponent implements OnInit {

  // catergory observable
  public categoryObservable: Observable<any[]> = new Observable();
  
  prodCategoryBool: boolean = true;
  productCategoryForm:FormGroup = new FormGroup({});
  loader : boolean = false;
  tempFile: any;


  constructor(private categoriesService:CategoriesService,  private modalService: NgbModal,  private fb:FormBuilder) { }

  ngOnInit(): void {
    this.categoryObservable = this.categoriesService.getCategories();   
  }

  openProductCategoryDialog(modelRef:any, productCategoryObj = null) {
    // console.log(productCategoryObj);    
    this.initialForm(productCategoryObj);
    this.modalService.open(modelRef);
  }
  // View Categories Details 
  openImageModal(modal: any, imageUrls: string):void {
    this.tempFile = imageUrls;
    //this.thumbnailImageIdx = thumbnailImageIdx;
    this.modalService.open(modal, { 
      size: "xl",
      scrollable: true 
    });
  }
  initialForm(productCategoryObj: any = null) {
    if (productCategoryObj === null) {
      this.productCategoryForm = this.fb.group({
        categoryName: ["", Validators.required],
        categoryDescription: ["", Validators.required],
        categoryImageUrl: ["", Validators.required],
        categoryId: [null],
        active: [true],
        addedOn: [],
      });
    } else {
      this.productCategoryForm = this.fb.group({
        categoryName: [productCategoryObj.categoryName, Validators.required],
        categoryDescription: [productCategoryObj.categoryDescription, Validators.required],
        categoryImageUrl: [productCategoryObj.categoryImageUrl, Validators.required],
        categoryId: [productCategoryObj.categoryId],
        active: [productCategoryObj.active],
      });
    }
  }


  checkFileType(event: any) {
    this.tempFile = event.target.files[0];
    if (
      this.tempFile.type == "image/png" ||
      this.tempFile.type == "image/jpeg" ||
      this.tempFile.type == "image/jpg"
    ) {
      let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload=(event)=> {
          let path = (<FileReader>event.target).result;
          this.tempFile=path;
        }
        
    } else {
      // console.log("File not Ok");
      this.tempFile = null;
      // this.toast.show("Only .png/.jpeg/.jpg file format accepted!!");
    }
  }

  saveCategory() {
    let categoryRef = this.productCategoryForm.value;
    categoryRef.categoryImageUrl=this.tempFile;
    //console.log(categoryRef);
    this.categoriesService.storeCategoriesDetails(categoryRef).subscribe({
      next:(result:any)=> {
        console.log(result)
      },
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    });
    this.productCategoryForm.reset();
    categoryRef.categoryImageUrl="";
  }

}

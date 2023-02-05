import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/services/catergories.service';
import { ProductsService } from 'src/app/services/products.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public prodObservable: Observable<any[]> = new Observable();
  public categoryObservable: Observable<any[]> = new Observable();

  productForm: FormGroup = new FormGroup({});
  productModel: Products | undefined;
  selectedImageIdx: number = 0;
  thumbnailImageIdx: number = 0;
  tempImageFiles: any[] = [];
  tempImageFilesPath:any[]=[];
  updation: boolean = false;
  loader: boolean = false;

  constructor(private productService: ProductsService, private categoriesService:CategoriesService, 
    private modalService: NgbModal, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.prodObservable = this.productService.getProducts();
    this.categoryObservable = this.categoriesService.getCategories();    
  }


  openModal(modal: any, prd: Products | null = null) {
    this.tempImageFiles = []; 
    this.initialiseModal(prd);
    this.modalService.open(modal, { size: "xl" });
  }


  initialiseModal(productObj: Products | null) {
    if (productObj == null) {
      this.updation = false;
      this.productForm = this.fb.group({
        productId: [],
        productTitle: [null],
        price: [null],
        productCode:[null],
        images: this.fb.array([]),
        thumbnailImage: [null],
        productDescription: [null],
        category: [null],
        active: [true],
        addedOn: [],
        rating: [0]
      });
    } else {
      this.updation = true;
      this.productForm = this.fb.group({
        productId: [productObj.productId],
        productTitle: [productObj.productTitle],
        price: [productObj.price],
        productCode:[productObj.productCode],
        images: [productObj.images],
        thumbnailImage: [productObj.thumbnailImage],
        productDescription: [productObj.productDescription],
        category: [productObj.category],
        active: [productObj.active],
        addedOn: [productObj.addedOn],
        rating: [productObj.rating]
      });
      this.onSelectOption(productObj.category);
      this.tempImageFiles = productObj.images || [];
    }
  }

  compareByCategoryId(category1: Category, category2: Category) {
    return category1 && category2 && category1.categoryId === category2.categoryId;
  }

  onSelectOption(category: Category | Event | undefined) {
    // this.productForm.patchValue({
    //   category: this.categories.find(x => x.categoryId === category.categoryId)
    // })
  }


  saveProduct(){
    let productRef = this.productForm.value;
    console.log(productRef)
    this.tempImageFilesPath.forEach((v,index)=> {
      productRef.images[index]=v;
    })
    console.log(productRef);
    console.log(productRef.thumbnailImage)
    this.productService.storeProduct(productRef).subscribe({
      next:(result:any)=>{
        if(result=="Product Details stored successfully"){
            alert("Product details stored successfully")
        }else {
            alert("Product details didn't store")
        }
      },
      error:(error:any)=>console.log(error),
      complete:()=>{
    
      }
    })
    this.tempImageFilesPath.splice(0,this.tempImageFiles.length);
    //productRef.images.splice(0,productRef.image.length);
    this.tempImageFiles.splice(0,this.tempImageFiles.length);
    this.productForm.reset();
  }

  deleteProduct(pid:any){
    this.productService.deleteProduct(pid).subscribe({
      next:(result:any)=>{
        if(result=="Product deails deleted successfully"){
            alert("Product details deleted successfully")
        }else {
            alert("product detaild didn't delete")
        }
      },
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }

  // view image model 
  openImageModal(modal: any, imageUrls: string[], thumbnailImageIdx: number) {
    this.tempImageFiles = [...imageUrls];
    this.thumbnailImageIdx = thumbnailImageIdx;
    this.modalService.open(modal, { 
      size: "xl",
      scrollable: true 
    });
  }

  // open image
  openImage(url: string) {
    window.open(url, "_blank")
  }

  // view product details
  viewProductDetails(modal: any, productObj: Products) {
    this.productModel = productObj;
    this.modalService.open(modal, { size: 'lg' });
  }


  checkImageFileType(event: any) {
    let fileList: File[] = Object.assign([], event.target.files);
    fileList.forEach((file: any, idx: number) => {
     

      if (
        file.type == "image/png" ||
        file.type == "image/jpeg" ||
        file.type == "image/jpg"
      ) {
        
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload=(event)=> {
          let path = (<FileReader>event.target).result;
          //console.log(path);
          this.tempImageFilesPath.push(path);
        }
        this.tempImageFiles.push(file);

       
      } else {
        // this.toast.warning("Only .png/.jpeg/.jpg file format accepted!!", file.name + " will not accepted.");
      }
    });
  }
  fileToBlob(fileName:any){
    let reader = new FileReader();
    reader.readAsDataURL(fileName);
    reader.onload =  (event) => {
    return (<FileReader>event.target).result;
    }
    
  }

  blobToFile(theBlob:any, fileName:any){       
    return new File([theBlob], fileName, { lastModified: new Date().getTime()})
  }

  removeImage(idx: number) {
    this.tempImageFiles.splice(idx, 1);
  }
  
  changeThumbnailImageIdx(idx: number) {
    this.productForm.patchValue({
      thumbnailImage: idx
    })
  }


}


export interface Products {
  productId?: string;
  productTitle?: string;
  productCode?: string;
  productDescription?: string;
  price?: number;
  category?: Category;
  images?: string[];
  thumbnailImage?: string;
  active?: boolean;
  addedOn?: Date;
  rating?: number;
}

export interface Category {
  categoryId?: string;
  categoryName?: string;
  categoryDescription?: string;
  categoryImageUrl?: string;
  createdOn?: Date;
  active?: boolean;
}
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckoutComponent } from './checkout/checkout.component';
import { CartComponent } from './cart/cart.component';
import { WhishlistComponent } from './whishlist/whishlist.component';
import { ViewComponent } from './view/view.component';
import { ProductsComponent } from './products.component';



@NgModule({
  declarations: [
    ProductsComponent,
    ViewComponent,
    WhishlistComponent,
    CartComponent,
    CheckoutComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProductsModule { }

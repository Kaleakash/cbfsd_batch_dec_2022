import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChangePasswordComponent } from './components/auth/change-password/change-password.component';
import { LoginComponent } from './components/auth/login/login.component';
import { ProfileComponent } from './components/auth/profile/profile.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { CartComponent } from './components/products/cart/cart.component';
import { CheckoutComponent } from './components/products/checkout/checkout.component';
import { ProductsComponent } from './components/products/products.component';
import { ViewComponent } from './components/products/view/view.component';
import { WhishlistComponent } from './components/products/whishlist/whishlist.component';

const routes: Routes = [
  {path:'', redirectTo:'/home', pathMatch:"full"},
  {path:'home' , component:HomeComponent},
  {path:'login' , component:LoginComponent},
  {path:'register' , component:RegisterComponent},
  {path:'change-password' , component:ChangePasswordComponent},
  {path:'user-profile' , component:ProfileComponent},
  {path:'products' , children: [
    { path :'', component: ProductsComponent },
    { path :'shopping-cart', component: CartComponent },
    { path :'checkout', component: CheckoutComponent },
    { path :'view', component: ViewComponent },
    { path :'whishlist', component: WhishlistComponent },
  ]},
  {path:'**' , component:NotfoundComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

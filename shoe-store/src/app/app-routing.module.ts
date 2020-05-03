import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { ProductDetailComponent } from './product-detail/product-detail.component'
import { ProductComponent } from './product/product.component'
import { RegisterComponent } from './components/register/register.component'


const routes: Routes = [                                  
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'dashboard/detail/:id', component: ProductDetailComponent },
  { path: 'products', component: ProductComponent },
  { path: 'register', component: RegisterComponent },

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { ProductListComponent } from '../components/product-list/product-list.component'
import { ProductDetailComponent } from '../components/product-detail/product-detail.component'
import { ShoppingCartComponent } from '../components/shopping-cart/shopping-cart.component';
import { OrderReviewComponent } from '../components/order-review/order-review.component'
import { CustomerInfoComponent }  from '../components/customer-information/customer-info.component'
import { PaymentInfoComponent }  from '../components/payment-info/payment-info.component';
const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: '',
      redirectTo: 'products',
      pathMatch: 'full',
    },
    {
      path: 'payments',
      component: PaymentInfoComponent
    },

    {
      path: 'products',
      component: ProductListComponent,
    },
    {
      path: 'checkout',
      component: OrderReviewComponent
    },
    {
      path: 'customer/information',
      component: CustomerInfoComponent
    },
    {
      path: 'cart',
      component: ShoppingCartComponent,
    },
    { path: 'products/detail/:id', component: ProductDetailComponent },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { ProductListComponent } from '../components/product-list/product-list.component'
import { ProductDetailComponent } from '../components/product-detail/product-detail.component'

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
      path: 'products',
      component: ProductListComponent,
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

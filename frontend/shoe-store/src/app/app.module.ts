/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NbSecurityModule } from '@nebular/security';
import { ThemeModule } from './@theme/theme.module';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductDetailComponent } from './components/product-detail/product-detail.component'
import { ProductListComponent } from './components/product-list/product-list.component'
import { NbAuthService } from '@nebular/auth';
import { NbAuthModule} from './auth/auth.module'
import { CoreModule } from './@core/core.module';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component'
import { AddToCartComponent } from './components/add-to-cart/add-to-cart.component'

import {
  NbChatModule,
  NbDatepickerModule,
  NbDialogModule,
  NbMenuModule,
  NbSidebarModule,
  NbToastrModule,
  NbWindowModule,
} from '@nebular/theme';

@NgModule({
  declarations: [AppComponent,
    ProductListComponent,
    ProductDetailComponent,
    ShoppingCartComponent,
    AddToCartComponent,
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NbSecurityModule.forRoot(),
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    NbSidebarModule.forRoot(),
    NbMenuModule.forRoot(),
    NbDatepickerModule.forRoot(),
    NbDialogModule.forRoot(),
    NbWindowModule.forRoot(),
    NbToastrModule.forRoot(),

    NbChatModule.forRoot({
      messageGoogleMapKey: 'AIzaSyA_wNuCzia92MAmdLRzmqitRGvCF7wCZPY',
    }),
    CoreModule.forRoot(),
    ThemeModule.forRoot(),

  ],
  bootstrap: [AppComponent],
  providers:[NbAuthService]
})
export class AppModule {
}

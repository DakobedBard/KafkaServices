import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';

import {
  NbButtonModule,
  NbCardModule,
  NbLayoutModule,
  NbSidebarService,
  NbSidebarModule
} from '@nebular/theme';

import { NbAuthModule, NbDummyAuthStrategy } from '@nebular/auth';

import { AppRoutingModule } from './app-routing.module';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    NbLayoutModule,
    NbCardModule,
    NbButtonModule,
    AppRoutingModule,
    NbSidebarModule,
    NbAuthModule.forRoot({
      strategies: [
        NbDummyAuthStrategy.setup({
          name: 'email',

          alwaysFail: true,
          delay: 1000,
        }),
      ],
    }),
    BrowserModule,
    AppRoutingModule
  ],

  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }

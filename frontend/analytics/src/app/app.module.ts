import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NbSidebarModule, NbLayoutModule, NbButtonModule,NbSidebarService } from '@nebular/theme';

import { NbThemeModule } from '@nebular/theme';
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule, // RouterModule.forRoot(routes, { useHash: true }), if this is your app.module
    NbLayoutModule,
    NbSidebarModule, // NbSidebarModule.forRoot(), //if this is your app.module
    NbButtonModule,
    NbThemeModule.forRoot(),
  ],
  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './components/authentication/login/login.component'
import { RegisterComponent }  from './components/authentication/register/register.component'
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component'

import {
  NbAuthComponent,
  NbLoginComponent,
  NbLogoutComponent,
  NbRegisterComponent,
  NbRequestPasswordComponent,
  NbResetPasswordComponent,
} from '@nebular/auth';
import { NbAuthModule, NbAuthJWTToken,NbPasswordAuthStrategy } from '@nebular/auth';
export const routes: Routes = [
  {
    path: 'pages',
    loadChildren: () => import('./pages/pages.module')
      .then(m => m.PagesModule),
  },
  { path: 'pages/shopping-cart', component: ShoppingCartComponent},
  {
    path: 'auth',
    component: NbAuthComponent,
    children: [
      {
        path: '',
        component: NbLoginComponent,
      },
      {
        path: 'login',
        component: NbLoginComponent,
      },
      {
        path: 'register',
        component: NbRegisterComponent,
      },
      {
        path: 'logout',
        component: NbLogoutComponent,
      },
      {
        path: 'request-password',
        component: NbRequestPasswordComponent,
      },
      {
        path: 'reset-password',
        component: NbResetPasswordComponent,
      },
    ],
  },
  { path: '**', redirectTo: 'pages' },
];

const config: ExtraOptions = {
  useHash: false,
};

@NgModule({
  imports: [
    RouterModule.forRoot(routes, config),
    NbAuthModule.forRoot({
      strategies: [
        NbPasswordAuthStrategy.setup({
          name: 'email',
          baseEndpoint: 'http://localhost:8080',
          token: {
            class: NbAuthJWTToken,

            key: 'token', // this parameter tells where to look for the token
          },
           login: {
             // ...
             endpoint: '/auth/login',
           },
           register: {
             // ...
             endpoint: '/api/auth/register',
           },
        }),
      ],
      forms: {},
    }), ],
  exports: [RouterModule],
})
export class AppRoutingModule {
}

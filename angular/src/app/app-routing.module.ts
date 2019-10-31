import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component'
import {ErrorComponent} from './error/error.component'

const routes: Routes = [
  {
      path: '',
      redirectTo: '/login', 
      pathMatch: 'full'
  } ,
  {
      path: 'login',
      component: LoginComponent
  } ,
  {   path: 'register',
      component: RegisterComponent
  },
  {
    path: '**', component: ErrorComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

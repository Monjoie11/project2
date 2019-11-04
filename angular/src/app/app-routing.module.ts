import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {RegisterCompanyComponent} from './register-company/register-company.component';
import {ErrorComponent} from './error/error.component';
import {CompanyHomepageComponent} from './company-homepage/company-homepage.component';
import {UserHomepageComponent} from './user-homepage/user-homepage.component';
import { MarketboardComponent } from './marketboard/marketboard.component';
import { CalendarComponent } from './calendar/calendar.component';

const routes: Routes = [
  {
      path: 'localhost:8080/angular/Proj2/angular/',
      redirectTo: '/login', 
      pathMatch: 'full'
  } ,
  {
      path: 'localhost:8080/login',
      component: LoginComponent
  } ,
  {   path: 'register',
      component: RegisterComponent
  },

  {   path: 'register-company',
    component: RegisterCompanyComponent
  },

  {   path: 'company-homepage',
    component: CompanyHomepageComponent
  },

  {   path: 'user-homepage',
    component: UserHomepageComponent
  },
  {   path: 'marketboard',
    component: MarketboardComponent
  },

  {   path: 'calendar',
    component: CalendarComponent
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

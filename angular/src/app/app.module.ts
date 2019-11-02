import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatFormFieldModule,
  MatInputModule,
  MatCardModule,
  MatButtonModule
  } from '@angular/material';
  import {MatToolbarModule} from '@angular/material/toolbar';
import { RegisterComponent } from './register/register.component';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { RegisterCompanyComponent } from './register-company/register-company.component';
import { CompanyHomepageComponent } from './company-homepage/company-homepage.component';
import {MatTableModule} from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfilePictureComponent } from './profile-picture/profile-picture.component';
import { TabbedTableComponent } from './tabbed-table/tabbed-table.component';
import { BioComponent } from './bio/bio.component';
/* import {StarRatingModule} from 'angular-star-rating'; */

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ErrorComponent,
    RegisterCompanyComponent,
    CompanyHomepageComponent,
    NavbarComponent,
    ProfilePictureComponent,
    TabbedTableComponent,
    BioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSelectModule,
    FormsModule,
    MatTableModule,
    MatTabsModule,
/*     StarRatingModule */
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

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
import { RegisterComponent } from './user-register/register.component';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { ErrorComponent } from './error/error.component';
import { RegisterCompanyComponent } from './company-register/register-company.component';
import { CompanyHomepageComponent } from './company-homepage/company-homepage.component';
import {MatTableModule} from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfilePictureComponent } from './homepage-header/profile-picture.component';
import { TabbedTableComponent } from './user-tabbed-table/tabbed-table.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { JobDropdownComponent } from './user-job-dropdown/job-dropdown.component';
import { TabbedTableComponent2 } from './company-tabbed-table/tabbed-table.component';
import { BioComponent } from './bio/bio.component';
import { RatingModule } from 'ng-starrating';
import { StarRatingComponent } from './company-star-rating/star-rating.component';
import { MarketboardComponent } from './marketboard/marketboard.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CalendarComponent } from './company-calendar/calendar.component';
import { HttpClientModule } from '@angular/common/http';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';

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
    UserHomepageComponent,
    JobDropdownComponent,
    TabbedTableComponent2,
    BioComponent,
    StarRatingComponent,
    MarketboardComponent,
    CalendarComponent,
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
    RatingModule,
    FullCalendarModule,
    HttpClientModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

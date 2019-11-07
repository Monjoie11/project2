import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RegisterCompanyComponent } from '../company-register/register-company.component';
import { FormsModule } from '@angular/forms';
import { CompanyRegisterServiceService } from '../company-register-service.service'
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule , MatFormFieldModule, MatInputModule} from '@angular/material';
import {RouterTestingModule} from "@angular/router/testing";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';

describe('RegisterComponent ', () => {
  let component: RegisterCompanyComponent;
  let fixture: ComponentFixture<RegisterCompanyComponent>;
  let service: CompanyRegisterServiceService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        HttpClientTestingModule,
        RouterTestingModule,
        MatToolbarModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        BrowserAnimationsModule,
        MatSelectModule
      ],
      declarations: [
        RegisterCompanyComponent
      ],
      providers: [
        CompanyRegisterServiceService
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    service = TestBed.get(CompanyRegisterServiceService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  })

  it('should return false since registration failed', () => {
    spyOn(service, 'registerCompany').and.returnValue(false);
    expect(component.register).toBeFalsy;
  })

  it('should return true since registration succeeded', () => {
    spyOn(service, 'registerCompany').and.returnValue(true);
    expect(component.register).toBeTruthy;
  })

  it('should return false since method returned un recognized value', () => {
    spyOn(service, 'registerCompany').and.returnValue('false');
    expect(component.register).toBeFalsy;
  })

})
/* import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCompanyComponent } from './register-company.component';

describe('RegisterCompanyComponent', () => {
  let component: RegisterCompanyComponent;
  let fixture: ComponentFixture<RegisterCompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterCompanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(1).toEqual(1);
  });
}); */

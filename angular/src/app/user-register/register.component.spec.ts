import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RegisterComponent } from '../user-register/register.component';
import { FormsModule } from '@angular/forms';
import { UserRegisterServiceService } from '../user-register-service.service'
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule , MatFormFieldModule, MatInputModule} from '@angular/material';
import {RouterTestingModule} from "@angular/router/testing";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';

describe('RegisterComponent ', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let service: UserRegisterServiceService;

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
        RegisterComponent
      ],
      providers: [
        UserRegisterServiceService
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    service = TestBed.get(UserRegisterServiceService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  })

  it('should return false since registration failed', () => {
    spyOn(service, 'registerUser').and.returnValue(false);
    expect(component.register).toBeFalsy;
  })

  it('should return true since registration succeeded', () => {
    spyOn(service, 'registerUser').and.returnValue(true);
    expect(component.register).toBeTruthy;
  })

  it('should return false since method returned un recognized value', () => {
    spyOn(service, 'registerUser').and.returnValue('false');
    expect(component.register).toBeFalsy;
  })

})


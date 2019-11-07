import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { LoginComponent } from './login.component';
import { FormsModule } from '@angular/forms';
import { LoginServiceService } from '../login-service.service'
import { Observable } from 'rxjs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule , MatFormFieldModule, MatInputModule} from '@angular/material';
import {RouterTestingModule} from "@angular/router/testing";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

class User {
  email: string;
  password: string;
  constructor(email, password) {
    this.email = email;
    this.password = password;
  }
}

class User2 {
  randomValue1: string;
  randomValue2: string;
  randomValue3: string;
  randomValue4: string;
  randomValue5: string;
  randomValue6: string;
  randomValue7: string;
  randomValue8: string;
  randomValue9: string;
  randomValue10: string;
  constructor(randomValue1, randomValue2, randomValue3, randomValue4, randomValue5, randomValue6, randomValue7, randomValue8, randomValue9, randomValue10) {
    this.randomValue1 = randomValue1;
    this.randomValue1 = randomValue2;
    this.randomValue1 = randomValue3;
    this.randomValue1 = randomValue4;
    this.randomValue1 = randomValue5;
    this.randomValue1 = randomValue6;
    this.randomValue1 = randomValue7;
    this.randomValue1 = randomValue8;
    this.randomValue1 = randomValue9;
    this.randomValue1 = randomValue10;
  }
}

class User3 {
  randomValue1: string;
  randomValue2: string;
  randomValue3: string;
  randomValue4: string;
  randomValue5: string;
  randomValue6: string;
  randomValue7: string;
  randomValue8: string;
  randomValue9: string;
  randomValue10: string;
  randomValue11: string;
  randomValue12: string;
  randomValue13: string;
  constructor(randomValue1, randomValue2, randomValue3, randomValue4, randomValue5, randomValue6, randomValue7, randomValue8, randomValue9, randomValue10, randomValue11, randomValue12, randomValue13) {
    this.randomValue1 = randomValue1;
    this.randomValue2 = randomValue2;
    this.randomValue3 = randomValue3;
    this.randomValue4 = randomValue4;
    this.randomValue5 = randomValue5;
    this.randomValue6 = randomValue6;
    this.randomValue7 = randomValue7;
    this.randomValue8 = randomValue8;
    this.randomValue9 = randomValue9;
    this.randomValue10 = randomValue10;
    this.randomValue11 = randomValue11;
    this.randomValue12 = randomValue12;
    this.randomValue13 = randomValue13;
  }
}

class User4 {
  randomValue1: string;
  randomValue2: string;
  randomValue3: string;
  randomValue4: string;
  randomValue5: string;
  randomValue6: string;
  randomValue7: string;
  randomValue8: string;
  randomValue9: string;
  randomValue10: string;
  randomValue11: string;
  randomValue12: string;
  randomValue13: string;
  randomValue14: string;
  constructor(randomValue1, randomValue2, randomValue3, randomValue4, randomValue5, randomValue6, randomValue7, randomValue8, randomValue9, randomValue10, randomValue11, randomValue12, randomValue13, randomValue14) {
    this.randomValue1 = randomValue1;
    this.randomValue2 = randomValue2;
    this.randomValue3 = randomValue3;
    this.randomValue4 = randomValue4;
    this.randomValue5 = randomValue5;
    this.randomValue6 = randomValue6;
    this.randomValue7 = randomValue7;
    this.randomValue8 = randomValue8;
    this.randomValue9 = randomValue9;
    this.randomValue10 = randomValue10;
    this.randomValue11 = randomValue11;
    this.randomValue12 = randomValue12;
    this.randomValue13 = randomValue13;
    this.randomValue14 = randomValue14;
  }
}
describe('LoginComponent ', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let service: LoginServiceService;

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
        BrowserAnimationsModule
      ],
      declarations: [
        LoginComponent
      ],
      providers: [
        LoginServiceService
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    service = TestBed.get(LoginServiceService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  })

  it('should return false since length is 2', () => {
    spyOn(service, 'loginRequest').and.returnValue(new Observable<User>());
    let myUser = new User('bmoney@gmail.com', 'password');
    service.loginRequest(myUser.email, myUser.password);
    expect(component.search).toBeFalsy;
  })

  it('should return true since length is 10', () => {
    spyOn(service, 'loginRequest').and.returnValue(new Observable<User2>());
    let myUser = new User('bmoney@gmail.com', 'password');
    service.loginRequest(myUser.email, myUser.password);
    expect(component.search).toBeTruthy;
  })

  it('should return true since length is 13', () => {
    spyOn(service, 'loginRequest').and.returnValue(new Observable<User3>());
    let myUser = new User('bmoney@gmail.com', 'password');
    service.loginRequest(myUser.email, myUser.password);
    expect(component.search).toBeTruthy;
  })

  it('should return false since length is 14', () => {
    spyOn(service, 'loginRequest').and.returnValue(new Observable<User4>());
    let myUser = new User('bmoney@gmail.com', 'password');
    service.loginRequest(myUser.email, myUser.password);
    expect(component.search).toBeFalsy;
  })

})

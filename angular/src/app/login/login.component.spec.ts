import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from './login.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from  '@angular/common/http/testing';

export class MockHttp {
  get(url: string) {
    return { subscribe: () => { } };
  }
}

describe('LoginComponent', () => {

  let mockHttp: MockHttp;

  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async() => {
    mockHttp = new MockHttp();
    spyOn(mockHttp, 'get').and.returnValue({ subscribe: () => {}});
    TestBed.configureTestingModule({
      imports:[FormsModule,
        RouterTestingModule.withRoutes([])
      ],
      declarations: [LoginComponent],
      schemas:[ CUSTOM_ELEMENTS_SCHEMA ],
      providers: [
        { provide: HttpClient, useValue: mockHttp },
        { provide: 'login', useValue: '' }
      ]
    });
    fixture = TestBed.createComponent(LoginComponent);
    fixture.detectChanges();
  });

    it('should call http.get', () => {
      expect(mockHttp.get).toHaveBeenCalled();
    })
})

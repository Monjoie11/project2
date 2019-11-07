import { TestBed } from '@angular/core/testing';

import { UserRegisterServiceService } from './user-register-service.service';

describe('UserRegisterServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserRegisterServiceService = TestBed.get(UserRegisterServiceService);
    expect(service).toBeTruthy();
  });
});

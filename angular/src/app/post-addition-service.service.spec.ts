import { TestBed } from '@angular/core/testing';

import { PostAdditionServiceService } from './post-addition-service.service';

describe('PostAdditionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PostAdditionServiceService = TestBed.get(PostAdditionServiceService);
    expect(service).toBeTruthy();
  });
});

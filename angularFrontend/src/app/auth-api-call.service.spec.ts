import { TestBed } from '@angular/core/testing';

import { AuthApiCallService } from './auth-api-call.service';

describe('AuthApiCallService', () => {
  let service: AuthApiCallService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthApiCallService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

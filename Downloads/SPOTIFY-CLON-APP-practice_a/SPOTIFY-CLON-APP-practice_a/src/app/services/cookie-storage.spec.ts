import { TestBed } from '@angular/core/testing';

import { CookieStorage } from './cookie-storage';

describe('CookieStorage', () => {
  let service: CookieStorage;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CookieStorage);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed, inject } from '@angular/core/testing';

import { CapsulaService } from './capsula.service';

describe('CapsulaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CapsulaService]
    });
  });

  it('should be created', inject([CapsulaService], (service: CapsulaService) => {
    expect(service).toBeTruthy();
  }));
});

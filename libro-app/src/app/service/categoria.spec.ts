import { TestBed } from '@angular/core/testing';

import { Categoria } from './categoria';

describe('Categoriaservice', () => {
  let service: Categoriaservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Categoriaservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

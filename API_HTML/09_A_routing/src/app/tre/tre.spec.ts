import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tre } from './tre';

describe('Tre', () => {
  let component: Tre;
  let fixture: ComponentFixture<Tre>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tre]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tre);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

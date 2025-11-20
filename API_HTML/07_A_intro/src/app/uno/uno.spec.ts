import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Uno } from './uno';

describe('Uno', () => {
  let component: Uno;
  let fixture: ComponentFixture<Uno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Uno]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Uno);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

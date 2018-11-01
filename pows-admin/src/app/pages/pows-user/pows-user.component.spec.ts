import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PowsUserComponent } from './pows-user.component';

describe('PowsUserComponent', () => {
  let component: PowsUserComponent;
  let fixture: ComponentFixture<PowsUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PowsUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PowsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TargetSystemsComponent } from './target-systems.component';

describe('TargetSystemsComponent', () => {
  let component: TargetSystemsComponent;
  let fixture: ComponentFixture<TargetSystemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TargetSystemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TargetSystemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertiesStoreComponent } from './properties-store.component';

describe('PropertiesStoreComponent', () => {
  let component: PropertiesStoreComponent;
  let fixture: ComponentFixture<PropertiesStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropertiesStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertiesStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

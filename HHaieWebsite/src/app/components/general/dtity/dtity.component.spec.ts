import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DTITYComponent } from './dtity.component';

describe('DTITYComponent', () => {
  let component: DTITYComponent;
  let fixture: ComponentFixture<DTITYComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DTITYComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DTITYComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

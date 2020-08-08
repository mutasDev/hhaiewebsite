import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SplitInfoComponent } from './split-info.component';

describe('SplitInfoComponent', () => {
  let component: SplitInfoComponent;
  let fixture: ComponentFixture<SplitInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SplitInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SplitInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

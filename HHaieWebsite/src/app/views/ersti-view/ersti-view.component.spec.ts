import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErstiViewComponent } from './ersti-view.component';

describe('ErstiViewComponent', () => {
  let component: ErstiViewComponent;
  let fixture: ComponentFixture<ErstiViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErstiViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErstiViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

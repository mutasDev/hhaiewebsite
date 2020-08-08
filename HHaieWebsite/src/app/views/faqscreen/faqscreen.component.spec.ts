import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FAQScreenComponent } from './faqscreen.component';

describe('FAQScreenComponent', () => {
  let component: FAQScreenComponent;
  let fixture: ComponentFixture<FAQScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FAQScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FAQScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

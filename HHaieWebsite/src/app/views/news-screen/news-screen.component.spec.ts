import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsScreenComponent } from './news-screen.component';

describe('NewsScreenComponent', () => {
  let component: NewsScreenComponent;
  let fixture: ComponentFixture<NewsScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

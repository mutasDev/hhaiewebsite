import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BigPanelComponent } from './big-panel.component';

describe('BigPanelComponent', () => {
  let component: BigPanelComponent;
  let fixture: ComponentFixture<BigPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BigPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BigPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpressumScreenComponent } from './impressum-screen.component';

describe('ImpressumScreenComponent', () => {
  let component: ImpressumScreenComponent;
  let fixture: ComponentFixture<ImpressumScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImpressumScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImpressumScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

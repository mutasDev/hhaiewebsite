import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CasterScreenComponent } from './caster-screen.component';

describe('CasterScreenComponent', () => {
  let component: CasterScreenComponent;
  let fixture: ComponentFixture<CasterScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CasterScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CasterScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

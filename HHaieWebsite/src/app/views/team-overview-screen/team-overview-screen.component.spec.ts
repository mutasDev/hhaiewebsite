import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamOverviewScreenComponent } from './team-overview-screen.component';

describe('TeamOverviewScreenComponent', () => {
  let component: TeamOverviewScreenComponent;
  let fixture: ComponentFixture<TeamOverviewScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamOverviewScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamOverviewScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

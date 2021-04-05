import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadSnackbarComponent } from './upload-snackbar.component';

describe('UploadSnackbarComponent', () => {
  let component: UploadSnackbarComponent;
  let fixture: ComponentFixture<UploadSnackbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadSnackbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadSnackbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

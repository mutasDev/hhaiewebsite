import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatSnackBar, MatSnackBarRef } from '@angular/material';
import { FileUpload } from 'src/app/model/file-upload';
import { FileUploadService } from 'src/app/services/file-upload.service';
import { UploadSnackbarComponent } from '../upload-snackbar/upload-snackbar.component';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.scss']
})
export class FileUploadComponent implements OnInit {
  @Input() text = 'HOCHLADEN';
  @Input() param = 'file';
  @Input() target = '/api/';
  @Input() accept = '';
  @Input() multiple = false;
  @Input() small: boolean = false;
  @Input() disabled: boolean = false;

  @Output() uploadComplete = new EventEmitter<any>();

  // tslint:disable-next-line: no-any
  private snackBarRef: MatSnackBarRef<UploadSnackbarComponent>;

  private files: Array<FileUpload> = [];

  constructor(
    public fileUploadService: FileUploadService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {

  }

  onClick(): void {
    const fileUpload = document.getElementById(
      'fileUpload'
    ) as HTMLInputElement;
    fileUpload.onchange = () => {
      // tslint:disable-next-line: prefer-for-of
      for (let index = 0; index < fileUpload.files.length; index++) {
        const file = fileUpload.files[index];
        let fileUpl: FileUpload = {
          data: file,
          state: 'in',
          inProgress: false,
          progress: 0,
          canRetry: false,
          canCancel: true
        }
        this.files.push(fileUpl);      }
      this.uploadFiles();
    };
    fileUpload.click();
  }

  uploadFiles(): void {
    // tslint:disable-next-line: no-any
    this.fileUploadService.uploadComplete.subscribe((complete: any) => {
      if (this.snackBarRef) {
        this.snackBarRef.dismiss();
      }
      this.uploadComplete.emit(complete);
    });

    const fileUpload = document.getElementById(
      'fileUpload'
    ) as HTMLInputElement;
    fileUpload.value = '';
    this.fileUploadService.uploadFiles(this.files, this.param, this.target);
    this.openSnackBar();
  }

  private openSnackBar(): void {
    this.snackBarRef = this.snackBar.openFromComponent(
      UploadSnackbarComponent,
      {
        data: this.fileUploadService.files,
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
      }
    );
  }
}

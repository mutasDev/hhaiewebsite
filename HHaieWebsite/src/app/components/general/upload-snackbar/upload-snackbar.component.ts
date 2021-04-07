import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_SNACK_BAR_DATA } from '@angular/material';
import { FileUpload } from 'src/app/model/file-upload';
import { FileUploadService } from 'src/app/services/file-upload.service';

@Component({
  selector: 'app-upload-snackbar',
  templateUrl: './upload-snackbar.component.html',
  styleUrls: ['./upload-snackbar.component.scss'],
  animations: [
    trigger('fadeInOut', [
      state('in', style({ opacity: 100 })),
      transition('* => void', [animate(300, style({ opacity: 0 }))]),
    ]),
  ],
})
export class UploadSnackbarComponent implements OnInit{
  constructor(@Inject(MAT_SNACK_BAR_DATA) public data: Array<FileUpload>, private fileUploadService: FileUploadService) { }

  ngOnInit() {
  }
  cancelFile(file: FileUpload): void {
    this.fileUploadService.cancelFile(file);
  }

  retryFile(file: FileUpload): void {
    this.fileUploadService.retryFile(file);
  }
}
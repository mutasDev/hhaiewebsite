import { HttpClient, HttpRequest, HttpEventType, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { of } from 'rxjs';
import { FileUpload } from '../model/file-upload';
import { catchError, last, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class  FileUploadService {


  files: Array<FileUpload> = [];
  responseBodies: any[] = [];
  private param: string;
  private target: string;
  uploadComplete = new EventEmitter();

  constructor(private http: HttpClient) {}

  uploadFiles(files: Array<FileUpload>, param: string, target: string): void {
    this.files = files;
    this.param = param;
    this.target = target;
    this.files.forEach((file) => {
      this.uploadFile(file);
    });
  }


  private uploadFile(file: FileUpload): void {
    const fd = new FormData();
    fd.append(this.param, file.data);

    const req = new HttpRequest('POST', "/api/" + this.target,  fd, {
      reportProgress: true,
    });

    file.inProgress = true;
    file.sub = this.http
      .request(req)
      .pipe(
        map((event) => {
          switch (event.type) {
            case HttpEventType.UploadProgress:
              file.progress = Math.round((event.loaded * 100) / event.total);
              break;
            case HttpEventType.Response:
              return event;
          }
          return undefined;
        }),
        tap((message) => {}),
        last(),
        catchError((error: HttpErrorResponse) => {
          if(error.status == 200) {
            console.log(error, this.responseBodies);
          }
          file.inProgress = false;
          file.canRetry = true;
          return of(`${file.data.name} upload failed.`);
        })
      )
      // tslint:disable-next-line: no-any
      .subscribe((event: any) => {
        if (typeof event === 'object') {
          this.responseBodies.push(event.body);
          this.removeFileFromArray(file);
        } else {
          this.responseBodies.push(event);
          this.removeFileFromArray(file);
        }
      });
  }

  cancelFile(file: FileUpload): void {
    file.sub.unsubscribe();
    this.removeFileFromArray(file);
  }

  retryFile(file: FileUpload): void {
    this.uploadFile(file);
    file.canRetry = false;
  }

  private removeFileFromArray(file: FileUpload): void {
    const index = this.files.indexOf(file);
    if (index > -1) {
      this.files.splice(index, 1);
    }
    if (this.files.length < 1) {
      this.uploadComplete.emit(this.responseBodies);
      this.responseBodies = [];
    }
  }

  deleteFile(id: number, value: string) {
    return this.http.delete('/api/file/' + id + '/' + value);
  }


  downloadFile(contextId: number, fileId: string) {
    let headers = new HttpHeaders({'Content-Type' : 'application/arraybuffer' });
    return this.http.get('/api/file/download/' + contextId + '/' + fileId, { headers: headers, responseType: 'blob' as 'arraybuffer' });
  }
}


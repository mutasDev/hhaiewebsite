import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { BehaviorSubject, Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-secure-image',
  templateUrl: './secure-image.component.html',
  styleUrls: ['./secure-image.component.scss']
})
export class SecureImageComponent implements OnInit {

  @Input() public fileId: string = null;
  @Input() public context: string = "1";
  private fileId$ = new BehaviorSubject(this.fileId);
  dataUrl$ = this.fileId$.pipe(switchMap((fileId) => this.loadFile(fileId)));

  ngOnChanges(): void {
    this.fileId$.next(this.fileId);
  }

  constructor(private http: HttpClient, private domSanitizer: DomSanitizer) { }

  ngOnInit(): void {
  }


  public loadImage(url: string): Observable<any> {
    if(!url) return null;
    return this.http.get(url, { responseType: "blob"}).pipe(
      map((e) => {
        return this.domSanitizer.bypassSecurityTrustResourceUrl(
          URL.createObjectURL(e)
        );
      })
    );
  }

  public loadFile(fileId: string): Observable<any> {
    if (fileId == null) {
      return this.loadImage(null);
    }
    return this.loadImage(
      '/api/file/' + this.context + "/" + fileId
    );
  }
}
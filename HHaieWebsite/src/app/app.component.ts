import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'HHaieWebsite';
  public screenHeight = window.innerHeight;
  public screenWidth = window.innerWidth;

  @HostListener('window-resize', ['$event'])
  onResize(event?) {
    this.screenWidth = window.innerWidth;
    this.screenHeight = window.innerHeight;
    console.log(this.screenWidth);
  }
}

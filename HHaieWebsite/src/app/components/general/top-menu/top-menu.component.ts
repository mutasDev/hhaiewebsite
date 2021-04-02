import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.scss']
})
export class TopMenuComponent implements OnInit {

  public screenWidth: number;
  public screenHeight: number;
  constructor(private router: Router) {
   }

  ngOnInit() {
  }

  @HostListener('window-resize', ['$event'])
  onResize(event?) {
    this.screenWidth = window.innerWidth;
    this.screenHeight = window.innerHeight;
  }

  routeHome() {
    this.router.navigateByUrl("home");
  }

  routeAboutUs() {
    this.router.navigateByUrl("/about");
  }

  routeErstis() {
    this.router.navigateByUrl("/erstis");
  }

  routeTeams() {
    this.router.navigateByUrl("/teams");
  }

  routeFAQ() {
    this.router.navigateByUrl("/faq");
  }

  routeNews() {
    this.router.navigateByUrl("/news");
  }

  scrollToTop() {
    this.router.navigateByUrl("/home");
    window.scrollTo(0, 0);
  }

}

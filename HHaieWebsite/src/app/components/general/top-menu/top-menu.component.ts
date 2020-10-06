import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.scss']
})
export class TopMenuComponent implements OnInit {

  private router: Router;
  constructor(router: Router) {
    this.router = router;
   }

  ngOnInit() {
  }

  routeHome() {
    this.router.navigateByUrl("home");
  }

  routeAboutUs() {
    this.router.navigateByUrl("/about");
  }

  routeTeams() {
    this.router.navigateByUrl("/teams");
  }

  scrollToTop() {
    this.router.navigateByUrl("/home");
    window.scrollTo(0, 0);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.scss']
})
export class HomeScreenComponent implements OnInit {

  private router: Router;

  constructor(router: Router) {
    this.router = router;
   }

   routeToTeams() {
     this.router.navigateByUrl("/teams");
   }

  ngOnInit() {
    window.scrollTo(0, 0);
  }

}

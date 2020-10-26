import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-ersti-view',
  templateUrl: './ersti-view.component.html',
  styleUrls: ['./ersti-view.component.scss']
})
export class ErstiViewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    window.scrollTo(0, 0);
  }

  goToLink(url: string)
  {
    window.open(url, "blank");
  }

}

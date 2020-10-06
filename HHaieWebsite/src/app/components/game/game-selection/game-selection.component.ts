import { Component, OnInit } from "@angular/core";
import { EventEmitter } from 'events';

@Component({
  selector: "app-game-selection",
  templateUrl: "./game-selection.component.html",
  styleUrls: ["./game-selection.component.scss"],
})
export class GameSelectionComponent implements OnInit {

  private game: string;
  public gameChangeEmitter: EventEmitter;

  constructor() {
    this.gameChangeEmitter = new EventEmitter();
  }

  ngOnInit() {}
}

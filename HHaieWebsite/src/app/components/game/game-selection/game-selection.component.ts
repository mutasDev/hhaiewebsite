import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { GameChoiceService } from 'src/app/services/game-choice.service';

@Component({
  selector: "app-game-selection",
  templateUrl: "./game-selection.component.html",
  styleUrls: ["./game-selection.component.scss"],
})
export class GameSelectionComponent implements OnInit {


  private gameChoiceService: GameChoiceService

  @Output()
  private gameChangeEmitter: EventEmitter<undefined>;

  constructor(gameChoiceService: GameChoiceService) {
    this.gameChoiceService = gameChoiceService;
    this.gameChangeEmitter = new EventEmitter();
  }

  swapGame(game: string) {
    this.gameChoiceService.chooseGame(game);
    this.gameChangeEmitter.emit();
  }

  ngOnInit() {}
}

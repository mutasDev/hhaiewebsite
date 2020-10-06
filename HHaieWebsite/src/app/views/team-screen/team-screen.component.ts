import { Component, OnInit } from '@angular/core';
import { GameChoiceService } from 'src/app/services/game-choice.service';

@Component({
  selector: 'app-team-screen',
  templateUrl: './team-screen.component.html',
  styleUrls: ['./team-screen.component.scss']
})
export class TeamScreenComponent implements OnInit {

  private game: string;

  private gameChoiceService: GameChoiceService;

  constructor(gameChoiceService: GameChoiceService) {
    this.gameChoiceService = gameChoiceService;
   }

  ngOnInit() {
    this.game = this.gameChoiceService.getChosenGame();
  }

  changeGame(game: string) {
    this.game = game;
  }
}

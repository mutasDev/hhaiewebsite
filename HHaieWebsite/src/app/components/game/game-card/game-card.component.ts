import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { GameChoiceService } from 'src/app/services/game-choice.service';

@Component({
  selector: 'app-game-card',
  templateUrl: './game-card.component.html',
  styleUrls: ['./game-card.component.scss']
})
export class GameCardComponent implements OnInit {

  private gameChoiceService: GameChoiceService;
  private cd: ChangeDetectorRef;

  constructor(gameChoiceService: GameChoiceService, cd: ChangeDetectorRef) {
    this.gameChoiceService = gameChoiceService;
    this.cd = cd;
   }




  getGame() {
    this.gameChoiceService.getChosenGame();
  }

  ngOnInit() {
  }

  ngOnChanges() {
    this.cd.detectChanges();
  }

}
